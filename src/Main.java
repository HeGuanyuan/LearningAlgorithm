import java.util.Scanner;

import Utils.StringUtils;

/**
 * Created by HeGuanyuan on 2016/5/3/003.
 * 用来测试的
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            String string = scanner.nextLine();
            System.out.println("vaild name :" + StringUtils.vaildUserName(string));
            System.out.println("vaild passwd :" + StringUtils.validPasswd(string));
        }
    }

}
