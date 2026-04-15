package com.fei.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.fei.dao.UserDao;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<String> findAll() {
        //1.加载并读取user.txt文件获取数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
        return lines;
    }
}
