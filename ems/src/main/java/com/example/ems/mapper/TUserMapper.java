package com.example.ems.mapper;

import com.example.ems.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:13:57
 * @describe mapper类
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

    List<TUser> selectUserByUserName(String userName);

    List<TUser> selectUserByUserNameAndPassword(String userName, String password);
}
