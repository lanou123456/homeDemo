package com.lanou3g.study.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    static {
        try {
            Properties prop =new Properties();
            prop.load(new FileReader("src/jdbc.properties"));
            String driverName= prop.getProperty("driverName");
            url = prop.getProperty("url");
            database = prop.getProperty("database");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+"\n\t\t"+"请将配置文件jdbc.properties放入到src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String url;
    private static String database;
    private static String user;
    private static String password;


    public  static Connection getConnection(){
        try {

            Connection con = DriverManager.getConnection(
                    url+database,user,password
            );
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  static  void  execute(ExecuteInter e){
    try {

        Connection con = DriverManager.getConnection(
                url+database,user,password
        );
        e.execute(con).close();
       con.close();
    } catch (SQLException e1) {
        e1.printStackTrace();
    }

}


public static  void showRs(ResultSet rs){
    try {
        while (rs.next()){
            System.out.print(rs.getString(1)+"\t");
            System.out.print(rs.getString(2)+"\t");
            System.out.print(rs.getString(3)+"\t");
            System.out.print(rs.getString(4)+"\t");
            System.out.println();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
