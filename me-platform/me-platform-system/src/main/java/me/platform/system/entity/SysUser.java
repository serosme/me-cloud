package me.platform.system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 系统用户
 */
@Data
@TableName("sys_user")
public class SysUser {

    @TableId
    private Long id;

    private String username;

    private String nickname;

    private String email;

    private String phone;

    private String password;

    private Boolean enabled;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
