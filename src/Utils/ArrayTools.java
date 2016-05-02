package Utils;

import java.util.List;

/**
 * Created by HeGuanyuan on 2016/4/27/027.
 * 数组工具
 */
public class ArrayTools {

    public static int min(int[] in) {
        if (in.length == 0)
            return 0;
        int out = in[0];
        for (int i = 0; i < in.length; i++) {
            if (in[i] < out)
                out = in[i];
        }
        return out;
    }

    public static double min(double[] in) {
        if (in.length == 0)
            return 0.0f;
        double out = in[0];
        for (int i = 0; i < in.length; i++) {
            if (in[i] < out)
                out = in[i];
        }
        return out;
    }

    public static double min(List<Double> in) {
        if (in == null || in.size() == 0)
            return 0.0f;
        double out = in.get(0);
        for (int i = 0; i < in.size(); i++) {
            if (in.get(i) < out)
                out = in.get(i);
        }
        return out;
    }


}
