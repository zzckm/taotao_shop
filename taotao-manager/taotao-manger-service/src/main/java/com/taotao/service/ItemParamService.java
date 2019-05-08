/**
 * 
 */

package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月7日 上午9:13:41 
* 类说明 ：
*/

/** 
* 
*/

public interface ItemParamService {
	//TbItem getItemById(long itemId);
	 EUDataGridResult getItemList(Integer page,Integer rows);
	 public TaotaoResult getItemParamByCid(Long cid);
	// TaotaoResult createItem(TbItemParam item);
	 public TaotaoResult insertItemParam(Long cid, String paramData);
}
