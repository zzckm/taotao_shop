/**
 * 
 */

package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 上午9:17:43 
* 类说明 ：
*/

public interface ContentCategoryService {
	public List<TreeNode> getContentCatList(Long parentId);
	public TaotaoResult insertCatgory(Long parentId, String name);
	public TaotaoResult updateCatgory(Long id, String name);
	public TaotaoResult deleteCatgory(Long parentId,Long id);
}

