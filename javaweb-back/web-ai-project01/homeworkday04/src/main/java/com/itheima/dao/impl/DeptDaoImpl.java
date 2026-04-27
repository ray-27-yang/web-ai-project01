package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.DeptDao;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<String> findAll(){
        //1. 加载文件 ,  获取原始数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<String>());
        return lines;
    }
}
