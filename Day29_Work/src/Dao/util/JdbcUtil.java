package Dao.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    static {
        try {

            Properties info = new Properties();
            ClassLoader lc = JdbcUtil.class.getClassLoader();
            InputStream is = lc.getResourceAsStream("Jdbc.properties");
            info.load(is);
            String driverName= info.getProperty("driverName");
            url = info.getProperty("url");
            database = info.getProperty("database");
            user = info.getProperty("user");
            password = info.getProperty("password");

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


    public static void close(ResultSet rs){
        close(rs,null,null);
    }

    public static void close(Statement stt){
        close(null,stt,null);
    }

    public static void close(Connection conn){
        close(null,null,conn);
    }


    public static void close(ResultSet rs, Statement stt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stt != null){
            try {
                stt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



}
