package com.fei;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserService3Test {
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userService = new UserService();
    }

    @Test
    public void testIsBeijing_True() {
        String beijingIdCard = "110101199001011234";
        Assertions.assertTrue(userService.isBeijing(beijingIdCard),
                "北京身份证应该返回 true");
    }

    @Test
    public void testIsBeijing_False() {
        String shanghaiIdCard = "310101199001011234";
        Assertions.assertFalse(userService.isBeijing(shanghaiIdCard),
                "非北京身份证应该返回 false");
    }

    @Test
    public void testGetAge() {
        String idCard = "110101199001011234";
        Integer age = userService.getAge(idCard);
        Assertions.assertNotNull(age, "年龄不应为 null");
        Assertions.assertTrue(age > 0 && age < 150,
                "年龄应该在合理范围内 (0-150)");
    }

    @Test
    public void testGetGender_Male() {
        String maleIdCard = "110101199001011231";
        String gender = userService.getGender(maleIdCard);
        Assertions.assertEquals("男", gender,
                "第17位为奇数应该是男性");
    }

    @Test
    public void testGetGender_Female() {
        String femaleIdCard = "110101199001011232";
        String gender = userService.getGender(femaleIdCard);
        Assertions.assertEquals("女", gender,
                "第17位为偶数应该是女性");
    }

    @Test
    public void testGetYear() {
        String idCard = "110101199001011234";
        String year = userService.getYear(idCard);
        Assertions.assertEquals("1990", year,
                "出生年份应该是 1990");
        Assertions.assertEquals(4, year.length(),
                "年份应该是4位数");
    }

    @Test
    public void testGetMonth() {
        String idCard = "110101199005011234";
        String month = userService.getMonth(idCard);
        Assertions.assertEquals("05", month,
                "出生月份应该是 05");
        Assertions.assertEquals(2, month.length(),
                "月份应该是2位数");
    }

    @Test
    public void testGetMonth_December() {
        String idCard = "110101199012011234";
        String month = userService.getMonth(idCard);
        Assertions.assertEquals("12", month,
                "出生月份应该是 12");
    }
}
