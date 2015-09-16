package org.bogbog.server;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.bogbog.client.dao.LoginService;
import org.bogbog.server.dao.DaoImpl;
import org.bogbog.shared.LoginInfo;
import org.bogbog.shared.QueryManager;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class LoginServiceImpl extends DaoImpl<LoginInfo> implements
		LoginService {

	private CharacterServiceImpl characterService;

	public LoginServiceImpl() {
		super(LoginInfo.class);
		characterService = new CharacterServiceImpl();
	}

	public LoginInfo login(String requestUri) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		LoginInfo loginInfo = new LoginInfo();

		if (user != null) {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try {
				// check the datastore for the email
				Query q = pm.newQuery("SELECT FROM "
						+ LoginInfo.class.getName() + " "
						+ "WHERE emailAddress == emailParam "
						+ "PARAMETERS String emailParam");
				List<LoginInfo> results = (List<LoginInfo>) q.execute(user
						.getEmail());
				results = (List<LoginInfo>) pm.detachCopyAll(results);

				if (!results.isEmpty()) {
					loginInfo = results.get(0);
					loginInfo.setLoggedIn(true);
					loginInfo.setNickname(user.getNickname());
					loginInfo.setLogoutUrl(userService
							.createLogoutURL(requestUri));

					loginInfo.getCharacters();
				} else {
					// create if not found
					loginInfo.setLoggedIn(true);
					loginInfo.setEmailAddress(user.getEmail());
					loginInfo.setNickname(user.getNickname());
					loginInfo.setLogoutUrl(userService
							.createLogoutURL(requestUri));
					loginInfo = this.create(loginInfo);
				}
			} finally {
				pm.close();
			}
		} else {
			loginInfo.setLoggedIn(false);
			loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
		}
		return loginInfo;
	}

	@Override
	public LoginInfo create(LoginInfo entity) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		LoginInfo detached = null;
		try {
			tx.begin();
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
	public LoginInfo read(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(LoginInfo entity, String key) {
		// there shouldn't really be any difference from create() since make
		// persistent
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			// should probably check the key instead
			pm.makePersistent(entity);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub

	}

	@Override
	public QueryManager<LoginInfo> query(QueryManager<LoginInfo> queryManager) {
		// TODO Auto-generated method stub
		return null;
	}

}
