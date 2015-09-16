package org.bogbog.client.dao;

import org.bogbog.shared.Ability;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ability")
public interface AbilityService extends Dao<Ability> {

	public Ability create(Ability entity);

	public Ability read(String key);

	public void update(Ability entity, String key);

	public void delete(String key);

	public QueryManager<Ability> query(QueryManager<Ability> queryManager);
}
