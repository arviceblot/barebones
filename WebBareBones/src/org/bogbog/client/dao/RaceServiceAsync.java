package org.bogbog.client.dao;

import org.bogbog.shared.QueryManager;
import org.bogbog.shared.Race;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RaceServiceAsync {

	void create(Race entity, AsyncCallback<Race> callback);

	void delete(String key, AsyncCallback<Void> callback);

	void query(QueryManager<Race> queryManager,
			AsyncCallback<QueryManager<Race>> callback);

	void read(String key, AsyncCallback<Race> callback);

	void update(Race entity, String key, AsyncCallback<Void> callback);

}
