package top.itlq.spring.mvc.learning.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    public TestController(){
        System.out.println("test controller inited.");
    }

    @RequestMapping(value = "")
    public String test0(){
        return "testController index0";
    }

    @RequestMapping(value = "index",produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        return "testController index";
    }

    @RequestMapping(value = "index2")
    public String test2(){
        return "testController index2";
    }
}
