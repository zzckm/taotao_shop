/**
 * 
 */

package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.pojo.PictrueResult;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月6日 下午8:21:58 
* 类说明 ：
*/

/** 
* 
*/

public interface PictureService {
	public PictrueResult uploadPic(MultipartFile picFile);
}
