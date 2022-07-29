package com.service;

import com.dao.MenuDao;
import com.domain.Menu;

import java.util.List;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class MenuService {
    private MenuDao menuDao = new MenuDao();

    public List<Menu> list() {
        return menuDao.QueryMany("select * from menu", Menu.class);
    }

    public Menu getMenu_ById(int id) {
        return menuDao.QuerySingleLine("select * from menu where id=?", Menu.class, id);
    }

    public boolean order(String id, String name) {
        // TODO: 2022/7/27 点餐待完成
        return false;
    }
}
