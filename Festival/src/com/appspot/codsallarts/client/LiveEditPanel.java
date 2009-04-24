package com.appspot.codsallarts.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class LiveEditPanel extends SimplePanel {

	String name;
	PageServiceAsync pageService;
	PageVersion pageVersion = null;
	
	public LiveEditPanel(String name) {
		this.name = name;	
		
		pageService = GWT.create(PageService.class);		
		pageService.getLatestPage(name, new PageResults());
		
	}
	
	private class PageResults implements AsyncCallback<PageVersion>{

		public void onFailure(Throwable caught) {
			
			LiveEditPanel.this.setContent(new HTML("No results"));			
		}

		public void onSuccess(PageVersion result) {
			pageVersion = result;
			LiveEditPanel.this.setContent(new HTML(pageVersion.getContent()));			
		}
		
	}

	public void setContent(Widget w) {
		this.setWidget(w);
	}
	

}
