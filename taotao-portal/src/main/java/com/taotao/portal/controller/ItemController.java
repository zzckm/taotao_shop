/**
 * 
 */

package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.portal.service.ItemService;

/**
 * @author 作者 : 千客z
 * @version 创建时间：2019年5月9日 下午11:37:02 类说明 ：展示商品详情页面
 */

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("/item/{itemId}")
	public String showItemInfo(@PathVariable Long itemId, Model model) {
		TbItem item = itemService.getItemById(itemId);
		model.addAttribute("item", item);
		// 返回逻辑视图
		return "item";
	}

	// 展示商品描述信息 返回一个json数据
	@RequestMapping(value = "/item/desc/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemDesc(@PathVariable Long itemId) {
		String desc = itemService.getItemDescById(itemId);
		return desc;
	}
	// 展示商品规格参数 返回一个json数据                             produces 将获取来的json数据转换成utf-8格式
	@RequestMapping(value = "/item/param/{itemId}", produces = MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemParam(@PathVariable Long itemId) {
		String paramHtml = itemService.getItemParamById(itemId);
		return paramHtml;
	}

}
