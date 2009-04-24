package com.appspot.codsallarts.client;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PageServiceAsync {

	public void store(PageVersion page, AsyncCallback<PageVersion> callback);
	public void getPage(long id, AsyncCallback<PageVersion> callback);
	public void getLatestPage(String name, AsyncCallback<PageVersion> callback);

}
