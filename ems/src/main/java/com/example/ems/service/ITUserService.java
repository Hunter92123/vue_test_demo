package com.example.ems.service;

import com.example.ems.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:13:57
 * @describe 服务类
 */
public interface ITUserService extends IService<TUser> {

    /**
     * 检查用户名是否存在
     *
     * @param userName
     * @return
     */
    boolean checkUserNameHasExsited(String userName);

    /**
     * 用户登录方法
     *
     * @param user
     * @return
     */
    boolean login(TUser user);
}
