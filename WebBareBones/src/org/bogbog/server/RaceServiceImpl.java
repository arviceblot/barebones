package org.bogbog.server;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.bogbog.client.dao.RaceService;
import org.bogbog.server.dao.DaoImpl;
import org.bogbog.shared.QueryManager;
import org.bogbog.shared.Race;

@SuppressWarnings("serial")
public class RaceServiceImpl extends DaoImpl<Race> implements RaceService {

	public RaceServiceImpl() {
		super(Race.class);
	}

	@Override
	public Race create(Race entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Race detached = null;
		try {
			tx.begin();
			// now create it
			pm.makePersistent(entity);
			detached = pm.detachCopy(entity);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
		pm.close();
		return detached;
	}

	@Override
	public Race read(String key) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Race race, detatched = null;
		try {
			race = pm.getObjectById(Race.class, key);
			race.getAbilityModifiers();
			detatched = pm.detachCopy(race);

		} finally {
			pm.close();
		}
		return detatched;
	}

	@Override
	public void update(Race entity, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public QueryManager<Race> query(QueryManager<Race> queryManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
