/**
 * 
 */

package com.taotao.portal.service;

import com.taotao.common.pojo.SearchResult;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午3:47:50 
* 类说明 ：
*/

public interface SearchService {
	public SearchResult search(String keyword, int page, int rows);
	public SearchResult clickItem(String keyword, int page, int rows);
}
