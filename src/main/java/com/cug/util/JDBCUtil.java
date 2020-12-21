package com.cug.util;

import java.sql.*;

public class JDBCUtil {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if(connection == null || connection.isClosed()){
            String url = "jdbc:mysql://127.0.0.1:3306/huaxia_genealogies?useSSL=false";
            String userName = "root";
            String userPassword = "ycsniubi88";
            connection = DriverManager.getConnection(url, userName, userPassword);
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
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
