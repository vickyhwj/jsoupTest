package cache;

import java.util.concurrent.ConcurrentHashMap;

public class QueryCahce {
	public static ConcurrentHashMap<String, Object> season_teamMap=new ConcurrentHashMap<>();

	public static ConcurrentHashMap<String, Object> getSeason_teamMap() {
		return season_teamMap;
	}

	public static void setSeason_teamMap(
			ConcurrentHashMap<String, Object> season_teamMap) {
		QueryCahce.season_teamMap = season_teamMap;
	}
	

}
