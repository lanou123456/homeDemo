package projectPractice.game;


public class GameDifficulty {
//    public static void main(String[] args) {
//
//        System.out.println(GameDifficulty(30));
//    }
    public static String GameDifficulty(int length) {
        char[] ss = new char[length];
        int i=0;
        while(i<length) {
            int f = (int) (Math.random()*4);
            if(f==0) {
                ss[i] = (char) ('A' + Math.random() * 26);
            }else if(f==1) {
                ss[i] = (char) ('a' + Math.random() * 26);
            }else if (f==2){
                ss[i] = (char) ('0' + Math.random() * 10);
            }else {
            ss[i] = (char) ('!' + Math.random() * 25);

        }
            i++;
        }
        String is=new String(ss);
        return is;
    }

    }

