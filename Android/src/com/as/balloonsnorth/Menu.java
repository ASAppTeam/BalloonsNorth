package com.as.balloonsnorth;

import android.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu extends Activity {

	private final int SPLASH_DISPLAY_LENGTH = 2000;

	private View viewLinearLayoutMain;
	private View viewScrollViewMain;
	private View viewRelativeLayoutMain;
	private ImageView viewSplashImage;

	private Button btnAbout;
	private Button btnWeekSpecials;
	private Button btnPackages;
	private Button btnOurProducts;
	private Button btnFriendsRecommend;
	private Button btnPortfolio;
	private Button btnCallUs;
	private ImageButton btnImgFacebook;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		// Find Views -- START
		viewLinearLayoutMain = findViewById(R.id.viewLinearLayoutMain);
		viewScrollViewMain = findViewById(R.id.viewScrollViewMain);
		viewRelativeLayoutMain = findViewById(R.id.viewRelativeLayoutMain);
		// Find Views -- End

		viewSplashImage = (ImageView) findViewById(R.id.viewSplashImage);

		// Find Buttons -- START
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
		// Find Buttons -- END

		firstInitialization();
	}

	// Buttons Listeners -- START

	private OnClickListener btnAboutListener;
	private OnClickListener btnWeekSpecialsListener;
	private OnClickListener btnPackagesListener;
	private OnClickListener btnOurProductsListener;
	private OnClickListener btnFriendsRecommendListener;
	private OnClickListener btnPortfolioListener;
	private OnClickListener btnImgFacebookListener;
	private OnClickListener btnCallUsListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent callIntent = new Intent(Intent.ACTION_DIAL);
			callIntent.setData(Uri.parse("tel:0528643117"));
			startActivity(callIntent);
		}
	};

	// Buttons Listeners -- END

	// Private Functions -- START
	private void firstInitialization() {
		// TODO Auto-generated method stub

		showSplashScreen(true, SPLASH_DISPLAY_LENGTH);
	}

	private void showSplashScreen(final Boolean show, long showDuration) {

		viewScrollViewMain.setVisibility(show ? View.GONE : View.VISIBLE);
		viewSplashImage.setVisibility(show ? View.VISIBLE : View.GONE);

		new Handler().postDelayed(new Runnable() {
			public void run() {
				viewSplashImage.setVisibility(show ? View.GONE : View.VISIBLE);
				viewScrollViewMain.setVisibility(show ? View.VISIBLE
						: View.GONE);
			}
		}, showDuration);
	}
	// Private Functions -- END
}