package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Utils.inputUtility;
import com.zjxu.studentManageSystem.Utils.ViewUtils;
import com.zjxu.studentManageSystem.service.usersService;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class RegisterView {
    usersService usersService = new usersService();

    public static void Register() {
        boolean loop = true;
        while (loop) {
            System.out.println("请输入用户名(字母开头):");
            System.out.print("username:");
            String username = inputUtility.readString(64);
            System.out.println("请输入密码(大写字母开头，密码长度不小于6位):");
            System.out.print("password:");
            String pwd = inputUtility.readString(64);
            int res = ViewUtils.usersService.Register(username, pwd);
            if (res == 2) {
                System.out.println("用户名或者密码格式错误！！！");
            } else if (res == 1) {
                System.out.println("注册成功~");
                loop = false;
                ViewUtils.loginView.loginView();
            } else if (res == 0) {
                System.out.println("注册失败，用户或已存在！！！");
            }
        }
    }
}
