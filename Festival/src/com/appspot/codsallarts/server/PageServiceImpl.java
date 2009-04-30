package com.appspot.codsallarts.server;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.appspot.codsallarts.client.NotLoggedInException;
import com.appspot.codsallarts.client.PageNotFoundException;
import com.appspot.codsallarts.client.PageService;
import com.appspot.codsallarts.client.PageVersion;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PageServiceImpl extends RemoteServiceServlet implements PageService {

	  private static final Logger LOG = Logger.getLogger(PageServiceImpl.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");

	private static final long serialVersionUID = 1L;


	public PageVersion store(PageVersion page) throws NotLoggedInException {
		
		LoginServiceImpl.checkLoggedIn();
		PersistenceManager pm = getPersistenceManager();
		try {
			PageVersionPersistable storable = new PageVersionPersistable();
			storable.setContent(page.getContent());
			storable.setPageName(page.getPageName());
			storable.setCreatedAt(new Date());
			if (page.getId() != 0){
				storable.setId(page.getId());
			}

			pm.makePersistent(storable);

			PageVersion newPage = new PageVersion();
			newPage.setPageName(storable.getPageName());
			newPage.setContent(storable.getContent());
			newPage.setCreatedAt(storable.getCreatedAt());
			newPage.setId(storable.getId());
			LOG.warning("Created PageVersion with ID " + newPage.getId());
			return newPage;
		} finally {
			pm.close();
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public PageVersion getPage(long id) throws PageNotFoundException, NotLoggedInException {
		LoginServiceImpl.checkLoggedIn();
		PersistenceManager pm = getPersistenceManager();
		List <PageVersionPersistable> results = null;
		try {
			Query q = pm.newQuery(PageVersionPersistable.class, "id == i");
			q.declareParameters("long i");
			results = (List <PageVersionPersistable>)q.execute(id);
		} finally {
			pm.close();
		}

		if (results == null || results.size() == 0){
			throw new PageNotFoundException();
		}
		
		PageVersionPersistable persisted = results.get(0);
		return makeClientVersion(persisted);
	}

	@SuppressWarnings("unchecked")
	public PageVersion getLatestPage(String name) throws NotLoggedInException {
		PersistenceManager pm = getPersistenceManager();
		List<PageVersionPersistable> results = null;
		try {
		Query q = pm.newQuery(PageVersionPersistable.class);
		q.setFilter("pageName == name");

		q.declareParameters("String name");

		q.setOrdering("createdAt desc");

		q.setRange(0,1);

		results = (List<PageVersionPersistable>) q.execute(name);
		
		if (results == null || results.isEmpty()){
			PageVersion page = new PageVersion();
			page.setPageName(name);
			page.setContent("Double-click to start");
			return page;
		} else {
			PageVersionPersistable persisted = results.get(results.size() - 1);
			
			return makeClientVersion(persisted);
		}

		
		} finally {
			pm.close();
		}
}


	private PageVersion makeClientVersion(PageVersionPersistable persisted) {
		PageVersion page = new PageVersion();
		page.setContent(persisted.getContent());
		page.setCreatedAt(persisted.getCreatedAt());
		page.setId(persisted.getId());
		page.setPageName(persisted.getPageName());
		return page;
	}

	private PersistenceManager getPersistenceManager() {
		return PMF.getPersistenceManager();
	}



}
