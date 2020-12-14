package com.appalogic.emotionalintelligencequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] statements = {
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

    int current_statement = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView statement = findViewById(R.id.statement);
        statement.setText(statements[current_statement]);
    }
}