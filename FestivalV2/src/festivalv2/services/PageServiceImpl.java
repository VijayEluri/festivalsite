package festivalv2.services;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import festivalv2.NotLoggedInException;
import festivalv2.PageNotFoundException;
import festivalv2.entities.PageVersionPersistable;



public class PageServiceImpl implements PageService {

	  private static final Logger LOG = Logger.getLogger(PageServiceImpl.class.getName());
	  private static final PersistenceManagerFactory PMF =
	      JDOHelper.getPersistenceManagerFactory("transactions-optional");

	private static final long serialVersionUID = 1L;


	synchronized public PageVersionPersistable store(PageVersionPersistable page) throws NotLoggedInException {
		
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

			LOG.warning("Created PageVersion with ID " + storable.getId());
			return storable;
		} finally {
			pm.close();
		}

	}
	
	
	@SuppressWarnings("unchecked")
	synchronized public PageVersionPersistable getPage(long id) throws PageNotFoundException, NotLoggedInException {
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
		return persisted;
	}

	@SuppressWarnings("unchecked")
	synchronized public PageVersionPersistable getLatestPage(String name) throws PageNotFoundException {
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
			
			throw new PageNotFoundException();
		} else {
			PageVersionPersistable persisted = results.get(results.size() - 1);
			
			return persisted;
		}

		
		} finally {
			pm.close();
		}
}



	private PersistenceManager getPersistenceManager() {
		return PMF.getPersistenceManager();
	}



}
