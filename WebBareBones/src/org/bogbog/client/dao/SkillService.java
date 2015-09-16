package org.bogbog.client.dao;

import org.bogbog.shared.QueryManager;
import org.bogbog.shared.Skill;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("skill")
public interface SkillService extends Dao<Skill> {

	public Skill create(Skill entity);

	public Skill read(String key);

	public void update(Skill entity, String key);

	public void delete(String key);

	public QueryManager<Skill> query(QueryManager<Skill> queryManager);
}
