package com.acm.test.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class RedisTest {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// @Autowired
	// private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() {
		String key = "spring";
		ListOperations<String, String> lop = redisTemplate.opsForList();
		RedisSerializer<String> serializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(serializer);
		redisTemplate.setValueSerializer(serializer);
		lop.leftPush(key, "aaa");
		lop.leftPush(key, "bbb");
		long size = lop.size(key);
		// rt.boundListOps(key).size();
		// Assert.assertEquals(2, size);
	}

	@Test
	public void tran() {
		// execute a transaction
		List<Object> txResults = (List<Object>) redisTemplate.execute(new SessionCallback<List<Object>>() {
			public List<Object> execute(RedisOperations operations) throws DataAccessException {
				operations.multi();
				operations.opsForSet().add("key", "value1");
				// This will contain the results of all ops in the transaction
				return operations.exec();
			}
		});
		System.out.println("Number of items added to set: " + txResults.get(0));
	}

	@Test
	public void tranTest() throws InterruptedException, ExecutionException {
		final String key = "keySet";
		ValueOperations<String, String> strOps = redisTemplate.opsForValue();
		strOps.set(key, "keyValue");
		ExecutorService pool = Executors.newCachedThreadPool();
		List<Callable<Object>> tasks = new ArrayList<Callable<Object>>();
		for (int i = 0; i < 5; i++) {
			final int idx = i;
			tasks.add(new Callable<Object>() {
				public Object call() throws Exception {
					return redisTemplate.execute(new SessionCallback<Object>() {
						public Object execute(RedisOperations operations) throws DataAccessException {
							operations.watch(key);
							String origin = (String) operations.opsForValue().get(key);
							operations.multi();
							operations.opsForValue().set(key, origin + idx);
							Object rs = operations.exec();
							System.out.println("set:" + origin + idx + " rs:" + rs);
							return rs;
						}
					});
				}
			});
		}
	}

}
