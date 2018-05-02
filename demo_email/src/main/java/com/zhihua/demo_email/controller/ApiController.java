package com.zhihua.demo_email.controller;

import com.zhihua.demo_email.Component.TestJavaMailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private TestJavaMailComponent component;

    @RequestMapping(value = "mail")
    @ResponseBody
    public String mail(String email) {
        component.sendMail(email);
        return "success";
    }

    @RequestMapping("index")
    public String index(ModelMap map){
        map.put("title", "hello world");
        return "index"; // 注意，不要在最前面加上/，linux下面会出错
    }
}
