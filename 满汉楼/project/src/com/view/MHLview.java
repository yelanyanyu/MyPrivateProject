package com.view;

import com.utils.Utility;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class MHLview {
    private boolean loop = true;
    private String key = "";

    //显示主菜单
    public void mainmenu() {
        while (loop) {
            System.out.println("=========================满汉楼========================");
            System.out.println("\t\t1.登录满汉楼;");
            System.out.println("\t\t2.退出满汉楼;");
            System.out.println("请输入你的选择:");
            int i = Utility.readInt();
            if (i == 1) {
                // TODO: 2022/7/25 登录界面
                System.out.println("请输入账号：");
                System.out.println("请输入密码：");
                String user = Utility.readString(50);
                String pwd = Utility.readString(50);
                if (pwd.equals("123")) {
                    secondMenu();
                } else {
                    System.out.println("密码错误");
                }
            } else if (i == 2) {
                loop = false;
                System.out.println("退出成功~");
                break;
            } else {
                System.out.println("请输入正确的选择");
            }
        }
    }

    public void secondMenu() {
        while (loop) {
            System.out.println("==========================满汉楼二级菜单==========================");
            System.out.println("\t\t 1.显示菜单状态");
            System.out.println("\t\t 2.预定餐桌");
            System.out.println("\t\t 3.显示所有菜品");
            System.out.println("\t\t 4.点餐服务");
            System.out.println("\t\t 5.查看菜单");
            System.out.println("\t\t 6.结账");
            System.out.println("\t\t 9.退出满汉楼");
            System.out.print("请输入你的选择：");
            int i = Utility.readInt(1);
            // TODO: 2022/7/25 功能完善
            switch (i) {
                case 1:
                    System.out.println("餐桌状态");
                    break;
                case 2:
                    System.out.println("预定餐桌");
                    break;
                case 3:
                    System.out.println("显示了所有菜品");
                    break;
                case 4:
                    System.out.println("点餐服务");
                    break;
                case 5:
                    System.out.println("查看账单");
                    break;
                case 6:
                    System.out.println("结账");
                    break;
                case 9:
                    System.out.println("退出满汉楼系统");
                    loop = false;
                    break;
                default:
                    System.out.println("请输入合理的选择");
                    break;
            }
        }
    }
}
