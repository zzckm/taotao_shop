/**
 * 
 */

package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;

/** 
 * 内容管理
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 下午3:03:11 
* 类说明 ：内容管理
*/

/** 
* 
*/
@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody					//接受表单的内容， 使用TbContent接收
	public TaotaoResult insertContent(TbContent content) {
		
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}
	

}