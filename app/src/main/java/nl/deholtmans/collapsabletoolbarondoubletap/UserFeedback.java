package nl.deholtmans.collapsabletoolbarondoubletap;

import android.content.Context;
import android.widget.Toast;

public class UserFeedback {
    private static Context myContext = null;

    public static void show( String message) {
        show( message, Toast.LENGTH_SHORT);
    }
    public static void showShort( String message) {
        show( message, Toast.LENGTH_SHORT);
    }
    public static void showLong( String message) {
        show( message, Toast.LENGTH_LONG);
    }
    public static void show(String message, int duration) {
        if( myContext == null) {
            myContext = MainActivity.mainActivity;
        }
        Toast toast = Toast.makeText( myContext, message, duration);
        toast.show();
    }
}
