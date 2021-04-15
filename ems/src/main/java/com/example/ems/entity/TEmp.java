package com.example.ems.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther CodeGenerator
 * @create 2021-04-14 16:24:35
 * @describe 实体类
 */
@TableName("t_emp")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "TEmp对象", description = "")
public class TEmp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("photo")
    private String photo;

    @TableField("age")
    private Integer age;

    @TableField("salary")
    private Double salary;

    @TableField("description")
    private String description;

    public Integer getId() {
        return id;
    }

    public TEmp setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TEmp setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public TEmp setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public TEmp setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public TEmp setSalary(Double salary) {
        this.salary = salary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TEmp setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "TEmp{" + "id=" + id + ", name=" + name + ", photo=" + photo + ", age=" + age + ", salary=" + salary
                + ", description=" + description + "}";
    }

}