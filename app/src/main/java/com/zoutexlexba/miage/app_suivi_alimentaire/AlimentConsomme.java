package com.zoutexlexba.miage.app_suivi_alimentaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

public class AlimentConsomme extends OrmLiteBaseActivity<DatabaseHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aliment_consomme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


    }

    public void AjoutAliment(View view){
        Intent intent = new Intent(AlimentConsomme.this, MainActivity.class);
        startActivity(intent);
    }

}
