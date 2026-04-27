package com.fei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //推荐用包装类（拆箱装箱，类型转换）：普通类有初始值，包装类支持null
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
}
