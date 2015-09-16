package org.bogbog.client.dao;

import org.bogbog.shared.Character;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CharacterServiceAsync {

	public void create(Character entity, AsyncCallback<Character> callback);

	public void delete(String key, AsyncCallback<Void> callback);

	public void query(QueryManager<Character> queryManager,
			AsyncCallback<QueryManager<Character>> callback);

	public void read(String key, AsyncCallback<Character> callback);

	public void update(Character entity, String key,
			AsyncCallback<Void> callback);

}
