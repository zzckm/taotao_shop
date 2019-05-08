/**
 * 
 */

package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictrueResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月6日 下午8:41:27 
* 类说明 ：
*/

/** 
* 
*/
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("pic/upload")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {		
		System.out.println(uploadFile);
		PictrueResult result = pictureService.uploadPic(uploadFile);
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}
