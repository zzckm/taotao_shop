package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
 TbItem getItemById(long itemId);
 EUDataGridResult getItemList(Integer page,Integer rows);
 TaotaoResult createItem(TbItem item,String desc,String itemParam);
 public String getItemParamHtml(Long itemId);
}
