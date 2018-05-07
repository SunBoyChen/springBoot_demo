package com.zhihua.demo_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/web")
public class WebController {

    @RequestMapping(value = "/index")
    public String index(ModelMap map, HttpSession httpSession) {
        map.put("title", "第一个应用：sessionID=" + httpSession.getId());
        System.out.println("sessionID=" + httpSession.getId());
        return "index";
    }
}
