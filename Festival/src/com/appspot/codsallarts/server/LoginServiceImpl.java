package com.appspot.codsallarts.server;

import com.appspot.codsallarts.client.LoginInfo;
import com.appspot.codsallarts.client.LoginService;
import com.appspot.codsallarts.client.NotLoggedInException;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements
    LoginService {

	private static final long serialVersionUID = 1L;
	private static String[] ValidEmails = { "james.kingston@gmail.com", "codsallartsfestival@googlemail.com", "peter.birkert@googlemail.com", "flissk@gmail.com" };
	static UserService userService = UserServiceFactory.getUserService();
	
	public LoginInfo login(String requestUri) {
		
		User user = getUser();
		LoginInfo loginInfo = new LoginInfo();

		if (user != null) {
			loginInfo.setLoggedIn(true);
			loginInfo.setEmailAddress(user.getEmail());
			loginInfo.setNickname(user.getNickname());
			loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
		} else {
			loginInfo.setLoggedIn(false);
			loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
		}
		return loginInfo;
	}

	public static boolean isValidEmail(String email){
		for (String valid: ValidEmails){
			if (valid.equals(email)){
				return true;
			}
		}
		return false;
	}
	
	private static User getUser() {
		
		User user = userService.getCurrentUser();
		if (user != null && isValidEmail(user.getEmail())){
			return user;
		}
		return null;
	}
	
	public static void checkLoggedIn() throws NotLoggedInException {
		
		if (getUser() == null) {
			throw new NotLoggedInException("Not logged in.");
		}
	}	
	
}
