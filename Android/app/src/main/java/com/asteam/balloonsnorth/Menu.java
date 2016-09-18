package com.asteam.balloonsnorth;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import Util.Utils;

public class Menu extends AppCompatActivity {

    public static int SCREEN_WIDTH = 0;
    public static int SCREEN_HEIGHT = 0;
    public static final int SPLASH_DISPLAY_LENGTH = 1500;
    public static final String FONTS_NAME_MENU_BUTTONS = "fonts/ankaclm-bold-webfont.ttf";

    private Button btnAbout;
    private Button btnWeekSpecials;
    private Button btnPackages;
    private Button btnOurProducts;
    private Button btnFriendsRecommend;
    private Button btnPortfolio;
    private Button btnCallUs;
    private ImageButton btnImgFacebook;

    private ImageView ivSplashImage;
    private View vLinearLayoutMain;

    private PopupWindow popUp;
    private LinearLayout layout;
    private TextView tv;
    private LayoutParams params;
    private LinearLayout mainLayout;
    private Button but;
    boolean click = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        initialize();
    }

    private void initialize() {

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

        // Get screen resolution.
        Utils.getScreenSize(this);

        // Show splash screen
        Utils.showSplashScreen(true, SPLASH_DISPLAY_LENGTH, vLinearLayoutMain, ivSplashImage);

        // Create action bar - START//
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        View view = getSupportActionBar().getCustomView();
        // Create action bar - END //

        // Change buttons fonts - START //
        Typeface tf = Typeface.createFromAsset(getAssets(), FONTS_NAME_MENU_BUTTONS);
        btnAbout.setTypeface(tf);
        btnWeekSpecials.setTypeface(tf);
        btnOurProducts.setTypeface(tf);
        btnPackages.setTypeface(tf);
        btnPortfolio.setTypeface(tf);
        btnFriendsRecommend.setTypeface(tf);
        btnCallUs.setTypeface(tf);
        // Change buttons fonts - END //
    }

    // Buttons Listeners -- START
    private View.OnClickListener btnAboutListener;
    private View.OnClickListener btnWeekSpecialsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent i = new Intent(Menu.this, WeekSpecials.class);
            startActivity(i);
        }
    };
    private View.OnClickListener btnPackagesListener;
    private View.OnClickListener btnOurProductsListener;
    private View.OnClickListener btnFriendsRecommendListener;
    private View.OnClickListener btnPortfolioListener;
    private View.OnClickListener btnCallUsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:0528643117"));
            startActivity(callIntent);
        }
    };
    private View.OnClickListener btnImgFacebookListener;
    // Buttons Listeners -- END
}