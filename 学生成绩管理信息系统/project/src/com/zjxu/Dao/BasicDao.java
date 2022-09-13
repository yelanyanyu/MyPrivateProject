package com.zjxu.Dao;

import com.zjxu.Utils.JDBCUtils_Druid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yelanyanyu@zjxu.edu.cn
 * @version 1.0
 */
@SuppressWarnings({"all"})
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

    public List<Map<String, Object>> QueryByMap(String sql, Object... param) {
        Connection connection = null;
        try {
            connection = JDBCUtils_Druid.getConnection();
            List<Map<String, Object>> mapList = queryRunner.query(connection, sql, new LinkMapListHandler());
            return mapList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeAll(null, null, connection);
        }
    }

    /**
     * 由于HashMap是无序的，所以返回时无法保证列的顺序，这里用LinkedHashMap就保证了列的顺序
     */
    public class LinkMapListHandler extends MapListHandler {

        @Override
        protected Map<String, Object> handleRow(ResultSet rs) throws SQLException {
            Map<String, Object> result = new LinkedHashMap<String, Object>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                result.put(rsmd.getColumnName(i), rs.getObject(i));
            }
            return result;
        }
    }

}
