package com.fjrxny.ems.pojo;

import lombok.Data;
import sun.security.util.Password;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tUser")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    @Column(name = "userid")
    private String userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
}
