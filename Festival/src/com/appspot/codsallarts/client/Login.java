package com.appspot.codsallarts.client;

public class Login {


	private static LoginInfo user = new LoginInfo();

	public static void setLogin(LoginInfo result) {
		user = result;
	}

	public static String getLoginUrl() {

		return user.getLoginUrl();
	}

	public static String getLogoutUrl() {
		return user.getLogoutUrl();
	}

	public static boolean isLoggedIn() {
		return user.isLoggedIn();
	}
	
	
}
