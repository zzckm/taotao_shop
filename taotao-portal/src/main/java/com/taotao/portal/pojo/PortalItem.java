/**
 * 
 */

package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午11:42:27 
* 类说明 ：
*/
/**
 * 由于前端页面需要遍历图片展示，但image是一个多图片路径在一个字符串里的，
 * 因此我们需要继承TbItem 将image从String 以,分割转换成一个数组，方便前端jsp遍历
 */

public class PortalItem extends TbItem {
	public String[] getImages() {
		String images=this.getImage();
		if(images!=null&&!images.equals("")) {
			String[] imgs=images.split(",");
			return imgs;
		}
		return null;
	}
}
