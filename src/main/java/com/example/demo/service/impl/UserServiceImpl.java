package com.example.demo.service.impl;

import com.example.demo.entity.SysUser;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: ldl
 * @Date: 2019/7/16 16:22
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public SysUser findByUserName(String username) {
        return null;
    }
}
