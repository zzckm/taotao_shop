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

import com.taotao.common.pojo.TreeNode;
import com.taotao.service.ItemCatService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月6日 下午2:57:04 
* 类说明 ：
*/

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired(required=true)
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody						//初始值 当第一次打开没有点击，因此给一个id的初始值0
	public List<TreeNode> getItemCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<TreeNode> list = itemCatService.getItemCatList(parentId);
		return list;
	}
}
