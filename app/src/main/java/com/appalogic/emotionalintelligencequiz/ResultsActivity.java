package com.appalogic.emotionalintelligencequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private SharedPreferences shared_preferences;
    private int[] scores = {0, 0, 0, 0, 0};

    private TextView overall_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        shared_preferences = this.getSharedPreferences("com.appalogic.emotionalintelligencequiz", Context.MODE_PRIVATE);
        overall_score = findViewById(R.id.overall_score);

        int i = 0;
        int sum = 0;
        while(i < scores.length){
            int i2 = 0;
            while(i2 < MainActivity.statements.length) {
                scores[i] += (shared_preferences.getInt("answer" + i2, 0) * 2);
                i2 += 5;
            }
            sum += scores[i];
            i++;
        }

        overall_score.setText(getString(R.string.score_string, (sum / scores.length)));
    }
}