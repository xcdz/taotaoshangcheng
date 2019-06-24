package com.taotao.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 东珠
 * @Package: com.taotao.portal.controller
 * @ClassName: IndexController
 * @Description: java类作用描述
 * @CreateDate 2019/6/21 15:09
 **/
@Controller
public class IndexController {
    @RequestMapping("/index")
    private String showIndex(){
        return "index";
    }

}
