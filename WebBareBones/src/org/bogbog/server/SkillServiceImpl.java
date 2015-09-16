package org.bogbog.server;

import javax.jdo.PersistenceManager;

import org.bogbog.client.dao.SkillService;
import org.bogbog.server.dao.DaoImpl;
import org.bogbog.shared.QueryManager;
import org.bogbog.shared.Skill;

@SuppressWarnings("serial")
public class SkillServiceImpl extends DaoImpl<Skill> implements SkillService {

	public SkillServiceImpl() {
		super(Skill.class);
	}

	@Override
	public Skill create(Skill entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Skill detached = null;
		try {
			pm.makePersistent(entity);
			detached = pm.detachCopy(entity);
		} finally {
			pm.close();
		}
		return detached;
	}

	@Override
	public Skill read(String key) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Skill skill, detatched = null;
		try {
			skill = pm.getObjectById(Skill.class, key);
			detatched = pm.detachCopy(skill);
		} finally {
			pm.close();
		}
		return detatched;
	}

	@Override
	public void update(Skill entity, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public QueryManager<Skill> query(QueryManager<Skill> queryManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
