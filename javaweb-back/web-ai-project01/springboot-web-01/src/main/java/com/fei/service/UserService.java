package com.fei.service;

import com.fei.pojo.user;
import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     */
    public List<user> findAll();
}
