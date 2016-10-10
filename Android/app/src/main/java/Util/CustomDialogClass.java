package Util;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.asteam.balloonsnorth.R;

/**
 * Created by Amit on 9/24/2016.
 */
public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    public Button btnBack;

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.about_us_dialog);

        btnBack = (Button) findViewById(R.id.buttonBackAboutUsDialog);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonBackAboutUsDialog:
                activity.finish();
                break;
            default:
                break;
        }
        dismiss();
    }
}