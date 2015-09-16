package org.bogbog.server;

import java.util.Date;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.bogbog.client.dao.CharacterService;
import org.bogbog.server.dao.DaoImpl;
import org.bogbog.shared.Character;
import org.bogbog.shared.QueryManager;

@SuppressWarnings("serial")
public class CharacterServiceImpl extends DaoImpl<Character> implements
		CharacterService {

	public CharacterServiceImpl() {
		super(Character.class);
	}

	@Override
	public Character create(Character entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Character detatched = null;
		try {
			entity.date = new Date();

			// now we can save the character
			tx.begin();
			pm.makePersistent(entity);
			detatched = pm.detachCopy(entity);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
		pm.close();
		return detatched;
	}

	@Override
	public Character read(String keyString) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Character character, detatched = null;
		try {
			character = pm.getObjectById(Character.class, keyString);
			character.getRace();
			character.getAbilities();
			character.getSkills();
			detatched = pm.detachCopy(character);
		} finally {
			pm.close();
		}
		return detatched;
	}

	@Override
	public void update(Character entity, String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public QueryManager<Character> query(QueryManager<Character> queryManager) {
		// TODO Auto-generated method stub
		return null;
	}
}
