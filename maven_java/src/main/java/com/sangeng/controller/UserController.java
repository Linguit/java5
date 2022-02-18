package com.sangeng.controller;

import com.sangeng.bean.User;
import com.sangeng.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Controller
public class UserController {
    @Resource
    private UserService userService;



    @ResponseBody
        @GetMapping(value="loginSubmit",produces="text/json;charset=utf-8")//用户登录页面

    public String login(User user) {
        User user1 = userService.getUser(user.getUsername(), user.getPassword());
        if(user1 != null) {  //登录成功
            return "登录成功";
        }else {   //登录失败
            return "登录失败";
        }
    }

    @ResponseBody
    @GetMapping(value="loginAd",produces="text/json;charset=utf-8")//管理员登录页面

    public String loginAd(User user) {
        User user1 = userService.getAd(user.getAdname(), user.getAdpassword());
        if(user1 != null) {
            //登录成功
            return "登录成功";
        }else {   //登录失败
            return "登录失败";
        }
    }

    @ResponseBody
    @GetMapping(value="register",produces="text/json;charset=utf-8")//注册页面
    public String register(User user) {

        User user_name1 = userService.getUser_name1(user.getUsername());
        User user_password1 = userService.getUser_password1(user.getPassword());
        if(user_name1!=null||user_password1!=null)   //注册失败
        {
           return "注册失败";
        } else
        {
            userService.getMessage(user.getUsername(), user.getPassword());
            return "注册成功";
        }
    }

    @ResponseBody
    @GetMapping(value="out",produces="text/json;charset=utf-8")//注册页面
    public String toLogout(HttpSession session) {
        session.removeAttribute("user");
        return "退出登录";
    }

    @ResponseBody
    @GetMapping(value="collection",produces="text/json;charset=utf-8")//收藏页面
    public String collect(User user){

        userService.getCollect(user.getName(), user.getAuthor());
        return "收藏成功";
    }

    @ResponseBody
    @RequestMapping("update")
    public void update(MultipartFile uploadFile) throws IOException {
        //获得文件名称
        String originalFilename = uploadFile.getOriginalFilename();
        //保存文件
        uploadFile.transferTo(new File("D:\\java5\\update\\"+originalFilename));
    }

    @RequestMapping("download")
    public void download(HttpServletResponse response) throws IOException{

        response.setHeader("Content-Disposition","attachment;filename=test.txt");

        response.getOutputStream().write(Files.readAllBytes(Paths.get("D:\\java5\\download")));

    }

    @ResponseBody
    @GetMapping(value="fenye",produces="text/json;charset=utf-8")//分页页面
    public String fenye(User user){
        userService.fenye(user.getN1(),user.getN2());
        return "分页";
    }

    @ResponseBody
    @GetMapping(value="find",produces="text/json;charset=utf-8")//分页页面
    public String find(User user){
        userService.find(user.getName1());
        return "查询";
    }

    @ResponseBody
    @GetMapping(value="adcheck",produces="text/json;charset=utf-8")//审核页面
    public String check(){
        userService.check();
        return "审核";
    }
    @ResponseBody
    @GetMapping(value="addelete",produces="text/json;charset=utf-8")//管理员删除页面
    public String delete(String name1){
        userService.delete(name1);
        return "删除";
    }
}
