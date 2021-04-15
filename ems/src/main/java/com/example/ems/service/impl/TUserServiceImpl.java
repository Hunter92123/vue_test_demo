package com.example.ems.service.impl;

import com.example.ems.entity.TUser;
import com.example.ems.mapper.TUserMapper;
import com.example.ems.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:13:57
 * @describe 服务实现类
 */
@Service
@Slf4j
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {


    @Override
    public boolean checkUserNameHasExsited(String userName) {
        List<TUser> tUsers = baseMapper.selectUserByUserName(userName);
        if (tUsers.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean login(TUser user) {
        List<TUser> tUsers = baseMapper.selectUserByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (tUsers.size() == 1) {
            return true;
        }
        log.info("登录失败, 账户不存在，或者size = {}", tUsers.size());
        return false;
    }

}
