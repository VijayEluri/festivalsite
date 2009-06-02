package festivalv2.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class LoadPageActionBean extends BaseActionBean {

	private String pageName = "index";
	private String content = "index content";

	@DefaultHandler
	public Resolution view(){
	    getContext().getRequest().setAttribute("content", content);
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


	
}
