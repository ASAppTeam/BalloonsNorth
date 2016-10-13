package Util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Amit on 9/14/2016.
 */
public class Utils {

    private static int SCREEN_WIDTH = 0;
    private static int SCREEN_HEIGHT = 0;

    public static void getScreenSize(Context context) {

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        SCREEN_WIDTH = metrics.widthPixels;
        SCREEN_HEIGHT = metrics.heightPixels;

        Log.i("Utils", "getScreenSize(): SCREEN_WIDTH/SCREEN_HEIGHT " + SCREEN_WIDTH + "*" + SCREEN_HEIGHT);
    }

    public static void showSplashScreen(final boolean show, int splashDisplayLength, final View mainView, final View splashScreen) {

        Log.i("Utils", "showSplashScreen(): show: " + show + ", splashDisplayLength: " + splashDisplayLength + ", mainView: " + mainView + ", splashScreen: " + splashScreen);
        mainView.setVisibility(show ? View.GONE : View.VISIBLE);
        splashScreen.setVisibility(show ? View.VISIBLE : View.GONE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                splashScreen.setVisibility(show ? View.GONE : View.VISIBLE);
                mainView.setVisibility(show ? View.VISIBLE
                        : View.GONE);
            }
        }, splashDisplayLength);

        Log.i("Utils", "showSplashScreen(): Done");
    }

    public static void showProgressBar(final boolean show, int progressBarDisplayLength, final View mainView, final View ProgressBar) {

        Log.i("Utils", "showProgressBar(): show: " + show + ", splashDisplayLength: " + progressBarDisplayLength + ", mainView: " + mainView + ", splashScreen: " + ProgressBar);
        mainView.setVisibility(show ? View.GONE : View.VISIBLE);
        ProgressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ProgressBar.setVisibility(show ? View.GONE : View.VISIBLE);
                mainView.setVisibility(show ? View.VISIBLE
                        : View.GONE);
            }
        }, progressBarDisplayLength);

        Log.i("Utils", "showProgressBar(): Done");
    }

    public static int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public static int getSCREEN_HEIGHT() {
        return SCREEN_HEIGHT;
    }

    public static void changeFont(Activity activity, Button btn, String fontName) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), fontName);
        btn.setTypeface(tf);
    }

    public static void changeFont(Activity activity, TextView textView, String fontName) {
        Typeface tf = Typeface.createFromAsset(activity.getAssets(), fontName);
        textView.setTypeface(tf);
    }

}