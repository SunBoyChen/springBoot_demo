package com.zhihua.demo_https.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author wujing
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/get")
    @ResponseBody
    public HashMap<String, Object> get() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello world");
        map.put("name", "123");
        return map;
    }

   // @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/test")
    public String test() {
        return "test";
    }

    @PreAuthorize("hasAuthority('SUPERUSER')")
    @RequestMapping(value = "/test1")
    public String test1() {
        return "test1";
    }

}