package festivalv2.services;

import festivalv2.NotLoggedInException;
import festivalv2.PageNotFoundException;
import festivalv2.entities.PageVersionPersistable;

public interface PageService   {

	public PageVersionPersistable store(PageVersionPersistable page) throws NotLoggedInException;
	public PageVersionPersistable getPage(long id) throws PageNotFoundException, NotLoggedInException;
	public PageVersionPersistable getLatestPage(String name) throws PageNotFoundException;
	
}
