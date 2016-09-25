package com.asteam.balloonsnorth;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import Util.CustomDialogClass;
import Util.JSONParser;
import Util.Utils;

public class Menu extends AppCompatActivity {

    public static int SCREEN_WIDTH = 0;
    public static int SCREEN_HEIGHT = 0;
    public static final int SPLASH_DISPLAY_LENGTH = 100;
    public static final String PHONE_NUMBER = "0528643117";
    public static final String FONTS_NAME_MENU_BUTTONS = "fonts/ankaclm-bold-webfont.ttf";
    public static final String BASE_URL = "http://asapplicationteam.com/balloons_north/";
    public static final String ABOUT_US_JSON = "about_us/about_us_json.json";

    private Button btnAbout;
    private Button btnWeekSpecials;
    private Button btnPackages;
    private Button btnOurProducts;
    private Button btnFriendsRecommend;
    private Button btnPortfolio;
    private Button btnCallUs;
    private ImageButton btnImgFacebook;
    private TextView dialogTextView;

    private ImageView ivSplashImage;
    private View vLinearLayoutMain;

    private PopupWindow popUp;
    private LinearLayout layout;
    private TextView tv;
    private LayoutParams params;
    private LinearLayout mainLayout;
    private Button but;
    private boolean click = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        initialize();
    }

    private void initialize() {

        findViewByID();
        getScreenResolution();
        Utils.showSplashScreen(true, SPLASH_DISPLAY_LENGTH, vLinearLayoutMain, ivSplashImage);

        // Create action bar - START//
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        View view = getSupportActionBar().getCustomView();
        // Create action bar - END //

        // Change buttons fonts - START //
        Utils.changeButtonFont(Menu.this, btnAbout, FONTS_NAME_MENU_BUTTONS);
        Utils.changeButtonFont(Menu.this, btnWeekSpecials, FONTS_NAME_MENU_BUTTONS);
        Utils.changeButtonFont(Menu.this, btnOurProducts, FONTS_NAME_MENU_BUTTONS);
        Utils.changeButtonFont(Menu.this, btnPackages, FONTS_NAME_MENU_BUTTONS);
        Utils.changeButtonFont(Menu.this, btnPortfolio, FONTS_NAME_MENU_BUTTONS);
        Utils.changeButtonFont(Menu.this, btnFriendsRecommend, FONTS_NAME_MENU_BUTTONS);
        Utils.changeButtonFont(Menu.this, btnCallUs, FONTS_NAME_MENU_BUTTONS);
        // Change buttons fonts - END //
    }

    // Buttons Listeners -- START //
    private View.OnClickListener btnAboutListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Create custom dialog bar //
            CustomDialogClass cdc = new CustomDialogClass(Menu.this);
            cdc.show();
            Window window = cdc.getWindow();
            window.setLayout((int) (SCREEN_WIDTH - (SCREEN_WIDTH * 0.2)), (SCREEN_HEIGHT * 2) / 3);

            dialogTextView = (TextView) window.findViewById(R.id.textViewAboutUsDialog);

            // Start Async Task that read the about us data from the server.
            ReadAboutUsTask readAboutUsTask = new ReadAboutUsTask();
            readAboutUsTask.execute(BASE_URL + ABOUT_US_JSON);
        }
    };

    private View.OnClickListener btnWeekSpecialsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent i = new Intent(Menu.this, WeekSpecials.class);
            startActivity(i);
        }
    };

    private View.OnClickListener btnCallUsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + PHONE_NUMBER));
            startActivity(callIntent);
        }
    };
    private View.OnClickListener btnPackagesListener;
    private View.OnClickListener btnOurProductsListener;
    private View.OnClickListener btnFriendsRecommendListener;
    private View.OnClickListener btnPortfolioListener;
    private View.OnClickListener btnImgFacebookListener;
    // Buttons Listeners -- END //

    public class ReadAboutUsTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);

                int data = reader.read();

                while (data != -1) {

                    char current = (char) data;

                    result += current;

                    data = reader.read();
                }
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            JSONObject temp = null;
            try {
                temp = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i("Menu", "ReadAboutUsTask():onPostExecute(): Result = " + result);
            try {
                dialogTextView.setText(JSONParser.getString("about_us_text", temp));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void getScreenResolution() {

        // Get screen resolution.
        Utils.getScreenSize(this);
        SCREEN_HEIGHT = Utils.getSCREEN_HEIGHT();
        SCREEN_WIDTH = Utils.getSCREEN_WIDTH();

        Log.i("Menu", "getScreenResolution(): Done");
    }

    private void findViewByID() {

        // findViewById -- START
        vLinearLayoutMain = findViewById(R.id.linearLayoutMain);
        ivSplashImage = (ImageView) findViewById(R.id.imageViewSplashImage);

        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(btnAboutListener);

        btnWeekSpecials = (Button) findViewById(R.id.btnWeekSpecials);
        btnWeekSpecials.setOnClickListener(btnWeekSpecialsListener);

        btnPackages = (Button) findViewById(R.id.btnPackages);
        btnPackages.setOnClickListener(btnPackagesListener);

        btnOurProducts = (Button) findViewById(R.id.btnOurProducts);
        btnOurProducts.setOnClickListener(btnOurProductsListener);

        btnFriendsRecommend = (Button) findViewById(R.id.btnFriendsRecommend);
        btnFriendsRecommend.setOnClickListener(btnFriendsRecommendListener);

        btnPortfolio = (Button) findViewById(R.id.btnPortfolio);
        btnPortfolio.setOnClickListener(btnPortfolioListener);

        btnCallUs = (Button) findViewById(R.id.btnCallUs);
        btnCallUs.setOnClickListener(btnCallUsListener);

        btnImgFacebook = (ImageButton) findViewById(R.id.btnImgFacebook);
        btnImgFacebook.setOnClickListener(btnImgFacebookListener);
        // findViewById -- END

        Log.i("Menu", "findViewByID(): Done");

    }
}