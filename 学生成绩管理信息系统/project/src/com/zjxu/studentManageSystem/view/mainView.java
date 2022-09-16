package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Utils.inputUtility;
import com.zjxu.studentManageSystem.Utils.ViewUtils;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class mainView {

    public static void inOrOut() {
        boolean loop = true;
        System.out.println("输入2注册，输入1登录，输入0退出！");
        while (loop) {
            System.out.print("你的选择：");
            int choice = inputUtility.readInt();
            if (choice == 1) {
                ViewUtils.loginView.loginView();
                loop = false;
            } else if (choice == 0) {
                ViewUtils.exitView.exitSure();
                loop = false;
            } else if (choice == 2) {
                ViewUtils.registerView.Register();
                loop = false;
            } else {
                System.out.println("请输入正确的选择！！！");
            }
        }
    }
}
