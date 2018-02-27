package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zoutexlexba.miage.app_suivi_alimentaire.CreaAccount;
import com.zoutexlexba.miage.app_suivi_alimentaire.MainActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Button btdailyactivity = (Button) findViewById(R.id.btdailyactivity);
        Button btgoal = (Button) findViewById(R.id.btngoalNavigation);
        Button btaddmeal = (Button) findViewById(R.id.btaddmeal);
        Button btpersonnalinfo = (Button) findViewById(R.id.btpersonalinfo);
        Button btInscription = (Button) findViewById(R.id.btinscription);

        btdailyactivity.setOnClickListener(btdailyactivityListener);
        btgoal.setOnClickListener(btgoalListener);
        btaddmeal.setOnClickListener(btaddmealListener);
        btpersonnalinfo.setOnClickListener(btpersonnalinfoListener);
        btInscription.setOnClickListener(btInscriptionListener);
    }

    //Redirection vers la page Activité journalière
    private OnClickListener btdailyactivityListener= new OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.d("debug","Daily activity");
            Intent dailyactivityactivity = new Intent (NavigationActivity.this, DailyActivity.class);
            startActivity(dailyactivityactivity);
        }
    };


    //Redirection vers la page inscription pour l'instant (normalement celui des objectifs)
    private OnClickListener btgoalListener= new OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.d("debug","Mes Objectifs");
            Intent goalActivity = new Intent(NavigationActivity.this, GoalActivity.class);
            startActivity(goalActivity);

        }
    };


    //Redirection vers la page d'ajout de nouveau repas
    private OnClickListener btaddmealListener= new OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.d("debug","Ajouter un repas");
            Intent addmealActivity = new Intent(NavigationActivity.this, MainActivity.class);
            startActivity(addmealActivity);
        }
    };



    //Redirection vers la page d'édition des infos personnelles
    private OnClickListener btpersonnalinfoListener;

    {
        btpersonnalinfoListener = new OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("debug", "Modifier Mes infos perso");
                Intent personnalinfoActivity = new Intent(NavigationActivity.this, PersonnalInfoActivity.class);
                startActivity(personnalinfoActivity);
            }
        };
    }

    //Redirection vers la page Activité journalière
    private OnClickListener btInscriptionListener= new OnClickListener(){

        @Override
        public void onClick(View view) {
            Log.d("debug","Inscription");
            Intent intent = new Intent (NavigationActivity.this, CreaAccount.class);
            startActivity(intent);
        }
    };
}
