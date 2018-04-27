package com.zhihua.demo_error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("index")
    public String index(Model model){
        logger.info("进入方法");
        //modelAndView.getModelMap().put("title","标题");
        model.addAttribute("title","标题");
        return "index";
    }


    @RequestMapping(value = "error")
    public String error(ModelMap map) throws Exception {
        System.out.println("测试异常");
        //throw new RuntimeException("测试异常");
        throw new Exception("测试异常");
    }
}
