package com.example.ems.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.ems.entity.TUser;
import com.example.ems.service.ITUserService;
import com.example.ems.util.ValidateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:13:57
 * @describe 前端控制器
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/user")
public class TUserController {

	@Autowired
	ITUserService userService;

	@PostMapping(value = "login")
	public Map<String, Object> login(HttpServletRequest request, @RequestParam String code,
									 @RequestBody TUser tUser) {
		log.info("User: [{}]", tUser.toString());
		log.info("code: [{}]", code);
		Map<String, Object> map = new HashMap<>();

		String key = (String) request.getServletContext().getAttribute("code");
		log.info("key: [{}]", key);
		if (key.equalsIgnoreCase(code)) {
			boolean b = userService.login(tUser);
			if (b) {
				map.put("flag", 0);
				map.put("msg", "登录成功");
			} else {
				map.put("flag", -1);
				map.put("msg", "登录失败");
			}
		}
		return map;
	}


	@PostMapping(value = "register")
	public Map<String, Object> register(HttpServletRequest request, @RequestParam String code,
										@RequestBody TUser tUser) {
		log.info("User: [{}]", tUser.toString());
		log.info("code: [{}]", code);
		Map<String, Object> map = new HashMap<>();

		String key = (String) request.getServletContext().getAttribute("code");
		log.info("key: [{}]", key);
		try {
			if (key.equalsIgnoreCase(code)) {
				tUser.setStatus("1");
				tUser.setRegisterDatetime(Calendar.getInstance().getTime());
				log.info("user: [{}]", tUser.toString());
				// 根据用户名检查是否存在相同用户名
				boolean hasExsited = userService.checkUserNameHasExsited(tUser.getUserName());
				if (!hasExsited) {
					userService.save(tUser);
					map.put("flag", 0);
					map.put("msg", "注册成功");
				} else {
					map.put("flag", -2);
					map.put("msg", "注册失败，用户名已存在");
				}
			} else {
				// throw new Exception("验证码错误" );
				map.put("flag", -1);
				map.put("msg", "验证码错误，注册失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", -1);
			map.put("msg", "注册失败");
		}

		return map;
	}

	/**
	 * 获取图片验证码
	 *
	 * @return
	 */
	@GetMapping(value = "getImageCode")
	public String getImageCode(HttpServletRequest request) {
		ValidateCodeUtil.Validate validate = ValidateCodeUtil.getRandomCode();
		request.getServletContext().setAttribute("code", validate.getValue());
		return "data:image/png;base64," + validate.getBase64Str();
	}

}