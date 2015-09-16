package org.bogbog.server;

import javax.jdo.PersistenceManager;

import org.bogbog.client.dao.AbilityService;
import org.bogbog.server.dao.DaoImpl;
import org.bogbog.shared.Ability;
import org.bogbog.shared.QueryManager;

@SuppressWarnings("serial")
public class AbilityServiceImpl extends DaoImpl<Ability> implements
		AbilityService {

	public AbilityServiceImpl() {
		super(Ability.class);
	}

	@Override
	public Ability create(Ability entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Ability detatched = null;
		try {
			pm.makePersistent(entity);
			detatched = pm.detachCopy(entity);
		} finally {
			pm.close();
		}
		return detatched;
	}

	@Override
	public Ability read(String key) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Ability ability, detatched = null;
		try {
			ability = pm.getObjectById(Ability.class, key);
			detatched = pm.detachCopy(ability);
		} finally {
			pm.close();
		}
		return detatched;
	}

	@Override
	public void update(Ability entity, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public QueryManager<Ability> query(QueryManager<Ability> queryManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
