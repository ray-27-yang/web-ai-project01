package com.fei.service.impl;

import com.fei.dao.UserDao;
import com.fei.dao.impl.UserDaoImpl;
import com.fei.pojo.user;
import com.fei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    @Autowired//程序运行时会自动查找该类型的bean对象并赋值给成员变量
    private UserDao userDao;
    @Override
    public List<user> findAll() {
        //1.调用dao拿到数据
        List<String> lines = userDao.findAll();
        //2.解析用户信息封装成用户对象-> 集合
        //遍历集合
        List<user> usersList = lines.stream().map(line->{
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new user(id,username,password,name,age,updateTime);
        }).collect(Collectors.toList());
        return usersList;
    }
}
