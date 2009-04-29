package com.appspot.codsallarts.client;

public class MarkdownConverter {
	
	static Object converterOb;
	
	static {
		converterOb = makeConverter();
	}
	
	static private native Object makeConverter() /*-{
	    return new $wnd.Attacklab.showdown.converter();
	  }-*/;

	public static String convertText(String md){
		return convertNative(converterOb, md);
	}
	
	private static native String convertNative(Object converter, String md) /*-{
		
	  return converter.makeHtml(md);
	  }-*/;

}
