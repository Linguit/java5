package com.sangeng.dao;

import com.sangeng.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;

public interface UserMapper {
    @Select("select * from users where username = #{username} and password = #{password}")//用户登录表
    public User getUser(@Param("username")String username, @Param("password")String password);
    @Select("select * from users where username = #{username}")
    public User getUser_name1(@Param("username")String username);  //数据库里有的
    @Select("select * from users where  password = #{password}")
    public User getUser_password1(@Param("password")String password);

    @Select("INSERT INTO users (username,password) VALUES (#{username},#{password})")//注册（插入用户信息）
    public User getMessage(@Param("username")String username, @Param("password")String password);

   @Select("INSERT INTO collects (name,author) VALUES (#{name},#{author})")//收藏（插入小说信息）
   public User getCollect(@Param("name")String name, @Param("author")String author);

   @Select("SELECT name1 introduce FROM novels ORDER BY name1 DESC LIMIT #{n1} OFFSET #{n2}") //实现分页
    public List<User> fenye(@Param("n1")int n1, @Param("n2")int n2);

   @Select("select name1,introduce from novels where name1 like #{name1}")  //模糊查找
    public List<User> find(@Param("name1")String name1);

   @Select("select author1,contents from novels")  //管理员审核信息
    public List<User> check();

    @Select("select * from administrators where adname = #{adname} and adpassword = #{adpassword};")//管理员登录表
    public User getAd(@Param("adname")String adname, @Param("adpassword")String adpassword);

    @Select(" DELETE FROM novels WHERE name1=#{name1}")
    public User delete(@Param("name1")String name1);
}
