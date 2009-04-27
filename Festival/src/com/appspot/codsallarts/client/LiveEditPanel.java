package com.appspot.codsallarts.client;

import com.appspot.codsallarts.client.DoubleClickHtml.SpecialClickHandler;
import com.appspot.codsallarts.client.texteditor.RichTextToolbar;
import com.appspot.codsallarts.client.texteditor.RichTextToolbar.EditCompleteHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class LiveEditPanel extends Composite {

	SimplePanel panel = new SimplePanel();
	String name;
	PageServiceAsync pageService;
	PageVersion pageVersion = null;
	Widget editor;
	private RichTextArea area;
	private RichTextToolbar toolbar;
	boolean editMode = false;
	private DoubleClickHtml html = new DoubleClickHtml("&nbsp;");
	PageResults dataCallback = new PageResults();
	
	public LiveEditPanel(String name) {
		this.name = name;	
		//panel.setHeight("1em");
		//panel.setWidth("100%");
		initWidget(panel);
		pageService = GWT.create(PageService.class);		
		pageService.getLatestPage(name, dataCallback);
		html.setClickHandler(htmlClickedHandler);
		html.setSize("100%", "3 em");
		
	}
	

	
	private class PageResults implements AsyncCallback<PageVersion>{

		public void onFailure(Throwable caught) {
			
			LiveEditPanel.this.setContent(new HTML("No results"));			
		}

		public void onSuccess(PageVersion result) {
			pageVersion = result;
			LiveEditPanel.this.showHTML();			
		}
		
	}
	
	private DoubleClickHtml.SpecialClickHandler htmlClickedHandler = new SpecialClickHandler(){

		public void clicked(int type, Widget sender) {
			if (! Login.isLoggedIn()){
				return;
			}
			if (sender == html){
				if ((type == Event.ONDBLCLICK) || (type == Event.ONCONTEXTMENU)) {
					LiveEditPanel.this.showEditor();
				}
			}
			
		}
		
	};
	
	private RichTextToolbar.EditCompleteHandler editCompleteHandler = new EditCompleteHandler(){

		public void cancel() {
			showHTML();
		}

		public void save() {
			PageVersion newPageVersion = new PageVersion();
			newPageVersion.setPageName(name);
			newPageVersion.setContent(area.getHTML());
			LiveEditPanel.this.setContent(new HTML("Loading"));
			pageService.store(newPageVersion, dataCallback);
		}
		
	};

	public void setContent(Widget w) {
		panel.setWidget(w);
	}

	protected void showEditor() {
		if (! editMode){
			
			getEditorWidget();
			if (pageVersion != null){
				area.setHTML(pageVersion.getContent());
			}
			setContent(editor);
			editMode = true;
		}
	}

	private void showHTML(){
		if (pageVersion != null){
			html.setHTML(pageVersion.getContent());
			setContent(html);
			editMode = false;
		}
	}
	
	private Widget getEditorWidget(){
		if (editor == null){
			// Create the text area and toolbar
			area = new RichTextArea();
			area.setSize("100%", "100%");
			toolbar = new RichTextToolbar(area, editCompleteHandler);
			toolbar.setWidth("100%");

			// Add the components to a panel
			Grid grid = new Grid(2, 1);
			grid.setStyleName("cw-RichText");
			grid.setWidget(0, 0, toolbar);
			grid.setWidget(1, 0, area);
			editor = grid;
		} 

		return editor;
		
	}

	
	
	

}
