package com.dao;

import com.utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.update(connection, sql, param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

    public List<T> QueryMany(String sql, Class<T> clazz, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

    public T QuerySingleLine(String sql, Class<T> clazz, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

    public Object QueryScalar(String sql, Class<T> clazz, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            return queryRunner.query(connection, sql, new ScalarHandler(), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

}
