package com.example.ems.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:13:57
 * @describe 实体类
 */
@TableName("t_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ApiModel(value = "TUser对象", description = "")
public class TUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("user_name")
	private String userName;

	@TableField("real_name")
	private String realName;

	@TableField("password")
	private String password;

	@TableField("sex")
	private String sex;

	@TableField("status")
	private String status;

	@TableField("register_datetime")
	private Date registerDatetime;

}