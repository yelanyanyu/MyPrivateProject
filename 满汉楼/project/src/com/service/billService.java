package com.service;

import com.dao.billDao;
import com.domain.bill;

import java.util.List;
import java.util.UUID;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class billService {
    billDao billDao = new billDao();
    MenuService menuService = new MenuService();
    dinningTableService dinningTableService = new dinningTableService();

    public void list() {
        List<bill> bills = billDao.QueryMany("select * from bill", bill.class);
        for (bill bill : bills) {
            System.out.println(bill);
        }
    }

    /**
     * 更新账单信息
     *
     * @param menuId
     * @param nums
     * @param dinningTableId
     * @return
     */
    public int updateBill(int menuId, int nums, int dinningTableId) {
        UUID billId = UUID.randomUUID();
        return billDao.update("insert into bill values(null,?,?,?,?,?,now(),'未支付')",
                billId.toString(), menuId, nums, menuService.getMenu_ById(menuId).getPrice() * nums,
                dinningTableId);
    }

    /**
     * 点餐方法
     *
     * @param menuId
     * @param nums
     * @param dinningTableId
     * @return
     */
    public boolean orderMenu(int menuId, int nums, int dinningTableId) {
        //更新订单状态
        int update = updateBill(menuId, nums, dinningTableId);
        if (update <= 0) {
            return false;
        }
        //更新餐桌状态为就餐中
        return dinningTableService.updateState(dinningTableId, "就餐中");
    }

    public boolean hasUnpaidBill(int id) {
        bill bill = billDao.QuerySingleLine("select * from bill where id=? and state='未结账'", bill.class, id);
        return bill != null;
    }

    /**
     * 1.选择支付方式，更新bill表所有数据的支付状态(State)和支付时间(覆盖billDate);
     * 2.(*)存入后台数据库
     * 3.餐桌状态更改为空;
     * 4.打印最终账单;
     *
     * @return
     */
    public boolean payAllBill(int dinningTableID, String payMode) {
        // TODO: 2022/7/29 结账
        //1.更新bill
        int update = billDao.update("update bill set state=?,billDate=now() where id=?", payMode, dinningTableID);
        if (update <= 0) {
            System.out.println("结账失败");
            return false;
        }

        //2.更新table的状态
        return dinningTableService.resetData(dinningTableID);
    }

}
