/**
 * 
 */

package com.taotao.search.service;

import com.taotao.common.pojo.SearchResult;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午3:09:14 
* 类说明 ：
*/

public interface SearchService {
	//搜索框
	public SearchResult search(String queryString, int page, int rows) throws Exception;
	//点击商品类目
	public SearchResult clickItem(String queryString, int page, int rows) throws Exception;
}
