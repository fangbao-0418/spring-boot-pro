package com.example.demo.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
// import lombok.Data;
 
// @Data
@ApiModel("创建Swagger响应结果")
public class CreateUserVO {
 
    @ApiModelProperty("id")
    private Integer id;
 
    @ApiModelProperty("姓名")
    public String name;
 
    @ApiModelProperty("性别")
    public Integer gender;
 
    @ApiModelProperty("啥啥")
    public String what;
}