package com.zjxu.studentManageSystem.service;

import com.zjxu.studentManageSystem.Bean.students;
import com.zjxu.studentManageSystem.Dao.studentDao;

import java.util.List;
import java.util.Map;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class studentsService {
    studentDao studentDao = new studentDao();

    public List<students> AllStudents() {
        String sql = "select * from students";
        List<students> studentsList = studentDao.QueryMany(sql, students.class);
        return studentsList;
    }

    public students findByName(String name) {
        String sql = "select * from students where `name`=?";
        students students = studentDao.QuerySingleLine(sql, students.class, name);
        return students;
    }

    public students findById(String Id) {
        String sql = "select * from students where id=?";
        students students = studentDao.QuerySingleLine(sql, students.class, Id);
        return students;
    }

    public List<students> findByClassname(String Classname) {
        String sql = "select * from students where Classname=?";
        List<students> students = studentDao.QueryMany(sql, students.class, Classname);
        return students;
    }

    public List<students> OrderByChinese(String str) {
        String sql;
        if (str.equals("up")) {
            sql = "select * from students order by Chinese";
        } else if (str.equals("down")) {
            sql = "select * from students order by Chinese desc";
        } else {
            sql = "";
        }
        List<students> students = studentDao.QueryMany(sql, students.class);
        return students;
    }

    public List<students> OrderMath(String str) {
        String sql;
        if (str.equals("up")) {
            sql = "select * from students order by math";
        } else if (str.equals("down")) {
            sql = "select * from students order by math desc";
        } else {
            sql = "";
            throw new RuntimeException("up or down!");
        }
        List<students> students = studentDao.QueryMany(sql, students.class);
        return students;
    }

    public List<students> OrderByEnglish(String str) {
        String sql;
        if (str.equals("up")) {
            sql = "select * from students order by English";
        } else if (str.equals("down")) {
            sql = "select * from students order by English desc";
        } else {
            sql = "";
        }
        List<students> students = studentDao.QueryMany(sql, students.class);
        return students;
    }

    public List<Map<String, Object>> OrderByCourseSum(String str) {
        String sql;
        if (str.equals("up")) {
            sql = "SELECT id,`name` , classname, (Chinese+English+math) AS `sum` FROM students\n" +
                    "\tORDER BY `sum`";
        } else if (str.equals("down")) {
            sql = "SELECT id,`name` , classname, (Chinese+English+math) AS `sum` FROM students\n" +
                    "\tORDER BY `sum` desc";
        } else {
            sql = "";
        }
        List<Map<String, Object>> mapList = studentDao.QueryByMap(sql);
        return mapList;
    }

    public List<students> OrderById(String str) {
        String sql;
        if (str.equals("up")) {
            sql = "SELECT *  FROM students\n" +
                    "\tORDER BY id";
        } else if (str.equals("down")) {
            sql = "SELECT * FROM students\n" +
                    "\tORDER BY id desc";
        } else {
            sql = "";
        }
        List<students> students = studentDao.QueryMany(sql, students.class);
        return students;
    }

    public List<Map<String, Object>> OrderByAvg(String str) {
        String sql;
        if (str.equals("up")) {
            sql = "SELECT id,`name` , classname,(Chinese+English+math)/3 AS `avg` FROM students\n" +
                    "\tORDER BY `avg`";
        } else if (str.equals("down")) {
            sql = "SELECT id,`name` , classname, (Chinese+English+math)/3 AS `avg`,id FROM students\n" +
                    "\tORDER BY `avg` desc";
        } else {
            sql = "";
        }
        List<Map<String, Object>> mapList = studentDao.QueryByMap(sql);
        return mapList;
    }

    public int add(int id, String name, String classname, int Chinese, int math, int English) {
        String sql = "insert into students values(?,?,?,?,?,?)";
        // TODO: 2022/9/10 正则表达式验证班级格式
        try {
            return studentDao.update(sql, id, name, classname, Chinese, math, English);
        } catch (Exception e) {
            throw new RuntimeException("加入错误，该同学或已经存在！");
        }
    }

    public int updateChineseById(int id, String name, String classname, int Chinese, int math, int English) {
        String sql = "update students set Chinese=? where id=?";
        return studentDao.update(sql, classname, id);
    }

    public boolean deleteLineById(int id) {
        String sql = "delete from students where id=?";
        int update = studentDao.update(sql, id);
        return update > 0 ? true : false;
    }

    public List<students> findMaxChinese() {
        String sql = "SELECT * FROM students \n" +
                "\tWHERE Chinese=(SELECT MAX(Chinese) FROM students)";
        List<students> students = studentDao.QueryMany(sql,students.class);
        return students;
    }

    public List<students> findMaxMath() {
        String sql = "SELECT * FROM students \n" +
                "\tWHERE math=(SELECT MAX(math) FROM students)";
        List<students> students = studentDao.QueryMany(sql,students.class);
        return students;
    }

    public List<students> findMaxEnglish() {
        String sql = "SELECT * FROM students \n" +
                "\tWHERE English=(SELECT MAX(English) FROM students)";
        List<students> students = studentDao.QueryMany(sql,students.class);
        return students;
//        Connection connection = JDBCUtils_Druid.getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sql);
//            while (resultSet.next()) {
//                String name = resultSet.getString(1);
//                String classname = resultSet.getString(2);
//                int id = resultSet.getInt(3);
//                int English = resultSet.getInt(4);
//                System.out.println(name+classname+id+English);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    public List<students> findMinChinese() {
        String sql = "SELECT id,`name`,classname,Chinese FROM students \n" +
                "\tWHERE Chinese=(SELECT Min(Chinese) FROM students)";
        List<students> students = studentDao.QueryMany(sql,students.class);
        return students;
    }

    public List<students> findMinMath() {
        String sql = "SELECT id,`name`,classname,math FROM students \n" +
                "\tWHERE Chinese=(SELECT Min(math) FROM students)";
        List<students> students = studentDao.QueryMany(sql,students.class);
        return students;
    }

    public List<students> findMinEnglish() {
        String sql = "SELECT id,`name`,classname,English FROM students \n" +
                "\tWHERE Chinese=(SELECT Min(English) FROM students)";
        List<students> students = studentDao.QueryMany(sql,students.class);
        return students;
    }

    //得到总人数
    public int NumsOfStudents() {
        String sql = "select count(*) from students";
        return studentDao.QueryByMap(sql).size();
    }

    public List<Map<String, Object>> getExcellenceRateAll(String course) {
        String sql = "SELECT classname,COUNT(CASE WHEN " + course + ">=90 THEN 1 ELSE NULL END)/COUNT(*) AS youxiulv FROM students \n" +
                "\tGROUP BY classname\n" +
                "\tORDER BY youxiulv DESC";
        List<Map<String, Object>> mapList = studentDao.QueryByMap(sql);
        return mapList;
    }

    public List<Map<String, Object>> getFailureRateAll(String course) {
        String sql = "SELECT classname,COUNT(CASE WHEN " + course + "<90 THEN 1 ELSE NULL END)/COUNT(*) AS youxiulv FROM students \n" +
                "\tGROUP BY classname\n" +
                "\tORDER BY youxiulv DESC";
        List<Map<String, Object>> mapList = studentDao.QueryByMap(sql);
        return mapList;
    }
}
