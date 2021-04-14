package org.example.controller;


import org.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/users")
    public List<User> users(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(23+i);
            user.setBir(new Date());
            user.setName("User_"+i);
            user.setDesc("描述描述描述");
            list.add(user);
        }
        return list;
    }

    @GetMapping("/students")
    public List<User> students(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(23+i);
            user.setBir(new Date());
            user.setName("User_"+i);
            user.setDesc("描述描述描述");
            list.add(user);
        }
        System.out.println("ok ----");
        System.out.println("ok ----");
        System.out.println("ok ----");
        System.out.println("ok ----");
        System.out.println("ok ----");
        return list;
    }
}
