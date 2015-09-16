package org.bogbog.client.dao;

import org.bogbog.shared.Character;
import org.bogbog.shared.LoginInfo;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	public void login(String requestUri, AsyncCallback<LoginInfo> callback);

	public void create(LoginInfo entity, AsyncCallback<LoginInfo> callback);

	public void delete(String key, AsyncCallback<Void> callback);

	public void query(QueryManager<Character> queryManager,
			AsyncCallback<QueryManager<LoginInfo>> callback);

	public void read(String key, AsyncCallback<LoginInfo> callback);

	public void update(LoginInfo entity, String key,
			AsyncCallback<Void> callback);
}
