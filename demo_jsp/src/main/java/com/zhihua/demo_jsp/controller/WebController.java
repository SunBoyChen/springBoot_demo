package com.zhihua.demo_jsp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

   @RequestMapping("index")
    public String index(Model model){
        logger.info("进入方法");
        model.addAttribute("title","123");
        return "index";
    }
}
