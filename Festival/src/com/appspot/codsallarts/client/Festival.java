package com.appspot.codsallarts.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
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
	
	
	

	public void onModuleLoad() {
		RootPanel.get().add(app);
		app.addLink(new HTML("<a href=\"login.html\">Admin login</a>"));
		
		setTitle();
		app.setContent(new LiveEditPanel("welcome"));
		app.setContentTitle(new Hyperlink("Home", "home"));
	}




	private void setTitle() {
		String pageTitle = "<h1>Codsall Arts Festival 2010</h1><h2>Sat, 6th March thru Sun, 21st March</h2>";

		// Add the title and some images to the title bar
		HorizontalPanel titlePanel = new HorizontalPanel();
		titlePanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		titlePanel.add(new Image("jimmyThumb.jpg"));
		titlePanel.add(new HTML(pageTitle));
		app.setTitleWidget(titlePanel);
//
	}
}
