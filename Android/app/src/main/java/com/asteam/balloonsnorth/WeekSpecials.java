package com.asteam.balloonsnorth;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import Data.Sale;
import Util.JSONParser;
import Util.RVAdapter;
import Util.Utils;

public class WeekSpecials extends AppCompatActivity {

    public static final int AMOUNT_OF_SALES = 4;
    private List<Sale> Sales = new ArrayList<>();
    private RecyclerView rv;
    public ArrayList salesHeadlines = new ArrayList();
    public ArrayList salesDetails = new ArrayList();

    private ImageView ivSplashImage;
    private View vRelativeLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_specials);

        vRelativeLayoutMain = findViewById(R.id.relativeLayoutMain);
        ivSplashImage = (ImageView) findViewById(R.id.imageViewSplashImage);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        ReadSalesTask readSalesTask = new ReadSalesTask();
        readSalesTask.execute(Menu.BASE_URL + Menu.SALES_JSON_URL);

        Utils.showSplashScreen(true, Menu.SPLASH_DISPLAY_LENGTH, vRelativeLayoutMain, ivSplashImage);

        initializeAdapter();

        initialize();
    }

    private void initialize() {

        // Create action bar - START//
        Log.i("WeekSpecials", "initialize(): START");
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        View view = getSupportActionBar().getCustomView();
        // Create action bar - END //

    }

    public class ReadSalesTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            Log.i("WeekSpecials", "ReadSalesTask():doInBackground(): START");
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

            Log.i("WeekSpecials", "ReadSalesTask():onPostExecute(): START");

            JSONObject allResults = null;
            try {
                allResults = new JSONObject(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i("WeekSpecials", "ReadSalesTask():onPostExecute(): allResults = " + allResults);
            try {
                for (int i = 1; i < AMOUNT_OF_SALES + 1; i++) {
                    JSONObject saleOBject = new JSONObject();
                    saleOBject = JSONParser.getObject("sale" + i, allResults);

                    salesHeadlines.add(JSONParser.getString("sale" + i + "_headline", saleOBject));
                    salesDetails.add(JSONParser.getString("sale" + i + "_details", saleOBject));

                    // Add the data (Headline & Details) to the CardView //
                    Sales.add(new Sale((String) salesHeadlines.get(i - 1), (String) salesDetails.get(i - 1), R.mipmap.splash_img));

                    Log.i("WeekSpecials", "ReadSalesTask():onPostExecute(): salesHeadlines.get(i - 1) = " + salesHeadlines.get(i - 1));
                    Log.i("WeekSpecials", "ReadSalesTask():onPostExecute(): salesDetails.get(i - 1) = " + salesDetails.get(i - 1));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initializeAdapter() {
        Log.i("WeekSpecials", "initializeAdapter(): START");
        RVAdapter adapter = new RVAdapter(Sales);
        rv.setAdapter(adapter);
    }
}