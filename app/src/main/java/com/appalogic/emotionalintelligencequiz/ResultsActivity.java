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
    private TextView self_awareness_score;
    private TextView managing_emotions_score;
    private TextView motivating_oneself_score;
    private TextView empathy_score;
    private TextView social_skill_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        shared_preferences = this.getSharedPreferences("com.appalogic.emotionalintelligencequiz", Context.MODE_PRIVATE);

        overall_score = findViewById(R.id.overall_score);
        self_awareness_score = findViewById(R.id.self_awareness_score);
        managing_emotions_score = findViewById(R.id.managing_emotions_score);
        motivating_oneself_score = findViewById(R.id.motivating_oneself_score);
        empathy_score = findViewById(R.id.empathy_score);
        social_skill_score = findViewById(R.id.social_skill_score);

        int i = 0;
        int sum = 0;
        while(i < scores.length){
            int i2 = i;
            while(i2 < MainActivity.statements.length) {
                scores[i] += (shared_preferences.getInt("answer" + i2, 0) * 2);
                i2 += 5;
            }
            sum += scores[i];
            i++;
        }

        overall_score.setText(getString(R.string.score_string, (sum / scores.length)));
        self_awareness_score.setText(getString(R.string.score_string, scores[0]));
        managing_emotions_score.setText(getString(R.string.score_string, scores[1]));
        motivating_oneself_score.setText(getString(R.string.score_string, scores[2]));
        empathy_score.setText(getString(R.string.score_string, scores[3]));
        social_skill_score.setText(getString(R.string.score_string, scores[4]));
    }
}