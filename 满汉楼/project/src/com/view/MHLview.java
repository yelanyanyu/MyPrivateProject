package com.view;

import com.utils.Utility;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class MHLview {
    //显示主菜单
    public void mainmenu() {
        while (true) {
            System.out.println("======满汉楼======");
            System.out.println("\t\t1.登录满汉楼;");
            System.out.println("\t\t2.退出满汉楼;");
            System.out.println("请输入你的选择:");
            int i = Utility.readInt();
            if (i == 1) {
                secondMenu();
                break;
            } else if (i == 2) {
                System.out.println("退出成功~");
                break;
            } else {
                System.out.println("请输入正确的选择");
            }
        }
    }

    public void secondMenu() {

    }
}
