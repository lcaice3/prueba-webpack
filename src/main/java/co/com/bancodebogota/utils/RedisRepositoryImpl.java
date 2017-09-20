package co.com.bancodebogota.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;

@Service
public class RedisRepositoryImpl implements RedisRepository {

	@Value("${REDISSERVER}")
	private String redisEndpoint;

	private static final int EXPIRE_TOKEN = 15;

	private Jedis jedis;

	private Jedis getRedisInstance() {
		if (jedis == null)
			jedis = new Jedis(redisEndpoint);
		return jedis;
	}

	private String createRedisKey(String key1, String key2, String prefix) {
		return String.format("%s:%s:%s", key1, key2, prefix);
	}

	@Override
	public void addCache(String key1, String key2, String prefix, Object objectDto) {
		ObjectMapper mapper = new ObjectMapper();
		String keyReddis = createRedisKey(key1, key2, prefix);
		try {
			saveRedis(keyReddis, mapper.writeValueAsString(objectDto));
		} catch (JsonProcessingException e) {
			LoggerUtils.error("StorageTempUtilitiesImpl.addCache: " + e.getMessage());
		}

	}

	@Override
	public String getCache(String key1, String key2, String prefix) {
		String keyReddis = createRedisKey(key1, key2, prefix);
		return getRedisInstance().get(keyReddis);
	}

	@Override
	public void deleteKeyRedis(String key1, String key2, String prefix) {
		String keyReddis = createRedisKey(key1, key2, prefix);
		getRedisInstance().del(keyReddis);
	}

	public void saveRedis(String key, String value) {
		getRedisInstance().set(key, value);
		getRedisInstance().expire(key, EXPIRE_TOKEN * 60);

	}

	@Override
	public void addCacheTime(String key1, String key2, String prefix, Object objectDto, int timeXMinutes) {
		ObjectMapper mapper = new ObjectMapper();
		String keyReddis = createRedisKey(key1, key2, prefix);
		try {
			saveRedisXMinutes(keyReddis, mapper.writeValueAsString(objectDto), timeXMinutes);
		} catch (JsonProcessingException e) {
			LoggerUtils.error("StorageTempUtilitiesImpl.addCache: " + e.getMessage());
		}
	}

	public void saveRedisXMinutes(String key, String value, int timeXMinutes) {
		getRedisInstance().set(key, value);
		getRedisInstance().expire(key, EXPIRE_TOKEN * timeXMinutes);

	}

}
