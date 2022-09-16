package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Utils.inputUtility;
import com.zjxu.studentManageSystem.Utils.ViewUtils;
import com.zjxu.studentManageSystem.service.usersService;

import static com.zjxu.studentManageSystem.Utils.ViewUtils.exitView;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class LoginView{
    usersService usersService = new usersService();

    public static void loginView() {
        boolean loop = true;
        System.out.println("=======登录=======");
        while (loop) {
            System.out.println("是否退出程序？1退出");
            int i = inputUtility.readInt();
            if (i == 1) {
                loop = false;
                exitView.exitSure();
            }
            System.out.print("username:");
            String username = inputUtility.readString(64);
            System.out.print("password:");
            String pwd = inputUtility.readString(64);
            int login = ViewUtils.usersService.Login(username, pwd);
            if (login == 1) {
                methodView.methodView();
                loop = false;
            } else {
                System.out.println("登录失败，有没有退出的登录!!!");
            }
        }
    }
}
