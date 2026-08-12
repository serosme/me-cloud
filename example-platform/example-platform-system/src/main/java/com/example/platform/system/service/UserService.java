package com.example.platform.system.service;

import com.example.platform.system.entity.User;
import com.example.platform.system.exception.SystemException;
import com.example.platform.system.mapper.UserMapper;
import com.example.shared.web.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserMapper userMapper;

    public User queryById(Long id) {
        return Optional.ofNullable(userMapper.selectById(id))
                .orElseThrow(() -> new CustomException(SystemException.USER_NOT_FOUND));
    }
}
