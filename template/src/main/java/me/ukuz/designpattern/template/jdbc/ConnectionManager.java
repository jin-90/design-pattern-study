package me.ukuz.designpattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author ukuz90
 * @date 2019-05-11
 */
public class ConnectionManager {

    private DataSource dataSource;
    private final LinkedBlockingQueue<Connection> connectionPool;

    public ConnectionManager(int poolSize, DataSource dataSource) {
        poolSize = Math.max(16, poolSize);
        this.dataSource = dataSource;
        this.connectionPool = new LinkedBlockingQueue<>(poolSize);
    }

    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            return dataSource.getConnection();
        }
        try {
            return connectionPool.poll(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return dataSource.getConnection();
        }
    }

    public void turnbackConnection(Connection connection) {
        try {
            if (!connectionPool.offer(connection, 100, TimeUnit.MILLISECONDS)) {
                connection.close();
            }
        } catch (InterruptedException e) {
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
