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

    /**
     * 通过餐桌 id 得到相应的餐桌对象
     *
     * @param id 餐桌 id
     * @return
     */
    public dinningTable getdinningTable_byId(int id) {
        return dao.QuerySingleLine("select * from dinningTable where id=?", dinningTable.class, id);
    }

    public boolean updateState(int tableId, String content) {
        int update = dao.update("update dinningTable set state=? where id=?", content, tableId);
        return update > 0 ? true : false;
    }

    public boolean resetData(int id) {
        int update = dao.update("update dinningTable set state='空',orderName='',orderTel='' where id=?", id);
        return update > 0;
    }
}
