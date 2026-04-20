package com.fei;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserService2Test {
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserService();
    }

    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    public void testWithParameterized(String idCard) {
        System.out.println("\n========== 测试身份证号: " + idCard + " ==========");

        boolean isBeijing = userService.isBeijing(idCard);
        System.out.println("是否北京地区: " + (isBeijing ? "是" : "否"));

        Integer age = userService.getAge(idCard);
        System.out.println("年龄: " + age);

        String gender = userService.getGender(idCard);
        System.out.println("性别: " + gender);

        String year = userService.getYear(idCard);
        System.out.println("出生年份: " + year);

        String month = userService.getMonth(idCard);
        System.out.println("出生月份: " + month);
    }
}
