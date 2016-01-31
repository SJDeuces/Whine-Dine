package com.example.sjdeuces.hackucsc;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CollegeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);
        //TieredDiningHallList();

    }

    private void request(){
        String parsedString = "";

        try {

            URL url = new URL("whine-dine.herokuapp.com/api/menu?&dateoffset=0");
            URLConnection conn = url.openConnection();

            HttpURLConnection httpConn = (HttpURLConnection) conn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();

            InputStream is = httpConn.getInputStream();
            parsedString = convertinputStreamToString(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void TieredDiningHallList(){
        //get public eatingtime to know how to tier
        CollegeInfo cInfo = new CollegeInfo();
        //blah =

        /*request ethan's server for the DH rating at
        that eating time.
        */


        // 1 highest tier, 5 lowest


        /*
        //Stack Overflow code for adding buttons dynamically


         */



        /*call ethan's data via gson to know the avg tier
        for that eating time*/

        /*set the buttons from highest tier DH to lowest
        with the avg rating.
         */
    }

    public void goToMenu(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("menuView", v.getId());
        startActivity(intent);
    }


}
