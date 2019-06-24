package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ItemParamServiceImpl
 *  规格参数模板
 * @author dz
 * @date 2019/6/20
 **/
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper tbItemParamMapper;
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    @Override
    public TaotaoResult getItemParamByCid(long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = tbItemParamMapper.selectByExampleWithBLOBs(example);
        //判断是否查询到结果
        if(list != null && list.size() > 0){
            return TaotaoResult.ok(list.get(0));
        }
        return TaotaoResult.ok();
    }
    @Override
    public TaotaoResult insertItemParam(TbItemParam itemParam) {
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        tbItemParamMapper.insert(itemParam);
        return TaotaoResult.ok();
    }
//    @Override
//    public TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
//        TbItemParamItem itemParamItem = new TbItemParamItem();
//        itemParamItem.setItemId(itemId);
//        itemParamItem.setParamData(itemParam);
//        itemParamItem.setCreated(new Date());
//        itemParamItem.setUpdated(new Date());
//        tbItemParamItemMapper.insert(itemParamItem);
//        return TaotaoResult.ok();
//    }
}
