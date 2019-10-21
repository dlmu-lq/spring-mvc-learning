package top.itlq.spring.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.itlq.spring.mvc.model.User;

@RestController
@RequestMapping("user")
public class UserController {

    //    messageConverter
    @RequestMapping("add")
    public ResponseEntity addUser(@RequestBody User user){
        return ResponseEntity.ok(user.toString());
    }
}
