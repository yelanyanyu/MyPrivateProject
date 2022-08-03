package com.view;

import com.dao.dinningTableDao;
import com.domain.Menu;
import com.domain.dinningTable;
import com.domain.employee;
import com.service.EmpService;
import com.service.MenuService;
import com.service.billService;
import com.service.dinningTableService;
import com.utils.Utility;

import java.util.List;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MHLview {
    private boolean loop = true;
    private String key = "";
    private dinningTableService dinningTableService = new dinningTableService();
    private dinningTableDao dinningTableDao = new dinningTableDao();
    private MenuService menuService = new MenuService();
    private billService billService = new billService();

    public void orderTable() {
        System.out.println("================预定餐桌===================");
        System.out.print("请输入餐桌id：");
        int tableId = Utility.readInt();
        System.out.print("\n预定人：");
        String orderName = Utility.readString(50);
        System.out.print("\n电话号码：");
        String orderTel = Utility.readString(50);
        dinningTable dinningTable = dinningTableService.getdinningTable_byId(tableId);
        if (dinningTable == null || !dinningTable.getState().equals("空")) {
            System.out.println("预定失败");
        } else {
            dinningTableService.orderTable(String.valueOf(tableId), orderName, orderTel);
            System.out.println("====================预定成功===============");
        }
    }

    private void listDinningTable() {
        System.out.println("===============这是餐桌状态================");
        List<dinningTable> dinningTables = dinningTableService.dinningTableList();
        System.out.println(dinningTables);
    }

    private void listMenu() {
        System.out.println("==================菜肴=============");
        System.out.println("id\t\t\tName\t\ttype\t\tprice");
        List<Menu> menuList = menuService.list();
        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }

    public void listBill1() {
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t\t状态");
        billService.list();
    }

    private void payBill() {
        // TODO: 2022/8/2 20220802
        System.out.println("============================结账服务===========================");
        System.out.print("请选择要结账的餐桌编号(-1退出)：");
        int dinningTableID = Utility.readInt();
        if (dinningTableID == -1) {
            System.out.println("========取消结账=======");
            return;
        }

        //验证餐桌是否存在
        dinningTable dinningTable = dinningTableService.getdinningTable_byId(dinningTableID);
        if (dinningTable == null) {
            System.out.println("=====该餐桌不存在=====");
            return;
        }

        //验证是否存在未支付的订单
        if (!billService.hasUnpaidBill(dinningTableID)) {
            System.out.println("=====该餐桌没有待支付的订单=====");
            return;
        }

        System.out.print("结账方式(现金/支付宝/微信/其他)：");
        String payMode = Utility.readString(20, "");
        // TODO: 2022/8/2 结账
        if (billService.payAllBill(dinningTableID,payMode)) {
            System.out.println("======结账成功======");
        }else {
            System.out.println("======结账失败======");
            return;
        }

    }


    private void orderMenu(employee emp) {
        System.out.println("==============================点餐服务===========================");
        System.out.print("请输入点餐的桌号(-1 退出)：");
        int dinningTableID = Utility.readInt();
        dinningTable dinningTable = dinningTableService.getdinningTable_byId(dinningTableID);
        if (dinningTableID == -1) {
            System.out.println("退出成功");
            return;
        }
        if (dinningTable == null) {
            System.out.println("找不到对应餐桌！！！！！！！！！！！！！");
            return;
        }
        System.out.print("请输入菜品编号(-1 退出)：");
        int menuId = Utility.readInt();
        Menu menu = menuService.getMenu_ById(menuId);
        if (menuId == -1) {
            System.out.println("退出成功");
            return;
        }
        if (menu == null) {
            System.out.println("找不到对应餐桌！！！！！！！！！！！！！");
            return;
        }
        System.out.print("请输入菜品数量(-1 退出)：");
        int nums = Utility.readInt();
        if (nums == -1) {
            System.out.println("退出成功");
            return;
        }
        System.out.print("点菜与否？(Y/N)：");
        String s = Utility.readString(1);
        if (s.equals("N")) {
            System.out.println("退出成功");
            return;
        }
        //更新订单状态 利用billService
        boolean flag = billService.orderMenu(menuId, nums, dinningTableID);
        if (!flag) {
            System.out.println("订餐失败，请联系管理员");
        }
        System.out.println("订餐成功!!!!!!!!!!!!!!!");
    }

    //显示主菜单
    public void mainmenu() {
        while (loop) {
            System.out.println("=========================满汉楼========================");
            System.out.println("\t\t1.登录满汉楼;");
            System.out.println("\t\t2.退出满汉楼;");
            System.out.println("请输入你的选择:");
            int i = Utility.readInt();
            if (i == 1) {
                System.out.println("请输入账号：");
                System.out.println("请输入密码：");
                String user = Utility.readString(50);
                String pwd = Utility.readString(50);
                EmpService empService = new EmpService();
                employee emp = empService.getEmp(user, pwd);

                if (emp != null) {
                    secondMenu(emp);
                } else {
                    System.out.println("账号或密码错误");
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

    public void secondMenu(employee emp) {
        while (loop) {
            System.out.println("==========================满汉楼二级菜单[" + emp.getName() + "]==========================");
            System.out.println("\t\t 1.显示餐桌状态");
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
                    listDinningTable();
                    break;
                case 2:
                    orderTable();
                    break;
                case 3:
                    listMenu();
                    break;
                case 4:
                    orderMenu(emp);
                    break;
                case 5:
                    listBill1();
                    break;
                case 6:
                    // TODO: 2022/8/1 结账
                    //1.查看某个餐桌是否有未结账的菜单
                    //2.修改bill表的状态（state）与dinningTable表的信息
                    //3.
                    payBill();
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
