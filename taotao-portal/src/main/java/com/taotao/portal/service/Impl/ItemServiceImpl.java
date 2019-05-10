/**
 * 
 */

package com.taotao.portal.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.portal.pojo.PortalItem;
import com.taotao.portal.service.ItemService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月9日 下午11:29:11 
* 类说明 ：展示商品信息
*/
@Service
public class ItemServiceImpl implements ItemService {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_ITEM_BASE_URL}")
	private String REST_ITEM_BASE_URL;
	@Value("${REST_ITEM_DESC_URL}")
	private String REST_ITEM_DESC_URL;
	@Value("${REST_ITEM_PARAM_URL}")
	private String REST_ITEM_PARAM_URL;

	//展示商品基本信息
	@Override
	public TbItem getItemById(Long itemId) {
		// 根据商品id查询商品基本信息
		String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_BASE_URL + itemId);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, PortalItem.class);
		//取商品对象
		TbItem item = (TbItem) taotaoResult.getData();
		return item;
	}
	//展示商品描述介绍信息
	@Override
	public String getItemDescById(Long itemId) {
		//根据商品id调用taotao-rest的服务获得数据
		//http://localhost:8081/rest/item/desc/144766336139977
		String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_DESC_URL + itemId);
		//转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemDesc.class);
		//取商品描述
		TbItemDesc itemDesc = (TbItemDesc) taotaoResult.getData();
		String desc = itemDesc.getItemDesc();
		return desc;
	}
	
	//展出商品规格参数
	@Override
	public String getItemParamById(Long itemId) {
		
		// 根据商品id获得对应的规格参数
		String json = HttpClientUtil.doGet(REST_BASE_URL + REST_ITEM_PARAM_URL + itemId);
		System.out.println(REST_BASE_URL + REST_ITEM_PARAM_URL + itemId+" --------------------------------------------------------");
		// 转换成java对象
		TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, TbItemParamItem.class);
		// 取规格参数
		TbItemParamItem itemParamItem = (TbItemParamItem) taotaoResult.getData();
		String paramJson = itemParamItem.getParamData();
		// 把规格参数的json数据转换成java对象
		// 转换成java对象
		List<Map> mapList = JsonUtils.jsonToList(paramJson, Map.class);
		// 遍历list生成html
		StringBuffer sb = new StringBuffer();

		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
		sb.append("	<tbody>\n");
		for (Map map : mapList) {
			sb.append("		<tr>\n");
			sb.append("			<th class=\"tdTitle\" colspan=\"2\">" + map.get("group") + "</th>\n");
			sb.append("		</tr>\n");
			// 取规格项
			List<Map> mapList2 = (List<Map>) map.get("params");
			for (Map map2 : mapList2) {
				sb.append("		<tr>\n");
				sb.append("			<td class=\"tdTitle\">" + map2.get("k") + "</td>\n");
				sb.append("			<td>" + map2.get("v") + "</td>\n");
				sb.append("		</tr>\n");
			}
		}
		sb.append("	</tbody>\n");
		sb.append("</table>");

		return sb.toString();

	}
}
