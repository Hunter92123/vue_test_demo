package com.example.ems.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther CodeGenerator
 * @create 2021-04-15 11:03:30
 * @describe 实体类
 */
@TableName("t_user")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value="TUser对象", description="")
public class TUser implements Serializable {

private static final long serialVersionUID = 1L;

                        @TableId(value = "id", type = IdType.AUTO)
                            private Integer id;

    @TableField("user_name")
                private String userName;

    @TableField("real_name")
                private String realName;

    @TableField("sex")
                private String sex;

    @TableField("status")
                private String status;

    @TableField("register_datetime")
                private Date registerDatetime;


    public Integer getId() {
            return id;
            }

        public TUser setId(Integer id) {
            this.id = id;
                return this;
            }

    public String getUserName() {
            return userName;
            }

        public TUser setUserName(String userName) {
            this.userName = userName;
                return this;
            }

    public String getRealName() {
            return realName;
            }

        public TUser setRealName(String realName) {
            this.realName = realName;
                return this;
            }

    public String getSex() {
            return sex;
            }

        public TUser setSex(String sex) {
            this.sex = sex;
                return this;
            }

    public String getStatus() {
            return status;
            }

        public TUser setStatus(String status) {
            this.status = status;
                return this;
            }

    public Date getRegisterDatetime() {
            return registerDatetime;
            }

        public TUser setRegisterDatetime(Date registerDatetime) {
            this.registerDatetime = registerDatetime;
                return this;
            }

@Override
public String toString() {
        return "TUser{" +
                "id=" + id +
                ", userName=" + userName +
                ", realName=" + realName +
                ", sex=" + sex +
                ", status=" + status +
                ", registerDatetime=" + registerDatetime +
        "}";
        }
        }