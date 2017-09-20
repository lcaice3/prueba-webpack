package co.com.bancodebogota.utils;

public interface RedisRepository {

	void addCache(String key1, String key2, String prefix, Object objectDto);

	void addCacheTime(String key1, String key2, String prefix, Object objectDto, int timeXMinutes);

	String getCache(String key1, String key2, String prefix);

	void deleteKeyRedis(String key1, String key2, String prefix);

}
