package com.yumfee.extremeworld.service;

import com.yumfee.extremeworld.modules.nosql.redis.JedisTemplate;
import com.yumfee.extremeworld.modules.nosql.redis.pool.JedisPool;
import com.yumfee.extremeworld.modules.nosql.redis.pool.JedisPoolBuilder;

public class RedisTestService 
{
	private JedisTemplate jedisTemplate;
	

	public RedisTestService()
	{
		JedisPool pool = new JedisPoolBuilder().setUrl("direct://localhost:6379?poolSize=" + 20 +"&poolName=abc").buildPool();
		
		jedisTemplate = new JedisTemplate(pool);
	}
	
	public String getValue(String key)
	{
		
		return jedisTemplate.get(key);
	}
}
