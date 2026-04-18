package com.fei.controller;

import com.fei.pojo.user;
import com.fei.service.UserService;
import com.fei.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


///**
// * 用户信息的请求处理类
// */
//@RestController//@ResponseBody
//public class usercontroller {
//    @RequestMapping("/list")
//    public List<user> list() throws Exception {
//        //1.加载并读取user.txt文件获取数据
//        //以前用io流来读取，现在直接用工具类来读取
//        //找填相对路径的输入流：类加载器
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
//        //路径写死了，不建议这么操作
//        //InputStream in = new FileInputStream("D:\\develop\\javaweb-back\\web-ai-project01\\springboot-web-01\\src\\main\\resources\\user.txt");
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8,new ArrayList<>());
//        //2.解析用户信息封装成用户对象-> 集合
//        //遍历集合
//        List<user> usersList = lines.stream().map(line->{
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new user(id,username,password,name,age,updateTime);
//        }).collect(Collectors.toList());
//
//        //3.返回数据（json）
//        return usersList;//自动转化成json响应回去
//    }
//}
/**
 * 用户信息的请求处理类
 */

@RestController//@ResponseBody
public class usercontroller {
    //方法一：属性注入
    @Autowired
    private UserService userService;
//    方法二：构造函数注入
//    private final UserService userService;
//    @Autowired
//    public usercontroller(UserService userService) {
//        this.userService = userService;
//    }
//    方法三：setter注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @RequestMapping("/list")
    public List<user> list() throws Exception {
        List<user> userList = userService.findAll();
        return userList;
    }
}