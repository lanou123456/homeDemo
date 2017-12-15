package projectPractice.loginAndRegister;

import org.dom4j.DocumentException;
import projectPractice.api.dataExchange.Ranking;
import projectPractice.api.phone.PhoneQuery;
import projectPractice.api.weather.WeatherQuery;
import projectPractice.game.VelocityMeasurement;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        while (true) {
            System.out.println("1，登陆    2，注册");
            Scanner input = new Scanner(System.in);
            int input1 = input.nextInt();
            if (input1 == 2) {
                System.out.println("请输入用户名:");
                String username = input.next();
                System.out.println("请输入名字:");
                String name = input.next();
                System.out.println("请输入密码:");
                String password = input.next();

                Person person = new Person(username, name, password);
              int a=  Register.Reg(person);
                if (a!=1){
                  continue;
                }
            }

            if (input1 == 1) {
                System.out.println("请输入用户名：");
                String usename = input.next();
                System.out.println("亲输入密码：");
                String password = input.next();
                Person person = Login.login(usename, password);
                if (person == null) {
                    System.out.println("登陆失败！");
                } else {
                    System.out.println(person.getUsername() + "  " + person.getName() );
                    while (true) {
                        System.out.println("1,查询天气    2,手速游戏   3,查询手机号归属  4,查询手速游戏前十用户");
                        int input2 = input.nextInt();
                        if (input2 == 1) {
                            System.out.println("请输入查看的城市：");
                            String input4 = input.next();
                            WeatherQuery.Weather(input4);
                            continue;
                        }

                        if (input2 == 3) {
                            System.out.println("请输入要查询的手机号：");
                            String input5 = input.next();
                            PhoneQuery.Phone(input5);
                           continue;
                        }


                        if (input2 == 2) {
                            System.out.println("1--简单难度    2--适中难度    3--困难难度");
                            int input3 = input.nextInt();
                            switch (input3) {
                                case 1:
                                    VelocityMeasurement.Game(1, person);
                                    break;
                                case 2:
                                    VelocityMeasurement.Game(2, person);
                                    break;
                                case 3:
                                    VelocityMeasurement.Game(3, person);
                                    break;
                            }
                          continue;
                        }
                        if(input2==4){
                            Ranking.Rank();
                        }
                    }

                }

            }
            break;
        }
    }

}
