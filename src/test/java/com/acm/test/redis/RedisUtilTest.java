package com.acm.test.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acm.util.RedisUtil;
import com.acm.wei.entitys.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-redis.xml")
public class RedisUtilTest {
	@Test
	public void test() {
		//User user = new User();
		RedisUtil.set("name","panlei", 100l, TimeUnit.MILLISECONDS);
	}
}
