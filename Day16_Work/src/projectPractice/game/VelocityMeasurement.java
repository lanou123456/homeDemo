package projectPractice.game;

import projectPractice.loginAndRegister.Person;
import projectPractice.api.dataExchange.Send;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class VelocityMeasurement {
    public static void Game(int d, Person person) throws IOException {
        for (int i = 3; i >0 ; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" 倒计"+i+"时秒钟后开始");
        }
        long start = System.currentTimeMillis();
        Scanner input = new Scanner(System.in);
        DateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(d==1) {
            String g = GameSimple.GameSimple(10);
            System.out.println(g);
            for (; ; ) {
                String buff = input.next();
                if (buff.equals(g)) {
                    System.out.println("恭喜通过！");
                    long a =time(start);
                    System.out.println(person.getName()+"时间为："+a);
                    Send.ReSend(person,a);
                    break;
                }
                System.out.println("输入有误");
            }

        }

        if (d==2){
            String g = GameModerate.GameModerate(20);
            System.out.println(g);
            for (; ; ) {
                String buff = input.next();
                if (buff.equals(g)) {
                    System.out.println("恭喜通过！");
                    long a= time(start);
                    System.out.println(person.getName()+"时间为："+a);
                    Send.ReSend(person,a);
                  break;
                }
                System.out.println("输入有误");
            }
        }

        if (d==3){
            String g = GameDifficulty.GameDifficulty(30);
            System.out.println(g);
            for (; ; ) {
                String buff = input.next();
                if (buff.equals(g)) {
                    System.out.println("恭喜通过！");
                    long a= time(start);
                    System.out.println(person.getName()+"时间为："+a);
                    break;
                }
                System.out.println("输入有误");
            }
        }

    }

    public static long time(long start){
        long end = System.currentTimeMillis();
        long time = end-start;

       return time;
    }


}
