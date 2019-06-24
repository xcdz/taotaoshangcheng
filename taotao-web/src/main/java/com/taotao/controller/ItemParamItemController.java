package com.taotao.controller;

import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ItemParamItemController
 *
 * @author dz
 * @date 2019/6/20
 **/
@Controller
public class ItemParamItemController {
    @Autowired
    private ItemParamItemService itemParamItemService;
    @RequestMapping("/showitem/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model){
        String string = itemParamItemService.getItemParamByItemId(itemId);
        model.addAttribute("itemParam",string);
        return "item";
    }

}
