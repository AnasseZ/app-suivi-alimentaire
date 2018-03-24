package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.MainActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.DayRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.FoodConsumedRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.FoodRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.*;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.FIRST_COLUMN;
import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.SECOND_COLUMN;

/**
 * Created by JeanJack on 23/03/2018.
 */

public class AddMealActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    private ArrayList<HashMap<String, String>> foodList;
    private ArrayList<Food> food;

    private FoodAdapter foodAdapter;

    private FoodConsumedRepository foodConsumedRepository;
    private FoodRepository foodRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        Intent intent = getIntent();
        Integer idMeal = intent.getIntExtra("idRepas",-1);

        if(idMeal == -1){

        }

        ListView listView = (ListView) findViewById(R.id.foodListDaily);
        foodList =new ArrayList<HashMap<String,String>>();

        foodConsumedRepository = new FoodConsumedRepository();
        foodRepository = new FoodRepository();

        List<FoodConsumed> listConso = foodConsumedRepository.findFoodConsumedByDate(dateStr,getHelper());
        food = foodRepository.findFoodById(listConso, getHelper());

        HashMap<String,String> entete=new HashMap<String, String>();
        entete.put(FIRST_COLUMN, FIRST_COLUMN);
        entete.put(SECOND_COLUMN, SECOND_COLUMN);
        foodList.add(entete);

        for (int i = 0; i < food.size(); i++){
            HashMap<String,String> temp=new HashMap<String, String>();
            temp.put(FIRST_COLUMN, food.get(i).getName());
            temp.put(SECOND_COLUMN, "5000");
            foodList.add(temp);
        }

        ListViewDailyAdapters adapter=new ListViewDailyAdapters(this, foodList);
        listView.setAdapter(adapter);
    }


    public void AjoutAliment(View view){
        Intent intent = new Intent(AddMealActivity.this, MainActivity.class);

        intent.putExtra("idRepas", 0);

        startActivity(intent);
    }
}
