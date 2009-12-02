package festivalv2.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.Validate;

import com.google.appengine.api.urlfetch.HTTPRequest;
import com.petebevin.markdown.MarkdownProcessor;
import com.sun.tools.internal.ws.wsdl.document.http.HTTPConstants;

import festivalv2.NotLoggedInException;
import festivalv2.PageNotFoundException;
import festivalv2.entities.PageVersionPersistable;
import festivalv2.entities.UserSession;
import festivalv2.services.PageService;

public class LoadPageActionBean extends BaseActionBean {

	@ValidateNestedProperties({
		@Validate(field="pageName" , required=true)
	})
	
	private PageVersionPersistable page = new PageVersionPersistable();
	private List<PageVersionPersistable> allPages;

	@DefaultHandler
	public Resolution view(){
		loadPage();			    
		return new ForwardResolution("/WEB-INF/jsp/displayPage.jsp");
	}


	public Resolution edit(){
		loadPage();
		return new ForwardResolution("/WEB-INF/jsp/editPage.jsp");
	}

	public Resolution save(){
		PageService pageService = new PageService();
		try {
			page.setId(0);
			pageService.store(page); 
		} catch (NotLoggedInException e) {
			getMessages().add(
					new SimpleMessage("Cannot save: not logged in").getMessage(getContext().getLocale())
			);		
		}
			
		return new RedirectResolution(LoadPageActionBean.class)
			.addParameter("page.pageName", page.getPageName());
	}
	
	public Resolution cancel(){
		return new RedirectResolution(LoadPageActionBean.class)
			.addParameter("page.pageName", page.getPageName())
			.addParameter("page.id", page.getId());			
	}
	

	public String getHtml(){
		if (page == null || page.getContent() == null){
			return "";
		}
		
		MarkdownProcessor md = new MarkdownProcessor();
		return md.markdown(page.getContent());
	}



	private void loadPage() {
		PageService pageService = new PageService();
		updateSession(pageService);
		if (page.getId() !=0){

			try {
				page=pageService.getPage(page.getId());

			} catch (PageNotFoundException e) {
				getMessages().add(
						new SimpleMessage("Did not have a version {0} for page {1}", page.getId(), page.getPageName()).getMessage(getContext().getLocale()));
			}
		} else {
			try {
				page = pageService.getLatestPage(page.getPageName());
			} catch (PageNotFoundException e) {
				getMessages().add(
						new SimpleMessage("Page {0} has not been created", page.getPageName()).getMessage(getContext().getLocale()));			
			}
		}
		
		try {
			setAllPages(pageService.getAllVersionsOfPage(page.getPageName()));
		} catch (PageNotFoundException e) {
			getMessages().add(
					new SimpleMessage("Could not load old version of Page {0}", page.getPageName()).getMessage(getContext().getLocale()));			
		}
	}

	
	private void updateSession(PageService pageService) {
		HttpSession httpSession = getContext().getRequest().getSession(true);
		UserSession userSession = pageService.getSavedSession(httpSession.getId());
		if (userSession == null){
			userSession = new UserSession();
			userSession.setId(httpSession.getId());
			userSession.setStart(new Date());
			userSession.setRefer(getContext().getRequest().getHeader("Referer"));
			userSession.setIpAddress(getContext().getRequest().getRemoteAddr());
		}
		userSession.setEnd(new Date());
		String username = (String)httpSession.getAttribute(UserSession.USER_ATTR);
		if (username != null){
			userSession.setEmailAddress(username);
		}
		
		Date startDate
		
		
	}


	public PageVersionPersistable getPage() {
		return page;
	}


	public void setPage(PageVersionPersistable page) {
		this.page = page;
	}


	public void setAllPages(List<PageVersionPersistable> allPages) {
		this.allPages = allPages;
	}


	public List<PageVersionPersistable> getAllPages() {
		return allPages;
	}


}
