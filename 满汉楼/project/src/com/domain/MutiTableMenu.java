package com.domain;

import java.util.Date;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class MutiTableMenu {
    private int id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer dinningTableId;
    private Date billDate;
    private String state;
    private String name;

    public MutiTableMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDinningTableId() {
        return dinningTableId;
    }

    public void setDinningTableId(Integer dinningTableId) {
        this.dinningTableId = dinningTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MutiTableMenu(int id, String billId, Integer menuId, Integer nums, Double money, Integer dinningTableId, Date billDate, String state, String name) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.dinningTableId = dinningTableId;
        this.billDate = billDate;
        this.state = state;
        this.name = name;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + menuId +
                "\t\t\t" + nums +
                "\t\t\t" + money +
                "\t" + dinningTableId +
                "\t\t" + billDate +
                "\t\t" + state +
                "\t\t" + name;
    }
}
