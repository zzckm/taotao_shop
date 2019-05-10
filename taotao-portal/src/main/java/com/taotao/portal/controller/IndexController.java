 /**
 * 
 */

package com.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.portal.service.ContentService;

/**
 * @author 作者 : 千客z
 * @version 创建时间：2019年5月7日 下午3:35:46 类说明 :首页管理
 */
@Controller
public class IndexController {
	@Autowired
	private ContentService contentService;

	@RequestMapping("/index")
	public String showIndex(Model model) {
		// 获取大广告位的内容
		String json = contentService.getAd1List();
		// 传递给页面
		model.addAttribute("ad1", json);
		return "index";
	}

}
