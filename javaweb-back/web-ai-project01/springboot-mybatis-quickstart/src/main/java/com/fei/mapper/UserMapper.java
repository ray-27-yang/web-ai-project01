package com.fei.mapper;

import com.fei.pojo.user;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper//应用程序在运行时，会自动给该接口创建一个实现类对象（代理对象）
//并且会自动将该实现类对象存入IOC容器-bean
public interface UserMapper {
    /**
     * 查询所有用户
     */
    @Select("select * from user")
    public List<user> findAll();

    /**
     * 删除数据
     */
    @Delete("delete from user where id = #{id}")
    public void deleteByid(Integer id);

    /**
     * 新增数据
     */
    @Insert("insert into user (username,password,name,age) values (#{username},#{password},#{name},#{age})")
    public void insert(user user);

    /**
     * 更新数据
     */
    @Update("update user set username = #{username},password = #{password},age = #{age} where id = #{id}")
    public void update(user user);

    /**
     * 查询数据
     */
    @Select("select * from user where username = #{username} or password = #{password}")
    public user select(@Param("username") String username,@Param("password") String password);

}
