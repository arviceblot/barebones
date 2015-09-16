package org.bogbog.client.dao;

import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.RemoteService;

public interface Dao<T> extends RemoteService {

	public T create(T entity);

	public T read(String key);

	public void update(T entity, String key);

	public void delete(String key);
	
	public QueryManager<T> query(QueryManager<T> queryManager);
}
