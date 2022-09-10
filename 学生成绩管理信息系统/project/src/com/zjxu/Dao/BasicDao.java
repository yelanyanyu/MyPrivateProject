package com.zjxu.Dao;

import com.zjxu.Utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
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
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            int update = queryRunner.update(connection, sql, param);
            return update;
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
            List<T> list = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), param);
            return list;
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
            T query = queryRunner.query(connection, sql, new BeanHandler<T>(clazz), param);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

    public Object QueryScalar(String sql, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            Object query = queryRunner.query(connection, sql, new ScalarHandler(), param);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

}
