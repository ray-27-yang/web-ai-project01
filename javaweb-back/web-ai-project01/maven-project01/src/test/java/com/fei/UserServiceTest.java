package com.fei;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("用户信息测试类")
public class UserServiceTest {
    private UserService userService;
    @BeforeEach
    public void setUp(){
        userService = new UserService();
    }

        /**
        * 测试性别-null值
        */
        @DisplayName("测试用户性别-null")
        @Test
        public void testGetGender(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                userService.getGender(null);
            });
        }
        /**
         * 测试空串""
        */
        @Test
        @DisplayName("测试用户性别-空串")
        public void testGetGender1(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                userService.getGender("");
            });
        }
        /**
         * 测试长度不是18位
         */
        @Test
        @DisplayName("测试用户性别-长度不是18位")
        public void testGetGender3(){
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                userService.getGender("1000002001001110111");
            });
        }
        /**
        * 测试性别-参数化测试
        */
        @DisplayName("测试用户性别")
        @ParameterizedTest
        @ValueSource(strings = {"100000200100111011","100000200100111012"})
        public void testGetGender2(String idCard){
            UserService userService = new UserService();
            String gender = userService.getGender(idCard);
            //断言
            Assertions.assertEquals("男", gender, "性别获取有误");
        }
}
