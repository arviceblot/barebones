package org.bogbog.client.dao;

import org.bogbog.shared.Character;
import org.bogbog.shared.QueryManager;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("character")
public interface CharacterService extends Dao<Character> {

	public Character create(Character character);

	public Character read(String key);

	public void update(Character character, String key);

	public void delete(String key);

	public QueryManager<Character> query(QueryManager<Character> queryManager);
}
