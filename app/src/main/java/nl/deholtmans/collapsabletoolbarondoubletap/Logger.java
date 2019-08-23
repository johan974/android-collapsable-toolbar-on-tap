package nl.deholtmans.collapsabletoolbarondoubletap;

import android.util.Log;

public class Logger {
    private static String tag = "TAG";
    public static void setTag( String newtag) {
        tag = newtag;
    }
    public static void d(String msg) {
        Log.d(tag, msg);
    }

    public static void d(String msg, Throwable tr) {
        Log.d(tag, msg, tr);
    }

    public static void v(String msg) {
        Log.v(tag, msg);
    }

    public static void v(String msg, Throwable tr) {
        Log.v(tag, msg, tr);
    }

    public static void i(String msg) {
        Log.i(tag, msg);
    }

    public static void i(String msg, Throwable tr) {
        Log.i(tag, msg, tr);
    }

    public static void w(String msg) {
        Log.w(tag, msg);
    }

    public static void w(String msg, Throwable tr) {
        Log.w(tag, msg, tr);
    }

    public static void e(String msg) {
        Log.e(tag, msg);
    }

    public static void e(String msg, Throwable tr) {
        Log.e(tag, msg, tr);
    }
}


