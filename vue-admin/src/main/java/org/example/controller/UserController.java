package org.example.controller;


import org.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin // 解决跨域请求问题
public class UserController {

    @GetMapping("/demo")
    public String demo() {
        return "hello axios";
    }

    @GetMapping("/demo1")
    public String demo1(@RequestParam Integer id) {
        return "hello axios";
    }

    @GetMapping("/findUserById")
    public User findUserById(@RequestParam Integer id) {
        return new User(id, "小李", 23, new Date());
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById1(@PathVariable("id") Integer id) {
        return new User(id, "小李", 23, new Date());
    }

    @PostMapping("/save")
    public String save(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }
}
