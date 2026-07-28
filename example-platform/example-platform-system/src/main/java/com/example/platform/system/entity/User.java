package com.example.platform.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shared.mybatisplus.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@TableName("sys_user")
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends SuperEntity {
    private String username;

    private String password;
}
