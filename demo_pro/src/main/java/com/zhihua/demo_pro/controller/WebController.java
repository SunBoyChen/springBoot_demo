package com.zhihua.demo_pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/web")
public class WebController {
    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("title","标题");
        return "index"; // 开头不要加上/，linux下面会出错
    }
}
