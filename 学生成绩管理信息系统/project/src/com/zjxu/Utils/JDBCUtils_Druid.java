package com.zjxu.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class JDBCUtils_Druid {
    public static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\我的代码\\我的项目\\学生成绩管理信息系统\\project\\src\\com\\zjxu\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean closeAll(ResultSet resultSet, Statement statement, Connection connection) {
        boolean flag = false;
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            return (flag = true);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
