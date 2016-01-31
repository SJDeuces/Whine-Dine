package com.example.sjdeuces.hackucsc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class ReviewActivity extends AppCompatActivity {

    private RatingBar rBar;
    private TextView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        addListenerOnRatingBar();
    }
    // shows the value from the rating bar
    public void addListenerOnRatingBar(){
        rBar = (RatingBar) findViewById(R.id.ratingBar);
        rView = (TextView) findViewById(R.id.numberView);
        rBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar rBar, float rating, boolean fromUser) {
                rView.setText(String.valueOf(rating));
            }
        });
    }
}
