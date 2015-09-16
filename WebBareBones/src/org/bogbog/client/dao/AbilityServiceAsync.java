package org.bogbog.client.dao;

import org.bogbog.shared.Ability;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AbilityServiceAsync {

	void create(Ability entity, AsyncCallback<Ability> callback);

	void delete(String key, AsyncCallback<Void> callback);

	void query(QueryManager<Ability> queryManager,
			AsyncCallback<QueryManager<Ability>> callback);

	void read(String key, AsyncCallback<Ability> callback);

	void update(Ability entity, String key, AsyncCallback<Void> callback);

}
