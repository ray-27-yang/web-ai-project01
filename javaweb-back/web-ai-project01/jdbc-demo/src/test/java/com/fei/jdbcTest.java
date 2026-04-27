package com.fei;

import com.fei.pojo.User;
import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbcTest {
    @Test
    public void testUpdate() throws Exception {
        //1.注册驱动,查询到驱动后复制引用
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取数据库连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1212";
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.获取SQL语句执行对象
        Statement statement = connection.createStatement();
        //4.执行SQL语句
        int i = statement.executeUpdate("update user set age = 25 where id = 1");//DML
        System.out.println(i);//sql语句执行完后影响的记录数
        //5.释放资源
        statement.close();
        connection.close();
    }
    @Test
    public void selectTest() {
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "1212";
        Connection connection = null;
        String sql = null;
        PreparedStatement preparedStatement;
        ResultSet rs = null;
        try{
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取数据库连接
            connection = DriverManager.getConnection(url, username, password);
            //准备预编译sql语句                              //通配符
            sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"daqiao");
            preparedStatement.setString(2,"123456");
            //处理结果收集,ResultSet封装查询返回的结果
            rs = preparedStatement.executeQuery();
            //处理结果集
            while (rs.next()){
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                System.out.println(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
//select count(*) from emp where username = 'songjiang' and password = ''or'1' = '1';