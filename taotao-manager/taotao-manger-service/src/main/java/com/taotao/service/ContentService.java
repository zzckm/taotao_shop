/**
 * 
 */

package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 下午3:00:44 
* 类说明 ：
*/

/** 
* 
*/

public interface ContentService {
	public TaotaoResult insertContent(TbContent content);
	
	//根据分类id分页查询内容
		public EUDataGridResult getByIdItemList(Integer page,Integer rows,long categoryId);
}
