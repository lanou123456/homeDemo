package com.lanou3g.study.work;

import java.sql.*;
import java.util.Scanner;

public class Region {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner input =new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/day21", "root", "123");

        PreparedStatement pstate =con.prepareStatement("INSERT  INTO  data_user  VALUES  (?,?,?)" );
        while (true) {
             int count=1;
            System.out.println("用户名：");
            String username = input.next();
            System.out.println("名：");
            String name = input.next();
            System.out.println("密码：");
            String password = input.next();
            ResultSet resultSet = DateMysql.DateMyaql();
            while (resultSet.next()) {
                if ((resultSet.getString(1)).equals(username)) {
                    count=0;
                    System.out.println("用户名重复");
                    break;
                }
            }
            if (count==0){
                continue;
            }

            pstate.setString(1, username);
            pstate.setString(2, name);
            pstate.setString(3, password);
            int update = pstate.executeUpdate();


            con.close();
            pstate.close();
        }
    }

}
