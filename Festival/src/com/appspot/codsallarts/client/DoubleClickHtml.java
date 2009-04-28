package com.appspot.codsallarts.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class DoubleClickHtml extends HTML {
	private SpecialClickHandler handler;

	public DoubleClickHtml(){
		super();
		this.sinkEvents(Event.ONDBLCLICK);  //Sink the double click			 
		this.sinkEvents(Event.ONCONTEXTMENU);  //Sink the double click
	}

	public DoubleClickHtml(String html) {
		this();
		this.setHTML(html);
	}

	public void onBrowserEvent(Event event) {
		super.onBrowserEvent(event);    // Handle events as a normal Label would
		int type = DOM.eventGetType(event);  // Look at the type of event again
		switch (type) {
			case Event.ONDBLCLICK: {    
				if (handler != null){
					handler.clicked(Event.ONDBLCLICK, this);
				}
				break;
			}
			case Event.ONCONTEXTMENU: {    // If it is a double click event,
				if (handler != null){
					handler.clicked(Event.ONCONTEXTMENU, this);
				}
				break;
			}
			default:
				break;
		}
	} 
	
	public void setClickHandler (SpecialClickHandler handler){
		this.handler = handler;
	}
	
	public interface SpecialClickHandler{
		public void clicked(int type, Widget sender);
	};
	
}