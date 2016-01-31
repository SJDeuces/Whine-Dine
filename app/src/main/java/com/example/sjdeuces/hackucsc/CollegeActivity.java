package com.example.sjdeuces.hackucsc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import org.json.JSONObject;

public class CollegeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);
        //TieredDiningHallList();

    }

    private void TieredDiningHallList(){
        //get public eatingtime to know how to tier
        CollegeInfo cInfo = new CollegeInfo();
        //mealTime();
        String[] arr1 = {"CowellStevenson", "CrownMerrill", "eightOakes",
                "NineTen", "PorterKresge"};
        int [] arr2 = {}
        int[] arr3 = doInsertionSort(arr2);
        for(int i:arr2){
            //button logic
        }
        /*request ethan's server for the DH rating at
        that eating time.
        */


        // 1 highest tier, 5 lowest


        /*
        //Stack Overflow code for adding buttons dynamically


         */


        /*set the buttons from highest tier DH to lowest
        with the avg rating.
         */
    }

    public void mealTime(){
        String id = getIntent().getStringExtra("CollegeActivity");
        //Gets mealtime averages
        if(id == "Button00"){
            //breakfast
            String[] arr1 = {"CowellStevenson", "CrownMerrill", "eightOakes",
                    "NineTen", "PorterKresge"};
            int [] arr2 = {};
            int[] arr3 = doInsertionSort(arr2);
            for(int i:arr2){
                //button logic
            }
        } else if( id == "Button01"){
            //Lunch
            String[] arr1 = {"CowellStevenson", "CrownMerrill", "eightOakes",
                    "NineTen", "PorterKresge"};

            //int[] arr3 = doInsertionSort(arr2);
            //for(int i:arr2){
                //button logic
            }
         else if( id == "Button03"){
            //Dinner
            String[] arr1 = {"CowellStevenson", "CrownMerrill", "eightOakes",
                    "NineTen", "PorterKresge"};
            int [] arr2 = {};
            int[] arr3 = doInsertionSort(arr2);
            for(int i:arr2){
                //button logic
            }
        } else {

        }
    }


    public void goToMenu(View v) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("menuView", v.getId());
        startActivity(intent);
    }

    public static int[] doInsertionSort(int[] input){

        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }


}
