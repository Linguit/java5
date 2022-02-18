package com.sangeng.service;

import com.sangeng.dao.UserMapper;
import com.sangeng.bean.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User getUser(String username,String password){//(数据库有的抽取出来)用户登录
        System.out.println(username+":"+password);
        return userMapper.getUser(username,password);
    }


    public User getAd(String adname,String adpassword){  //管理员登录
        System.out.println(adname+":"+adpassword);
        return userMapper.getAd(adname,adpassword);
    }

    public User getMessage(String username,String password){//实现数据存入数据库
        System.out.println(username+":"+password);
        return userMapper.getMessage(username,password);
    }
    public User getCollect(String name,String author){ //收藏功能
        System.out.println(name+":"+author);
        return userMapper.getMessage(name,author);
    }

    public User getUser_name1(String username){//数据库里面有的抽取出来
        System.out.println(username);
        return userMapper.getUser_name1(username);
    }


    public User getUser_password1(String password){//数据库里有的抽取出来
        System.out.println(password);
        return userMapper.getUser_name1(password);
    }

    public List<User> fenye(int n1, int n2){  //分页
        System.out.println(n1+":"+n2);
        return userMapper.fenye(n1,n2);
    }

    public List<User> find(String name1){   //模糊查询
        System.out.println(name1);
        return userMapper.find(name1);
    }
    public List<User> check(){  //管理员审查
        return userMapper.check();
    }

    public User delete(String name1){
        System.out.println(name1);
        return userMapper.delete(name1);
    }

    public Md5Hash testMd5(User password){
        int times=1;
        String salt="abc";
        Md5Hash md=new Md5Hash(password,salt,times);
        return md;
    }
}
