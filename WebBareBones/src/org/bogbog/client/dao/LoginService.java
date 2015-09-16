package org.bogbog.client.dao;

import org.bogbog.shared.LoginInfo;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService extends Dao<LoginInfo> {
	public LoginInfo login(String requestUri);

	public LoginInfo create(LoginInfo entity);

	public LoginInfo read(String key);

	public void update(LoginInfo entity, String key);

	public void delete(String key);

	public QueryManager<LoginInfo> query(QueryManager<LoginInfo> queryManager);
}
