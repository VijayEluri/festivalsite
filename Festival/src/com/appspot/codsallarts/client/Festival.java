package com.appspot.codsallarts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Festival implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */

	private Application app = new Application();
	
	
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get().add(app);
		app.addLink(new HTML("<a href=\"login.html\">Login</a>"));
		
		setTitle();
		
	}




	private void setTitle() {
		String pageTitle = "<h1>Codsall Arts Festival</h1><h2>3-5 July, 2009</h2>";

		// Add the title and some images to the title bar
		HorizontalPanel titlePanel = new HorizontalPanel();
		titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		//titlePanel.add(images.gwtLogo().createImage());
		titlePanel.add(new HTML(pageTitle));
		app.setTitleWidget(titlePanel);
//
	}
}
