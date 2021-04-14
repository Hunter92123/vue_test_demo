package com.example.ems.controller;


import com.example.ems.entity.TUser;
import com.example.ems.service.ITUserService;
import com.example.ems.util.ValidateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:13:57
 * @describe 前端控制器
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/user/t-user" )
public class TUserController {

    @Autowired
    ITUserService userService;

    @PostMapping(value = "register" )
    public Map<String, Object> register(HttpServletRequest request, @RequestBody TUser user, String code) {
        log.info("User: [{}]", user.toString());
        log.info("code: [{}]", code);
        Map<String, Object> map = new HashMap<>();

        String key = (String) request.getServletContext().getAttribute("code" );
        try {
            if (key.equalsIgnoreCase(code)) {
                user.setStatus("1");
                user.setRegisterDatetime(Calendar.getInstance().getTime());
                userService.save(user);
            } else {
                throw new Exception("验证码错误" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


    /**
     * 获取图片验证码
     *
     * @return
     */
    @GetMapping(value = "getImageCode" )
    public String getImageCode(HttpServletRequest request) {
        ValidateCodeUtil.Validate validate = ValidateCodeUtil.getRandomCode();
        request.getServletContext().setAttribute("code" , validate.getValue());
        return "data:image/png;base64," + validate.getBase64Str();
    }
}