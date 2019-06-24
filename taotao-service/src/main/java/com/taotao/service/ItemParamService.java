package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * ItemParamService
 *
 * @author dz
 * @date 2019/6/20
 **/
public interface ItemParamService {
    TaotaoResult getItemParamByCid(long cid);
    TaotaoResult insertItemParam(TbItemParam itemParam);
   // TaotaoResult insertItemParamItem(Long itemId,String itemParam);
}
