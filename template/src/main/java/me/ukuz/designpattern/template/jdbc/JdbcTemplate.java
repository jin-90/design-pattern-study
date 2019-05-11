package me.ukuz.designpattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ukuz90
 * @date 2019-05-11
 */
public abstract class JdbcTemplate {

    private ConnectionManager connectionManager;

    public JdbcTemplate(DataSource dataSource) {
        connectionManager = new ConnectionManager(100, dataSource);
    }

    public <T> List<T> queryList(String sql, Object...parameter) throws SQLException {
        return doQuery(sql, parameter);
    }

    private  <T> List<T> doQuery(String sql, Object...parameter) throws SQLException {
        //获取连接
        Connection conn = getConnection();
        //创建语句集
        PreparedStatement pstm = createStatement(conn, sql);
        //填充SQL参数
        ResultSet rst = executeQuery(pstm, parameter);
        //执行SQL语句
        List<T> result = parseResult(rst);
        //关闭结果集
        closeResultSet(rst);
        //关闭语句集
        closeStatement(pstm);
        //归还连接
        turnbackConnection(conn);

        return result;
    }


    private Connection getConnection() throws SQLException {
        return connectionManager.getConnection();
    }

    private PreparedStatement createStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement pstm, Object...parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            pstm.setObject(i+1, parameters[i]);
        }
        return pstm.executeQuery();
    }

    private <T> List<T> parseResult(ResultSet rst) throws SQLException {
        List<T> list = new ArrayList<>();
        while(rst.next()) {
            list.add(wrapRow(rst, rst.getRow()));
        }
        return list;
    }

    private void closeResultSet(ResultSet rst) throws SQLException {
        rst.close();
    }

    private void closeStatement(PreparedStatement pstm) throws SQLException {
        pstm.close();
    }

    private void turnbackConnection(Connection conn) {
        connectionManager.turnbackConnection(conn);
    }

    abstract <T> T wrapRow(ResultSet rst, int rowNum) throws SQLException;
}
