package com.xusanjin.mytest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Person {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    //姓名
    private String name;
    //头像
    private String profileImg;
    //邮箱
    private String email;
    //性别
    private String gender;
    //状态
    private Integer enableStatus;
    //身份标识  1=顾客，2=店家，3=管理员
    private Integer userType;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    //修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastEditTime;


}
