package com.example.demo.service;

import com.example.demo.entity.SysUser;

/**
 * @author: ldl
 * @Date: 2019/7/16 16:21
 */
public interface UserService {
     public SysUser findByUserName(String username);
}
