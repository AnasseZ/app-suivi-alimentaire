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

        ProgressBar energyGoal = (ProgressBar) findViewById(R.id.progressBarEnergyGoal);
        ProgressBar proteinGoal = (ProgressBar) findViewById(R.id.progressBarProteinGoal);
        ProgressBar carbGoal = (ProgressBar) findViewById(R.id.progressBarCarbGoal);
        ProgressBar fatGoal = (ProgressBar) findViewById(R.id.progressBarFatGoal);
        ProgressBar fiberGoal = (ProgressBar) findViewById(R.id.progressBarFiberGoal);

        // Récupérer l'utilisateur par l'intent appelant cette activité
        //User user = getIntent().getIntExtra("name_of_extra", -1);

        // Puis utiliser le dailyReport pour afficher les bons
        //DailyReport dailyReport = user.getDailyReport();
        energyGoal.setProgress(75);
        proteinGoal.setProgress(90);
        carbGoal.setProgress(48);
        fatGoal.setProgress(70);
        fiberGoal.setProgress(15);
    }
}
