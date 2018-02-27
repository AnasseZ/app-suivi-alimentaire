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
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.DayRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.FoodConsumedRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.FoodRepository;
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

    private FoodConsumedRepository foodConsumedRepository;
    private FoodRepository foodRepository;
    private DayRepository dayRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        listView = (ListView) findViewById(R.id.foodList);

        foodConsumedRepository = new FoodConsumedRepository();
        foodRepository = new FoodRepository();
        dayRepository = new DayRepository();

        Day currentJournee = dayRepository.findDayByDate(dateStr, getHelper());

        List<FoodConsumed> listConso = foodConsumedRepository.findFoodConsumedByDate(dateStr,getHelper());
        foodList = foodRepository.findFoodById(listConso, getHelper());


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
