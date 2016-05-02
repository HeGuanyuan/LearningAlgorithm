package As;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HeGuanyuan on 2016/4/14/014.
 * 翻转烙饼的问题
 */
public class A0414 {
    private static List<Integer> cakes = new ArrayList<>();
    private static int minCount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入烙饼个数：");
        int cakeCount = in.nextInt();
        for (int i = 0; i < cakeCount; i++) {
            cakes.add(in.nextInt());
        }

        System.out.println(cakes.toString());

        System.out.println(calLowerBound(cakes));

        for (int i = 0; i < cakes.size(); i++) {
            reverseCakes(copyCakes(cakes), i, cakes.size() - 1, 0);
        }
        System.out.println("min: " + minCount);
    }


    private static void reverseCakes(List<Integer> cakes, final int head, final int rear, int times) {
        if (head < 0 || rear > cakes.size())
            return;
        if ((times > minCount && minCount != 0) || times > 20)
            return;

        if (minCount != 0 && (times + calLowerBound(cakes) > minCount))
            return;

        boolean succeed = true;
        for (int i = 1; i < cakes.size(); i++) {
            if (cakes.get(i) > cakes.get(i - 1)) {
                succeed = false;
                break;
            }
        }

        if (succeed) {
            minCount = times;
            System.out.println("min: " + minCount + " : " + cakes);
        } else {
            int h = head;
            int r = rear;
            for (int i = 0; i < (rear - head + 1) / 2; i++, h++, r--) {
                if (h == r) return;
                int temp = cakes.get(h);
                cakes.set(h, cakes.get(r));
                cakes.set(r, temp);
            }

            times++;

            for (int i = 0; i < cakes.size(); i++) {
                reverseCakes(copyCakes(cakes), i, cakes.size() - 1, times);
            }
        }
    }

    private static List<Integer> copyCakes(List<Integer> c) {
        List<Integer> newCakes = new ArrayList<>();
        newCakes.addAll(c);
        return newCakes;
    }

    private static int calLowerBound(List<Integer> cakes) {
        int lowerBound = 0;
        int ascend = 1;
        for (int i = 1; i < cakes.size(); i++) {
            if (ascend * (cakes.get(i) - cakes.get(i - 1)) > 0) {
                lowerBound++;
                ascend = -ascend;
            }
        }
        return lowerBound;
    }

}
