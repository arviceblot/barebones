package org.bogbog.server.dao;

import java.util.logging.Logger;

import org.bogbog.client.dao.Dao;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public abstract class DaoImpl<T> extends RemoteServiceServlet implements Dao<T> {

	protected Class<T> tClass;
	protected static final Logger LOG = Logger.getLogger(DaoImpl.class
			.getName());

	public DaoImpl(Class<T> tClass) {
		this.tClass = tClass;
	}

	@Override
	public abstract T create(T entity);

	@Override
	public abstract T read(String key);

	@Override
	public abstract void update(T entity, String key);

	@Override
	public abstract void delete(String key);

	@Override
	public abstract QueryManager<T> query(QueryManager<T> queryManager);
}
