package top.itlq.spring.mvc.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class TestController {

    public TestController(){
        System.out.println("test controller inited.");
    }

    @RequestMapping("index")
    public void test(){
        System.out.println("testController");
    }
}
