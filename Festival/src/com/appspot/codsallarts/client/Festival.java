package com.appspot.codsallarts.client;

import com.google.gwt.core.client.*;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.DockPanel.DockLayoutConstant;

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
	
	DecoratorPanel rightBar;
	VerticalPanel newsBar;
	HTML newsPanel;
	HTML sponsorPanel;
	
	HorizontalPanel footerWrapper;
	HTML footer;
	
	VerticalPanel body;
	
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		rootPanel = RootPanel.get();
		
		dockPanel = new DockPanel();
		dockPanel.setWidth("80%");
		header = new LiveEditPanel("header");
		header.setWidth("100%");
		header.addStyleName("header");
		
		dockPanel.add(header, DockPanel.NORTH);
		footerWrapper = new HorizontalPanel();
		dockPanel.add(footerWrapper, DockPanel.SOUTH);
		footer = new HTML("footer");
		
		footerWrapper.add(footer);
		footerWrapper.addStyleName("footer");
		footerWrapper.setWidth("100%");
		
		rightBar = new DecoratorPanel();
		rightBar.setStylePrimaryName("right-bar");
		newsBar = new VerticalPanel();
		rightBar.add(newsBar);
		
		dockPanel.add(newsBar, DockPanel.EAST);
		
		
		tabs = new DecoratedTabBar();
		tabs.addTab(new Anchor("Yo"));
		tabs.addTab(new Anchor("Yo"));
		tabs.addTab(new Anchor("Yo"));
		tabs.addTab(new Anchor("Yo"));
		tabs.setTabEnabled(1, true);
		dockPanel.add(tabs, DockPanel.NORTH);
		
		
		newsPanel = new HTML("News");
		DecoratorPanel dpNews = new DecoratorPanel();
		dpNews.add(newsPanel);
		newsBar.add(dpNews);
		
		sponsorPanel = new HTML("Sponsors");
		DecoratorPanel dpSponsors = new DecoratorPanel();
		dpSponsors.add(sponsorPanel);
		newsBar.add(dpSponsors);
		
		body = new VerticalPanel();
		dockPanel.add(body, DockPanel.CENTER);
		body.add(new HTMLPanel("body"));

		rootPanel.add(dockPanel);
	}
}
