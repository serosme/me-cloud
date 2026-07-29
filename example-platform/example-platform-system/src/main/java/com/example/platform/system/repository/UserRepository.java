package com.example.platform.system.repository;

import com.example.platform.system.entity.User;
import com.example.platform.system.mapper.UserMapper;
import com.github.yulichang.repository.JoinCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JoinCrudRepository<UserMapper, User> {
}
