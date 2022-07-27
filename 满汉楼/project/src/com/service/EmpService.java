package com.service;

import com.dao.EmpDao;
import com.domain.employee;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class EmpService {
    private EmpDao empDao = new EmpDao();


    public  employee getEmp(String empId, String pwd) {
        return empDao.QuerySingleLine("select * from employee where empId=? and pwd=md5(?)"
                , employee.class, empId, pwd);
    }
}
