package com.example.sjdeuces.hackucsc;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.example.sjdeuces.hackucsc.Meal;
import com.example.sjdeuces.hackucsc.Food;
import com.example.sjdeuces.hackucsc.DiningHall;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

public class LauncherScreen extends AppCompatActivity {

    private static final String url="http://whine-dine.herokuapp.com/api/menu?&dateoffset=0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_screen);
        new JSONParse().execute();
    }


    protected void onPostExecute(String parsed) {

        setContentView(R.layout.activity_launcher_screen);
    }

    public void goToCollege(View v) {
        Intent intent = new Intent(this, CollegeActivity.class);
        intent.putExtra("collegeView", v.getId());
        startActivity(intent);
    }

    public void goToSettings(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private class JSONParse extends AsyncTask<String, String, String> {
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(LauncherScreen.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... args) {

            // Getting JSON from URL

            HttpURLConnection c = null;
            try {
                URL u = new URL(url);
                c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("GET");
                c.setUseCaches(false);
                c.setAllowUserInteraction(false);
                c.setConnectTimeout(1000000);
                c.setReadTimeout(1000000);
                c.connect();
                int status = c.getResponseCode();

                switch (status) {
                    case 200:
                    case 201:
                        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        br.close();
                        Log.d("TEST", sb.toString());
                        return sb.toString();
                }

            } catch (MalformedURLException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (c != null) {
                    try {
                        c.disconnect();
                    } catch (Exception ex) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return "HOW COULD THIS HAPPEN?";
        }
        @Override
        protected void onPostExecute(String json) {
            pDialog.dismiss();
            super.onPostExecute(json);
            JsonParser parseit =  new JsonParser();
            JsonObject request = parseit.parse(json).getAsJsonObject();
        }
    }

}
