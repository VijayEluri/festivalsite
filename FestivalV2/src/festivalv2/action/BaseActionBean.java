/***
 * Excerpted from "Stripes: and Java Web Development is Fun Again",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/fdstr for more book information.
***/

package festivalv2.action;

import java.util.LinkedList;
import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import festivalv2.LoginInfo;
import festivalv2.services.LoginServiceImpl;

public abstract class BaseActionBean implements ActionBean {
	
	private String originalUrl;
    private ActionBeanContext ctx;
    private LoginInfo login;
    public ActionBeanContext getContext() { return ctx; }
    
    
    public void setContext(ActionBeanContext ctx) { 
    	this.ctx = ctx; 
    	setOriginalUrlFromContext();
    }
	public LoginInfo getLogin() {
		if (login == null){
			
			login = new LoginServiceImpl().login(getOriginalUrl());	
		}
		
		return login;
	}
	public void setLogin(LoginInfo login) {
		this.login = login;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String callingUrl) {
		this.originalUrl = callingUrl;
	}
	
	public void setOriginalUrlFromContext() {
		originalUrl = (String)ctx.getRequest().getAttribute("javax.servlet.forward.request_uri");
		if (originalUrl == null){
			originalUrl = ctx.getRequest().getRequestURI();
		}
	}
	
	private List<String> messages = new LinkedList<String>();

	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public boolean isMessageAvailable(){
		return messages.size() > 0;
	}
	
	
}

