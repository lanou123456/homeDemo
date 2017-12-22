package com.lanou3g.study.work;

import java.sql.*;

public class DateMysql {
    public static ResultSet DateMyaql() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day21", "root", "123");
        String sql ="select username,password  from data_user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
       return  resultSet;
    }
}
