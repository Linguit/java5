package com.sangeng.bean;

public class User {

    //用户信息
    private String username;
    private String password;


    //小说收藏
    private String name;
    private String author;
    public String getName() {
        return name;
    }

    //小说分页
    private int n1;
    private int n2;

    //小说分页和小说查询的数据库
    private String name1;
    private String introduce;
    private String author1;

    //管理员信息
    private String adname;
    private String adpassword;

    public String getAdpassword() {
        return adpassword;
    }

    public void setAdpassword(String adpassword) {
        this.adpassword = adpassword;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    private String contents;

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "User{"+",username='"+username+'\''+",password='"+password+'\''+",name='"+name+'\''+",author='"+author+'\''
                +",n1='"+n1+'\''+",n2='"+n2+'\''
                +'}';
    }



}
