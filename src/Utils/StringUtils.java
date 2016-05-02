package Utils;

import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

/**
 * Created by HeGuanyuan on 2016/3/28/028.
 * 字符串工具类
 */
public abstract class StringUtils {
    public static String getWeekday(int w) {
        switch (w) {
            case (0):
                return "星期一";
            case (1):
                return "星期二";
            case (2):
                return "星期三";
            case (3):
                return "星期四";
            case (4):
                return "星期五";
            case (5):
                return "星期六";
            case (6):
                return "星期天";
        }
        return "";
    }

    public boolean isEmailAddr(String s) {
        return true;
    }

    public boolean isPhoneNumber(String s) {
        return true;
    }

    public static boolean isEmpty(String str) {
        return (null == str || str.trim().equals("") || str.trim().equals("null"));
    }

    public static String getString(int[] ints) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (int i : ints) {
            builder.append(i);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(" ]");
        return builder.toString();
    }

    public static String getString(double[] ints) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        for (double i : ints) {
            builder.append(i);
            builder.append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(" ]");
        return builder.toString();
    }

    public static String getMAC() {

        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (interfaces.hasMoreElements()) {
            NetworkInterface iF = interfaces.nextElement();

            byte[] addr = new byte[0];
            try {
                addr = iF.getHardwareAddress();
            } catch (SocketException e) {
                e.printStackTrace();
            }
            if (addr == null || addr.length == 0) {
                continue;
            }

            StringBuilder buf = new StringBuilder();
            for (byte b : addr) {
                buf.append(String.format("%02X:", b));
            }
            if (buf.length() > 0) {
                buf.deleteCharAt(buf.length() - 1);
            }
            String mac = buf.toString();
        }
        return "";

//        try {
//            NetworkInterface networkInterface = NetworkInterface.getByName("");
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//
//        String macSerial = null;
//        String str = "";
//
//        try {
//            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
//            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
//            LineNumberReader input = new LineNumberReader(ir);
//
//            for (; null != str; ) {
//                str = input.readLine();
//                Log.d("getDeviceId", str + "");
//                if (str != null) {
//                    macSerial = str.trim();// 去空格
//                    break;
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return macSerial;

    }

    public static String md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte[] encryption = md5.digest();

            StringBuffer strBuf = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    strBuf.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            return strBuf.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        }

    }

}
