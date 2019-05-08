/**
 * 
 */

package com.taotao.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月7日 上午9:15:01 
* 类说明 ：
*/

/** 
* 
*/
@Service
public class ItemParamServiceImpl implements ItemParamService {
	/**
	 * 查询规格参数列表
	 */
	@Autowired
	private TbItemParamMapper itemParamMapper;
	@Override
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		//查询商品列表
		TbItemParamExample example = new TbItemParamExample();
		//分页处理				  
		PageHelper.startPage(page, rows);
													//查询有字段为空的话 查看使用的查询方法是否正确，BLOBs 有它则用他
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);		
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);			
		//取记录总条数
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());			
		
		return result;
	}	
	//根据添加的分类id来判断需要添加的分类是否存在
	@Override
	public TaotaoResult getItemParamByCid(Long cid) {
		//根据cid查询规格参数模板
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		//执行查询
		List<TbItemParam>list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null&&list.size() > 0) {
			TbItemParam itemParam = list.get(0);
			return TaotaoResult.ok(itemParam);
		}
		return TaotaoResult.ok();
	}

	/**
	 * 保存规格参数模版
	 */
	@Override
	public TaotaoResult insertItemParam(Long cid, String paramData) {
		//创建一个pojo
				TbItemParam itemParam = new TbItemParam();
				itemParam.setItemCatId(cid);
				itemParam.setParamData(paramData);
				itemParam.setCreated(new Date());
				itemParam.setUpdated(new Date()); 
				//插入记录
				itemParamMapper.insert(itemParam);
				return TaotaoResult.ok();
	}

}
