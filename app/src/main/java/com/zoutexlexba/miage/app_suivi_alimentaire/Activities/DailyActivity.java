package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.MainActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.FoodAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
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

        RuntimeExceptionDao<Day, String> journeeDao = getHelper().getJourneeRuntimeDao();
        Day currentJournee =  journeeDao.queryForId(dateStr);
        if(currentJournee == null) {
            currentJournee = new Day(dateStr);
            journeeDao.create(currentJournee);
        }



        List<FoodConsumed> listConso = null;
        RuntimeExceptionDao<FoodConsumed, Integer> consommeDao = getHelper().getConsommeDataDao();
        QueryBuilder<FoodConsumed, Integer> queryBuilder = consommeDao.queryBuilder();

        try {
            queryBuilder.where().eq(FoodConsumed.ID_TYPE,dateStr);
            PreparedQuery<FoodConsumed> preparedQuery = queryBuilder.prepare();
            listConso= consommeDao.query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RuntimeExceptionDao<Food, Integer> foodDao = getHelper().getFoodRuntimeDao();
        foodList = new ArrayList<Food>();
        for(int i = 0; i < listConso.size(); i++){
            Food toAdd = foodDao.queryForId(listConso.get(i).getIdFood());
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
