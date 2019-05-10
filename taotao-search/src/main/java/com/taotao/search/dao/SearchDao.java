/**
 * 
 */

package com.taotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.taotao.common.pojo.SearchResult;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午2:37:43 
* 类说明 ：
*/

public interface SearchDao {
	public SearchResult search(SolrQuery query) throws Exception;
}
