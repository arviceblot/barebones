package org.bogbog.shared;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class QueryManager<T> implements Serializable {
	private String query;
	private String cursor;
	private List<T> results;
	private int range;

	public QueryManager() {
		query = "";
		cursor = "";
		range = 25;
	}
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public boolean hasCursor() {
		return !cursor.equals("");
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

}
