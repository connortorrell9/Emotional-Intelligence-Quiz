package com.appalogic.emotionalintelligencequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String[] statements = {
            "I realize immediately when I lose my temper",
            "I can 'reframe' bad situations quickly",
            "I am able to always motive myself to do difficult tasks",
            "I am always able to see things from the other person's viewpoint",
            "I am an excellent listener",
            "I know when I am happy",
            "I do not wear my 'heart on my sleeve'",
            "I am usually able to prioritize important activities at work and get on with them",
            "I am excellent at empathising with someone else's problem",
            "I never interrupt other people's conversations",
            "I usually recognize when I am stressed",
            "Others can rarely tell what kind of mood I am in",
            "I always meet deadlines",
            "I can tell if someone is not happy with me",
            "I am good at adapting and mixing with a variety of people",
            "When I am being 'emotional' I am aware of this",
            "I rarely 'fly off the handle' at other people",
            "I never waste time",
            "I can tell if a team of people are not getting along with each other",
            "People are the most interesting thing in life for me",
            "When I feel anxious I usually can account for the reason(s)",
            "Difficult people do not annoy me",
            "I do not prevaricate",
            "I can usually understand why people are being difficult towards me",
            "I love to meet new people and get to know what makes them 'tick'",
            "I always know when I'm being unreasonable",
            "I can consciously alter my frame of mind or mood",
            "I believe you should do the difficult things first",
            "Other individuals are not 'difficult' just 'different'",
            "I need a variety of work colleagues to make my job interesting",
            "Awareness of my own emotions is very important to me at all times",
            "I do not let stressful situations or people affect me once I have left work",
            "Delayed gratification is a virtue that I hold to",
            "I can understand if I am being unreasonable",
            "I like to ask questions to find out what it is important to people",
            "I can tell if someone has upset or annoyed me",
            "I rarely worry about work or life in general",
            "I believe in 'Action this Day'",
            "I can understand why my actions sometimes offend others",
            "I see working with difficult people as simply a challenge to win them over",
            "I can let anger 'go' quickly so that it no longer affects me",
            "I can suppress my emotions when I need to",
            "I can always motivate myself even when I feel low",
            "I can sometimes see things from others' point of view",
            "I am good at reconciling differences with other people",
            "I know what makes me happy",
            "Others often do not know how I am feeling about things",
            "Motivations has been the key to my success",
            "Reasons for disagreements are always clear to me",
            "I generally build solid relationships with those I work with",
    };

    private SharedPreferences shared_preferences;
    private int current_statement = 0;
    private View selected_button;

    private TextView statement;
    private Button always_applies;
    private Button usually_applies;
    private Button somewhat_applies;
    private Button rarely_applies;
    private Button never_applies;
    private Button back;
    private Button next;

    private void set_statement(){
        statement.setText(statements[current_statement]);
    }

    private void reset_buttons(){
        always_applies.setEnabled(true);
        usually_applies.setEnabled(true);
        somewhat_applies.setEnabled(true);
        rarely_applies.setEnabled(true);
        never_applies.setEnabled(true);
        next.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared_preferences = this.getSharedPreferences("com.appalogic.emotionalintelligencequiz", Context.MODE_PRIVATE);

        statement = findViewById(R.id.statement);
        always_applies = findViewById(R.id.always_applies);
        usually_applies = findViewById(R.id.usually_applies);
        somewhat_applies = findViewById(R.id.somewhat_applies);
        rarely_applies = findViewById(R.id.rarely_applies);
        never_applies = findViewById(R.id.never_applies);
        back = findViewById(R.id.back);
        next = findViewById(R.id.next);

        always_applies.setOnClickListener(this);
        usually_applies.setOnClickListener(this);
        somewhat_applies.setOnClickListener(this);
        rarely_applies.setOnClickListener(this);
        never_applies.setOnClickListener(this);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

        set_statement();
    }

    @Override
    public void onClick(View view) {
        if (view == next){
            shared_preferences.edit().putInt("answer" + current_statement, Integer.parseInt(selected_button.getTag().toString())).apply();
            reset_buttons();
            current_statement++;
            set_statement();
            back.setEnabled(true);
        } else if (view == back){
            reset_buttons();
            current_statement--;
            set_statement();
            if(current_statement == 0){
                back.setEnabled(false);
            }
        } else{
            reset_buttons();
            view.setEnabled(false);
            next.setEnabled(true);
            selected_button = view;
        }
    }
}