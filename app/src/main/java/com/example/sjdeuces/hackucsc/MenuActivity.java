package com.example.sjdeuces.hackucsc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        /*
        // Stack Overflow code for adding buttons dynamically
        //Add lines to call ethans server food list and list in order
        for (int i = 1; i <= k ; i++) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.myLinearLayout);
        layout.setOrientation(LinearLayout.VERTICAL);
        Button btn = new Button(this);
        btn.setText("    ");
        layout.addView(btn);
    }

         */
    }


    public void goToReview(View v){
        Intent intent = new Intent(this, ReviewActivity.class);
        intent.putExtra("reviewView", v.getId());
        startActivity(intent);
    }

    private void DynamicMenuLayout(int n){

    }
}
