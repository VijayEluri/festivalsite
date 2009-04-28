package com.appspot.codsallarts.client;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("page")
public interface PageService extends RemoteService  {

	public PageVersion store(PageVersion page) throws NotLoggedInException;
	public PageVersion getPage(long id) throws PageNotFoundException, NotLoggedInException;
	public PageVersion getLatestPage(String name) throws PageNotFoundException, NotLoggedInException;
	
}
