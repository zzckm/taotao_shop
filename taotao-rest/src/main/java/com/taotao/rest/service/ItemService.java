/**
 * 
 */

package com.taotao.rest.service;

import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午10:36:24 
* 类说明 ：商品信息
*/


public interface ItemService {
	//商品基本信息
	public TbItem getItemById(Long itemId);
	//上商品详细信息
	public TbItemDesc getItemDescById(Long itemId);
	//商品规格参数
	public TbItemParamItem getItemParamById(Long itemId);
}
