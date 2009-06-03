package festivalv2.action;

import com.petebevin.markdown.MarkdownProcessor;

import festivalv2.PageNotFoundException;
import festivalv2.entities.PageVersionPersistable;
import festivalv2.services.PageService;
import festivalv2.services.PageServiceImpl;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class LoadPageActionBean extends BaseActionBean {

	private String pageName = "index";
	private String content = "index content";

	@DefaultHandler
	public Resolution view(){
		PageService pageService = new PageServiceImpl();
		try {
			PageVersionPersistable page = pageService.getLatestPage(pageName);
			content = page.getContent();
		} catch (PageNotFoundException e) {
			if (getLogin().isLoggedIn()){
				content = "## New page\n\nDouble click to edit." + "<!-- " + e.getMessage() + " -->";
			} else {
				content = "<!-- " + e.getMessage() + " -->";
			}
		}
			    
		return new ForwardResolution("/WEB-INF/jsp/displayPage.jsp");
	}
	
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
		this.content = pageName + " stuff";
	}
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHtml(){
		MarkdownProcessor md = new MarkdownProcessor();
		return md.markdown(content);
	}
	
}
