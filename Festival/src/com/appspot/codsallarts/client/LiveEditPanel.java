package com.appspot.codsallarts.client;

import com.appspot.codsallarts.client.images.FestivalIconBundle;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class LiveEditPanel extends SimplePanel {

	String name;
	PageServiceAsync pageService;
	PageVersion pageVersion = null;

	FestivalIconBundle icons = (FestivalIconBundle)GWT.create(FestivalIconBundle.class);
	
	public LiveEditPanel(String name) {
		this.name = name;	
		
		pageService = GWT.create(PageService.class);	
		setLoading();
		pageService.getLatestPage(name, new PageResults());
		
	}

	private void setLoading() {
		this.setContent(new Image("images/loading.gif"));
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
