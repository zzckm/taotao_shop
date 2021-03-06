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
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentService;

/** 
* @author 作者 : 千客z
* @version 创建时间：2019年5月8日 下午3:00:50 
* 类说明 ：内容管理
*/

@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	private TbContentMapper contentMapper;	
	@Override
	public TaotaoResult insertContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入数据
		contentMapper.insert(content);		
		return TaotaoResult.ok();
	}
	
	//分页查询广告内容
	@Autowired
	private TbContentMapper tbContentMapper;
	@Override
	public EUDataGridResult getByIdItemList(Integer page,Integer rows,long categoryId){
		//查询商品列表
		TbContentExample example = new TbContentExample();
		//创建条件对象
		com.taotao.pojo.TbContentExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCategoryIdEqualTo(categoryId);
		//分页处理				  
		PageHelper.startPage(page, rows);
		List<TbContent> list = tbContentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());		
		System.out.println("该id的相关内容列表"+list.toString());
		return result;
	}
}
