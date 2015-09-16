package org.bogbog.client.dao;

import org.bogbog.shared.QueryManager;
import org.bogbog.shared.Skill;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SkillServiceAsync {

	void create(Skill entity, AsyncCallback<Skill> callback);

	void delete(String key, AsyncCallback<Void> callback);

	void query(QueryManager<Skill> queryManager,
			AsyncCallback<QueryManager<Skill>> callback);

	void read(String key, AsyncCallback<Skill> callback);

	void update(Skill entity, String key, AsyncCallback<Void> callback);

}
