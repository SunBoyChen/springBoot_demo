package com.zhihua.demo_https.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/home")
public class HomeController {


    @RequestMapping(value = "/get")
    public HashMap<String, Object> get() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", "123");
        return map;
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }
}
