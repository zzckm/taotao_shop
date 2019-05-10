/**
 * 
 */

package com.taotao.rest.component;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 下午9:27:56 
* 类说明 ：
*/

public interface JedisClient {
	public String set(String key, String value);
	public String get(String key);
	//hash 新建
	public Long hset(String key, String item, String value);
										//item 项
	public String hget(String key, String item);
	// 加+1
	public Long incr(String key);
	//减-1
	public Long decr(String key);
	//设置过期时间  -2 已经没有了  -1永久保存 
	public Long expire(String key, int second);
	//查看该数据状态
	public Long ttl(String key);
	//删除哈希数据
	public Long hdel(String key,String item);
}
