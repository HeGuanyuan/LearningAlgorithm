package As;

import Utils.ArrayTools;
import Utils.Sorter;
import Utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HeGuanyuan on 2016/4/27/027.
 * 买书问题,之后还可以考虑扩展至一般性条件
 */
public class A0427 {

    private static double[] kou = new double[]{0, 0.05, 0.1, 0.2, 0.25};


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入买书的数列：");
        int[] books = new int[5];
        for (int i = 0; i < 5; i++) {
            books[i] = in.nextInt();
        }
        System.out.println("输入的买书数列: " + StringUtils.getString(books));
        Sorter.insertSortFromMax(books);
        System.out.println("有序的买书数列: " + StringUtils.getString(books));
        System.out.println("花钱最少: " + getMinCost(books));

    }

    private static double getMinCost(int[] in) {

        return min(in);

    }

    private static double min(int[] in) {
        System.out.println("in=" + StringUtils.getString(in));

        List<Double> out = new ArrayList<>();

        for (int i = 0; i < in.length; i++) {
            int[] booksContinue = copyArray(in);
            if (in[4 - i] >= 1) {
                for (int j = 0; j < 5 - i; j++) {
                    booksContinue[j] -= 1;
                }
                Sorter.insertSortFromMax(booksContinue);
                out.add((5 - i) * 8 * (1 - kou[4 - i]) + min(booksContinue));
            }
        }
        System.out.println("out=" + out.toString());
        return ArrayTools.min(out);
    }


    private static int[] copyArray(int[] in) {
        int[] out = new int[in.length];
        System.arraycopy(in, 0, out, 0, in.length);
        return out;
    }

}
