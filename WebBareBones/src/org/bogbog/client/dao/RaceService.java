package org.bogbog.client.dao;

import org.bogbog.shared.QueryManager;
import org.bogbog.shared.Race;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("race")
public interface RaceService extends Dao<Race> {

	public Race create(Race entity);

	public Race read(String key);

	public void update(Race entity, String key);

	public void delete(String key);

	public QueryManager<Race> query(QueryManager<Race> queryManager);
}
