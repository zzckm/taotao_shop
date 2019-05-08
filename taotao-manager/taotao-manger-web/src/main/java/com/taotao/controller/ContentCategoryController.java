/**
 * 
 */

package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ContentCategoryService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 上午9:22:31 
* 类说明 ： 广告内容管理 
*/
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
     @ResponseBody							//初始值 当第一次打开没有点击，因此给一个id的初始值0
	public List<TreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<TreeNode> list = contentCategoryService.getContentCatList(parentId);
		return list;
	}
	
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createNode(Long parentId, String name) {
		TaotaoResult result = contentCategoryService.insertCatgory(parentId, name);
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateNode(Long id, String name) {
		TaotaoResult result = contentCategoryService.updateCatgory(id, name);
		return result;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteNode(Long parentId,Long id) {
		TaotaoResult result = contentCategoryService.deleteCatgory(parentId,id);
		return result;
	}
	
}
