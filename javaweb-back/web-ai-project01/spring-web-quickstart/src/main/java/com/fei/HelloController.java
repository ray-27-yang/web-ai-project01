package com.fei;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示当前类是一个请求处理类
public class HelloController {
    @RequestMapping("/hello")
    public String hello(String name){
        System.out.println("name:" + name);//输出到控制台
        return "Hello" + name + "~";//给前端响应的字符串
    }
}
