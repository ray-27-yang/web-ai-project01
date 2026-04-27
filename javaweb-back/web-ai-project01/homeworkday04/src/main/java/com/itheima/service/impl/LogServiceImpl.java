package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.pojo.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
    private LogDao logDao;
    @Autowired
    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    public List<Log> findAll() {
        List<String> lines = logDao.findAll();
        //2. 对原始数据进行处理 , 组装日志数据
        List<Log> logList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            return new Log(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
        }).collect(Collectors.toList());
        return logList;
    }
}
