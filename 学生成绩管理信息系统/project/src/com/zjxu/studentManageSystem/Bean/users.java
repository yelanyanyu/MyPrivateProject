package com.zjxu.studentManageSystem.Bean;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class users {
    public String username;
    public String pwd;
    public int isLogin;

    public users(String username, String pwd, int isLogin) {
        this.username = username;
        this.pwd = pwd;
        this.isLogin = isLogin;
    }

    public users() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    @Override
    public String toString() {
        return "user{" +
                "username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", isLogin=" + isLogin +
                '}';
    }
}
