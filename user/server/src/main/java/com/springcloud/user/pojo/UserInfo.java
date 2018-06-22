package com.springcloud.user.pojo;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Author: wangcheng
 * @Date: Created in 12:45 2018/6/22
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;
}
