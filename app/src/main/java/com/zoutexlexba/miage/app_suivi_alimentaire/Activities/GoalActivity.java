package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.zoutexlexba.miage.app_suivi_alimentaire.R;

public class GoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBarEnergyGoal);

        progressBar.setProgress(75);
    }
}
