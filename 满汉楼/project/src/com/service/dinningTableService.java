package com.service;

import com.dao.dinningTableDao;
import com.domain.dinningTable;

import java.util.List;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class dinningTableService {
    dinningTableDao dao = new dinningTableDao();

    public List<dinningTable> dinningTableList() {
        return dao.QueryMany("select id,state from dinningTable", dinningTable.class);
    }

    public boolean orderTable(String id, String orderName, String orderTel) {
        int update = dao.update("UPDATE dinningTable SET state='用餐中',ordername=?,orderTel=? WHERE id=?", orderName, orderTel, id);
        return update > 0;
    }

    public void endEating() {

    }

    public dinningTable getdinningTable_byId(int id) {
        return dao.QuerySingleLine("select * from dinningTable where id=?", dinningTable.class, id);
    }
}
