package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
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

    private Meal currentMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        final EditText input = (EditText) findViewById(R.id.input_nom);

        Intent intent = getIntent();
        Integer idMeal = intent.getIntExtra("idRepas",-1);

        final RuntimeExceptionDao<Meal, Integer> mealDao = getHelper().getRepasRuntimeDao();
        currentMeal = mealDao.queryForId(idMeal);
        if(currentMeal == null){
            currentMeal = new Meal();
            mealDao.create(currentMeal);
        }

        input.setText(currentMeal.getNom());

        input.addTextChangedListener(new TextWatcher() {
            boolean _ignore = false;
            @Override
            public void afterTextChanged(Editable s) {
                if (_ignore)
                    return;

                _ignore = true; // prevent infinite loop
                // Change your text here.
                currentMeal.setNom(input.getText().toString());
                mealDao.update(currentMeal);
                _ignore = false; // release, so the TextWatcher start to listen again.

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });


        ListView listView = (ListView) findViewById(R.id.foodListMeal);
        foodList =new ArrayList<HashMap<String,String>>();

        foodConsumedRepository = new FoodConsumedRepository();
        foodRepository = new FoodRepository();

        List<FoodConsumed> listConso = foodConsumedRepository.findFoodConsumedByIdMeal(currentMeal.getId(), getHelper());
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

        intent.putExtra("idRepas", currentMeal.getId());

        startActivity(intent);
    }
}
