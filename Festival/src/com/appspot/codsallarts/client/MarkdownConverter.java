package com.appspot.codsallarts.client;

public class MarkdownConverter {
	
	Object converterOb;
	
	public MarkdownConverter(){
		converterOb = makeConverter();
	}
	static private native Object makeConverter() /*-{
	    return new $wnd.Attacklab.showdown.converter();
	  }-*/;

	public String convertText(String md){
		return convertNative(converterOb, md);
	}
	
	private native String convertNative(Object converter, String md) /*-{
		
	  return converter.makeHtml(md);
	  }-*/;

}
