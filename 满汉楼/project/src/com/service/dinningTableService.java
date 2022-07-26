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
}
