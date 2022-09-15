package com.zjxu.studentManageSystem.service;

import com.zjxu.studentManageSystem.Bean.students;
import com.zjxu.studentManageSystem.Dao.usersDao;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class usersService {
    private usersDao usersDao = new usersDao();
    private studentsService studentsService = new studentsService();

    public int Login(String username, String pwd) {
        String sql = "update users set isLogin=1 where username=? and pwd=md5(?)";
        return usersDao.update(sql, username, pwd);
    }

    /**
     * @param username
     * @param pwd
     * @return 1 表示注册成功，0 表示注册失败，2 表示格式错误
     */
    public int Register(String username, String pwd) {
        //格式校验
        if (!username.matches("^[a-z|A-Z]+[\\d|_|a-z|A-Z]*$")) {
            return 2;
        }
        if (!pwd.matches("^[A-Z]+[\\d|_|a-z|A-Z]*$") && pwd.length() < 6) {
            return 2;
        }
        students student = studentsService.findByName(username);
        String sql = "insert into users values(?,md5(?),0)";
        return student == null ? (usersDao.update(sql, username, pwd) > 0 ? 1 : 0) : 0;
    }

    public int Exit(String username, String pwd) {
        String sql = "update users set isLogin=0 where username=?";
        return usersDao.update(sql, username);
    }
}
