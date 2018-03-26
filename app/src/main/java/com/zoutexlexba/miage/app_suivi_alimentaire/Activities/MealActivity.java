package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
import com.zoutexlexba.miage.app_suivi_alimentaire.MainActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.MealRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.ListViewDailyAdapters;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.ListViewMealAdapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.FIRST_COLUMN_MEAL;
import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.SECOND_COLUMN_MEAL;
import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.THIRD_COLUMN_MEAL;

public class MealActivity extends OrmLiteBaseActivity<DatabaseHelper>  {

    private ArrayList<HashMap<String, String>> mealList;
    List<Meal> listMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        ListView listView = (ListView) findViewById(R.id.mealList);
        mealList =new ArrayList<HashMap<String,String>>();

        MealRepository mealRepository = new MealRepository();

        listMeal = mealRepository.getAllMeal(getHelper());

        HashMap<String,String> entete=new HashMap<String, String>();
        entete.put(FIRST_COLUMN_MEAL, FIRST_COLUMN_MEAL);
        entete.put(SECOND_COLUMN_MEAL, SECOND_COLUMN_MEAL);
        //entete.put(THIRD_COLUMN_MEAL, THIRD_COLUMN_MEAL);
        mealList.add(entete);

        for (int i = 0; i < listMeal.size(); i++){
            HashMap<String,String> temp=new HashMap<String, String>();
            temp.put(FIRST_COLUMN_MEAL, listMeal.get(i).getNom());
            temp.put(SECOND_COLUMN_MEAL, "5000");
            mealList.add(temp);
        }

        ListViewMealAdapters adapter=new ListViewMealAdapters(this, mealList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this.getOnItemClickListener());
    }

    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                // Récupération du bon aliment
                final Meal mealClicked = listMeal.get(position-1);

                Intent intent = new Intent(MealActivity.this, AddMealActivity.class);
                intent.putExtra("idRepas", mealClicked.getId());

                startActivity(intent);
            }
        };
    }

    public void AjoutRepas(View view){
        Intent intent = new Intent(MealActivity.this, AddMealActivity.class);
        intent.putExtra("idRepas", -1);
        startActivity(intent);
    }
}
