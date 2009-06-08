package festivalv2.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.Validate;
import com.petebevin.markdown.MarkdownProcessor;

import festivalv2.NotLoggedInException;
import festivalv2.PageNotFoundException;
import festivalv2.entities.PageVersionPersistable;
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
			getContext().getMessages().add(
					new SimpleMessage("Cannot save: not logged in")
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
		MarkdownProcessor md = new MarkdownProcessor();
		return md.markdown(page.getContent());
	}



	private void loadPage() {
		PageService pageService = new PageService();

		if (page.getId() !=0){

			try {
				page=pageService.getPage(page.getId());

			} catch (PageNotFoundException e) {
				getContext().getMessages().add(
						new SimpleMessage("Did not have a version {0} for page {1}", page.getId(), page.getPageName()));
			}
		} else {
			try {
				page = pageService.getLatestPage(page.getPageName());
			} catch (PageNotFoundException e) {
				getContext().getMessages().add(
						new SimpleMessage("Page {0} has not been created", page.getPageName()));			
			}
		}
		
		try {
			setAllPages(pageService.getAllVersionsOfPage(page.getPageName()));
		} catch (PageNotFoundException e) {
			getContext().getMessages().add(
					new SimpleMessage("Could not load old version of Page {0}", page.getPageName()));			
		}
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
