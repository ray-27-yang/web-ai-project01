package com.fei;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        //1.获取请求方式
        String method = request.getMethod();//GET
        System.out.println("请求方式：" + method);
        //2.获取请求url地址
        String url = request.getRequestURL().toString();
        System.out.println("请求url：" + url);//http://localhost:8080/request
        String uri = request.getRequestURI().toString();
        System.out.println("请求uri：" + uri);//request
        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议：" + protocol);//HTTP/1.1
        //4.获取请求参数-name
        String name = request.getParameter("name");
        System.out.println("请求参数-name：" + name);
        //5.获取请求头-Accept
        String accept = request.getHeader("Accept");
        System.out.println("请求头-Accept：" + accept);//text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
        return "OK";
    }
}
