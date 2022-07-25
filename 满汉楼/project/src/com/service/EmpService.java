package com.service;

import com.dao.EmpDao;
import com.domain.employee;
import com.utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class EmpService {
    private static EmpDao empDao = new EmpDao();


    public static employee getEmp(String empId, String pwd) {
        return empDao.QuerySingleLine("select * from employee where empId=? and pwd=md5(?)"
                , employee.class, empId, pwd);
    }
}
