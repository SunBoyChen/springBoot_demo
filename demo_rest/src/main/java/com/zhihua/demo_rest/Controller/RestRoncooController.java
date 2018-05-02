package com.zhihua.demo_rest.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class RestRoncooController {


    @RequestMapping(value = "/update")
    public String update(@RequestBody JsonNode jsonNode) {
        System.out.println("jsonNode=" + jsonNode);
        return "jsonNode：  " + jsonNode;
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update2(@PathVariable(value = "id") Integer id) {
        System.out.println(id);

        return id+"";
    }
}