package com.fei;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {
    /**
     * 方式一：HttpServletResponse设置响应数据
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws Exception {
        //1.设置响应状态码
        response.setStatus(200);
        //2.设置响应头
        response.setHeader("name","fei");
        //3.设置响应体
        response.getWriter().write("<h1>hello world<h1>");
    }
    /**
     * 方式二：ResponseEntity设置响应数据,Spring中提供的方式
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity.status(401)
                .header("name","fei")
                .body("<h1>hello world<h1>");

    }
}
