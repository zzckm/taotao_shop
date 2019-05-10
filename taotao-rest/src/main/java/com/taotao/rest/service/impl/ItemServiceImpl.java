/**
 * 
 */

package com.taotao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.rest.component.JedisClient;
import com.taotao.rest.service.ItemService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午10:37:41 
* 类说明 ：商品管理
*/
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private JedisClient jedisClient;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${ITEM_BASE_INFO_KEY}")
	private String ITEM_BASE_INFO_KEY;
	@Value("${ITEM_EXPIRE_SECOND}")
	private Integer ITEM_EXPIRE_SECOND;
	@Value("${ITEM_DESC_KEY}")
	private String ITEM_DESC_KEY;
	@Value("${ITEM_PARAM_KEY}")
	private String ITEM_PARAM_KEY;
	
	@Override
	public TbItem getItemById(Long itemId) {
		//查询缓存，如果有缓存，直接返回  (加try catch 就可以就算出错了 也你不会影响程序正常运行，不会报错！)
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" +itemId + ":" + ITEM_BASE_INFO_KEY);
			//判断数据是否存在  isNotBlank
			if (StringUtils.isNotBlank(json)) {
				// 把json数据转换成java对象
				TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
				return item;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		//根据商品id查询商品基本信息------------------------------
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		//向redis中添加缓存。----------------------------------(要设置过期时间redis中只能在key上设置。因此 不能使用费hash添加)
		//添加缓存原则是不能影响正常的业务逻辑
		try {
			//向redis中添加缓存             （使用String数据类型，为了便于分组可以使用“:”分隔的命名方式。）
			//使用：分隔的话 在redis中会变成文件夹目录格式存在，便于使用软件查询
			jedisClient.set(REDIS_ITEM_KEY + ":" +itemId + ":" + ITEM_BASE_INFO_KEY
					, JsonUtils.objectToJson(item));
			//***设置key的过期时间***  ITEM_EXPIRE_SECOND=过期时间
			jedisClient.expire(REDIS_ITEM_KEY + ":" +itemId + ":" + ITEM_BASE_INFO_KEY, ITEM_EXPIRE_SECOND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	//商品详情查询
	@Override
	public TbItemDesc getItemDescById(Long itemId) {
		//查询缓存
		//查询缓存，如果有缓存，直接返回
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY);
			//判断数据是否存在
			if (StringUtils.isNotBlank(json)) {
				// 把json数据转换成java对象
				TbItemDesc itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
				return itemDesc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//根据商品id查询商品详情
		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
		//添加缓存
		try {
			//向redis中添加缓存
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY
					, JsonUtils.objectToJson(itemDesc));
			//设置key的过期时间
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_DESC_KEY, ITEM_EXPIRE_SECOND);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemDesc;
	}
	
	//查询商品规格参数
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper; 
	@Override
	public TbItemParamItem getItemParamById(Long itemId) {
		//添加缓存逻辑
		//查询缓存
		//查询缓存，如果有缓存，直接返回
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY);
			//判断数据是否存在
			if (StringUtils.isNotBlank(json)) {
				// 把json数据转换成java对象
				TbItemParamItem itemParamitem = JsonUtils.jsonToPojo(json, TbItemParamItem.class);
				return itemParamitem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 根据商品id查询规格参数
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		//取规格参数
		if (list != null && list.size() > 0) {
			TbItemParamItem itemParamItem = list.get(0);
			//添加缓存
			try {
				//向redis中添加缓存
				jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY
						, JsonUtils.objectToJson(itemParamItem));
				//设置key的过期时间
				jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":" + ITEM_PARAM_KEY, ITEM_EXPIRE_SECOND);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return itemParamItem;
		}
		return null;
	}
}
