package com.lanou3g.study.work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login();
    }
    public  static  void  Login() throws SQLException, ClassNotFoundException {

        Scanner input = new Scanner(System.in);
        System.out.println("输入用户名：");
        String username =input.next();
        System.out.println("输入密码：");
        String password =input.next();
        ResultSet resultSet = DateMysql.DateMyaql();
        while (resultSet.next()){

            if(resultSet.getString(1).equals(username)  && resultSet.getString(2).equals(password)){
                System.out.println("登陆成功！");
            }
        }
    }

}
