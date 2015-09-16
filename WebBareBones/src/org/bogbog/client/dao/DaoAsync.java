package org.bogbog.client.dao;

import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DaoAsync<T> {

	void create(T entity, AsyncCallback<T> callback);

	void read(String key, AsyncCallback<T> callback);

	void update(T entity, String key, AsyncCallback<Void> callback);

	void delete(String key, AsyncCallback<Void> callback);

	void query(QueryManager<T> queryManager, AsyncCallback<QueryManager<T>> callback);
}
