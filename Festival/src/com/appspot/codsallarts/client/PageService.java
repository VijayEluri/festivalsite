package com.appspot.codsallarts.client;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("page")
public interface PageService extends RemoteService  {

	public PageVersion store(PageVersion page);
	public PageVersion getPage(long id) throws PageNotFoundException;
	public PageVersion getLatestPage(String name) throws PageNotFoundException;
	
}
