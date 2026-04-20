package com.fei;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserService1Test {
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserService();
    }

    @Test
    public void testIsBeijing() {
        System.out.println("=== 测试 isBeijing 方法 ===");
        String beijingIdCard = "110101199001011234";
        String shanghaiIdCard = "310101199001011234";

        boolean result1 = userService.isBeijing(beijingIdCard);
        boolean result2 = userService.isBeijing(shanghaiIdCard);

        System.out.println("北京身份证 " + beijingIdCard + " 是否北京: " + result1);
        System.out.println("上海身份证 " + shanghaiIdCard + " 是否北京: " + result2);
    }

    @Test
    public void testGetAge() {
        System.out.println("=== 测试 getAge 方法 ===");
        String idCard = "110101199001011234";
        Integer age = userService.getAge(idCard);
        System.out.println("身份证 " + idCard + " 的年龄: " + age);
    }

    @Test
    public void testGetGender() {
        System.out.println("=== 测试 getGender 方法 ===");
        String maleIdCard = "110101199001011231";
        String femaleIdCard = "110101199001011232";

        String gender1 = userService.getGender(maleIdCard);
        String gender2 = userService.getGender(femaleIdCard);

        System.out.println("身份证 " + maleIdCard + " 的性别: " + gender1);
        System.out.println("身份证 " + femaleIdCard + " 的性别: " + gender2);
    }

    @Test
    public void testGetYear() {
        System.out.println("=== 测试 getYear 方法 ===");
        String idCard = "110101199001011234";
        String year = userService.getYear(idCard);
        System.out.println("身份证 " + idCard + " 的出生年份: " + year);
    }

    @Test
    public void testGetMonth() {
        System.out.println("=== 测试 getMonth 方法 ===");
        String idCard = "110101199005011234";
        String month = userService.getMonth(idCard);
        System.out.println("身份证 " + idCard + " 的出生月份: " + month);
    }
}
