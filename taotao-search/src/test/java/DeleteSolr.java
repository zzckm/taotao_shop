import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * 
 */

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月10日 上午9:20:16 
* 类说明 ：删除索引库数据
*/

public class DeleteSolr {
	 @Test
	    public void deleteIndexToSolr() throws IOException, SolrServerException {
	        //solrj的服务对象
	        SolrServer solrServer = new HttpSolrServer("http://192.168.200.129:8080/solr/collection1");
	        //执行删除操作
	        //根据id删除
	        solrServer.deleteByQuery("*:*");
	        //根据条件删除  条件基本格式:  字段的名称:字段的值
	        //提交
	        solrServer.commit();
	    }
	 
}

