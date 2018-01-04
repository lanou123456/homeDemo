package util;

public class ELUtil {
    /**
     * 1,方法静态
     * 2,方法有返回值
     *
     * @param input
     * @return
     */



    public  static String reverse(String input) {

        if (input.length() <= 0) {
            return input;
        }
        return reverse(input.substring(1)) + input.charAt(0);

    }

}
