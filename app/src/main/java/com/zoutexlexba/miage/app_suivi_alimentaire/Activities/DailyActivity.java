package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
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
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.ListViewDailyAdapters;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.FIRST_COLUMN;
import static com.zoutexlexba.miage.app_suivi_alimentaire.Services.Constants.SECOND_COLUMN;

public class DailyActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    //date fictive pour test
    String dateStr = "04/05/2010";

    private ArrayList<HashMap<String, String>> foodList;
    private ArrayList<Food> food;

    private FoodAdapter foodAdapter;

    private FoodConsumedRepository foodConsumedRepository;
    private FoodRepository foodRepository;
    private DayRepository dayRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        ListView listView = (ListView) findViewById(R.id.foodListDaily);
        foodList =new ArrayList<HashMap<String,String>>();

        foodConsumedRepository = new FoodConsumedRepository();
        foodRepository = new FoodRepository();
        dayRepository = new DayRepository();

        Day currentJournee = dayRepository.findDayByDate(dateStr, getHelper());
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
        Intent intent = new Intent(DailyActivity.this, MainActivity.class);

        //Gestion de la date
        intent.putExtra("Date", dateStr);

        startActivity(intent);
    }
}
