package com.zjxu.studentManageSystem.view;

import com.zjxu.studentManageSystem.Utils.Utility;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class LoginView extends AllView{
    public void loginView() {
        boolean loop = true;
        System.out.println("=======登录=======");
        System.out.println("是否退出？1退出");
        int i = Utility.readInt();
        if(i==1){
            // TODO: 2022/9/15 填写退出的逻辑 
        }
        System.out.print("username:");
        String username = Utility.readString(64);
        System.out.println("password:");
        String pwd = Utility.readString(64);
    }
}
