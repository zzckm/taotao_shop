/**
 * 
 */

package com.taotao.rest.component.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.taotao.rest.component.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 下午9:35:30 
* 类说明 ：redis 单机版 客户端  实现类
*/

public class JedisClientSingle implements JedisClient {
	@Autowired
	private JedisPool jedisPool;

	@Override // set 返回long  get 返回string
	public String set(String key, String value) {
		// jedis 通过redis连接池获取redis对象
		Jedis jedis = jedisPool.getResource();
		//针对数据进行一系列操作
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(key);
		jedis.close();
		return result;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(key, item, value);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(key, item);
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.decr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, second);
		jedis.close();
		return result;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.ttl(key);
		jedis.close();
		return result;
	}
	@Override
	public Long hdel(String key,String item) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key,item);
		jedis.close();
		return result;
	}
}
