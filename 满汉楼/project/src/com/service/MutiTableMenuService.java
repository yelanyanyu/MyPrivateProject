package com.service;

import com.dao.MutiTableMenuDao;
import com.domain.MutiTableMenu;

import java.util.List;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class MutiTableMenuService {
    MutiTableMenuDao dao = new MutiTableMenuDao();

    public void listBill() {
        List<MutiTableMenu> mutiTableMenus = dao.QueryMany("SELECT bill.* ,menu.name FROM bill, menu WHERE menu.id=bill.menuId", MutiTableMenu.class);
        for (MutiTableMenu mutiTableMenu : mutiTableMenus) {
            System.out.println(mutiTableMenu);
        }
    }
}
