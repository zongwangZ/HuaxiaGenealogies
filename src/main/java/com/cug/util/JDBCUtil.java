package com.cug.util;

import java.sql.*;

public class JDBCUtil {
    private Connection connection;

    public JDBCUtil(String driverUrl) throws ClassNotFoundException {
        Class.forName(driverUrl);
    }

    public Connection getConnection(String url, String userName, String userPassword) throws SQLException {
        if(this.connection == null){
            this.connection = DriverManager.getConnection(url, userName, userPassword);
        }
        return this.connection;
    }

    public void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(connection != null && ! connection.isClosed()){
            connection.close();
        }
        if(statement != null){
            statement.close();
        }
        if(resultSet != null){
            resultSet.close();
        }
    }
}
