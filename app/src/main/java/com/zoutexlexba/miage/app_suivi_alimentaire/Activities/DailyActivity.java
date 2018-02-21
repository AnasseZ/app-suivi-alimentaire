package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.view.View;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.AlimentConsomme;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Journee;
import com.zoutexlexba.miage.app_suivi_alimentaire.MainActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.FoodAdapter;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DailyActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    //date fictive pour test
    String dateStr = "04/05/2010";

    public ArrayList<Food> foodList;
    private FoodAdapter foodAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        listView = (ListView) findViewById(R.id.foodList);

        /*RuntimeExceptionDao<Journee, String> journeeDao = getHelper().getJourneeRuntimeDao();
        Journee currentJournee = null;

        try{
            currentJournee = journeeDao.queryForId(dateStr);
        }catch (Error e){
            currentJournee = new Journee(dateStr);
            journeeDao.create(currentJournee);
        }*/



        List<AlimentConsomme> listConso = null;
        RuntimeExceptionDao<AlimentConsomme, Integer> consommeDao = getHelper().getConsommeDataDao();
        QueryBuilder<AlimentConsomme, Integer> queryBuilder = consommeDao.queryBuilder();

        try {
            queryBuilder.where().eq(AlimentConsomme.ID_TYPE,dateStr);
            PreparedQuery<AlimentConsomme> preparedQuery = queryBuilder.prepare();
            listConso= consommeDao.query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RuntimeExceptionDao<Food, Integer> foodDao = getHelper().getFoodRuntimeDao();
        foodList = new ArrayList<Food>();
        for(int i = 0; i < listConso.size(); i++){
            Food toAdd = foodDao.queryForId(listConso.get(i).getId_food());
            foodList.add(toAdd);
        }

        foodAdapter = new FoodAdapter(DailyActivity.this, foodList);
        listView.setAdapter(foodAdapter);
    }

    public void AjoutAliment(View view){
        Intent intent = new Intent(DailyActivity.this, MainActivity.class);

        //Gestion de la date
        intent.putExtra("Date", dateStr);

        startActivity(intent);
    }
}
