package Util;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * Created by Amit on 9/14/2016.
 */
public class Utils {

    public static void getScreenSize(Context context) {

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        Log.i("Utils", "getScreenSize(): SCREEN_WIDTH/SCREEN_HEIGHT " + width + "*" + height);
    }

    public static void showSplashScreen(final boolean show, int splashDisplayLength, final View mainView, final View splashScreen) {

        Log.i("Menu", "showSplashScreen(): " + show);
        mainView.setVisibility(show ? View.GONE : View.VISIBLE);
        splashScreen.setVisibility(show ? View.VISIBLE : View.GONE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                splashScreen.setVisibility(show ? View.GONE : View.VISIBLE);
                mainView.setVisibility(show ? View.VISIBLE
                        : View.GONE);
            }
        }, splashDisplayLength);
    }

    public void abc(Activity a, Class c){

    }
}
