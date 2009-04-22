package com.appspot.codsallarts.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Festival implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */

	Panel rootPanel;
	DockPanel dockPanel;
	
	LiveEditPanel header;
	
	TabBar tabs;
	
	VerticalPanel newsBar;
	LiveEditPanel newsPanel;
	LiveEditPanel sponsorPanel;
	
	HorizontalPanel footerWrapper;
	LiveEditPanel footer;
	
	VerticalPanel body;
	
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		rootPanel = RootPanel.get();
		dockPanel = new DockPanel();
		header = new LiveEditPanel("header");
		tabs = new TabBar();
		newsBar = new VerticalPanel();
		newsPanel = new LiveEditPanel("News");
		sponsorPanel = new LiveEditPanel("Sponsors");
		footerWrapper = new HorizontalPanel();
		footer = new LiveEditPanel("footer");
		body = new VerticalPanel();
		
		
	}
}
