package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.DayRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.FoodConsumedRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Repository.FoodRepository;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.NutrimentsCalculator;

import java.util.ArrayList;
import java.util.List;

public class GoalActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    String dateStr = "04/05/2010";
    public ArrayList<Food> foodList;

    private FoodConsumedRepository foodConsumedRepository;
    private FoodRepository foodRepository;
    private DayRepository dayRepository;
    private NutrimentsCalculator nutrimentsCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        foodConsumedRepository = new FoodConsumedRepository();
        foodRepository = new FoodRepository();
        dayRepository = new DayRepository();
        nutrimentsCalculator = new NutrimentsCalculator();

        Day currentJournee = dayRepository.findDayByDate(dateStr, getHelper());
        List<FoodConsumed> listConso = foodConsumedRepository.findFoodConsumedByDate(dateStr,getHelper());
        foodList = foodRepository.findFoodById(listConso, getHelper());


        ProgressBar energyGoal = findViewById(R.id.progressBarEnergyGoal);
        ProgressBar proteinGoal = findViewById(R.id.progressBarProteinGoal);
        ProgressBar carbGoal = findViewById(R.id.progressBarCarbGoal);
        ProgressBar fatGoal = findViewById(R.id.progressBarFatGoal);
        ProgressBar fiberGoal = findViewById(R.id.progressBarFiberGoal);

        // Récupérer l'utilisateur par l'intent appelant cette activité
        //User user = getIntent().getIntExtra("name_of_extra", -1);

        // Puis utiliser le dailyReport pour afficher les bons
        //Day dailyReport = user.getDailyReport();
        energyGoal.setProgress(nutrimentsCalculator.getEnergyPercentage(currentJournee));
        proteinGoal.setProgress(nutrimentsCalculator.getProteinPercentage(currentJournee));
        carbGoal.setProgress(nutrimentsCalculator.getCarbPercentage(currentJournee));
        fatGoal.setProgress(nutrimentsCalculator.getFatPercentage(currentJournee));
        fiberGoal.setProgress(nutrimentsCalculator.getFiberPercentage(currentJournee));

        TextView energyConsumedToday = findViewById(R.id.energyConsumedToday);
        TextView proteinConsumedToday = findViewById(R.id.proteinConsumedToday);
        TextView carbConsumedToday =  findViewById(R.id.carbConsumedToday);
        TextView fatConsumedToday = findViewById(R.id.fatConsumedToday);
        TextView fiberConsumedToday = findViewById(R.id.fiberConsumedToday);

        energyConsumedToday.setText(""+currentJournee.getEnergyConsumed());
        proteinConsumedToday.setText(""+(int)currentJournee.getProteinConsumed());
        carbConsumedToday.setText(""+(int)currentJournee.getCarbohydratesConsumed());
        fatConsumedToday.setText(""+(int)currentJournee.getFatConsumed());
        fiberConsumedToday.setText(""+(int)currentJournee.getFiberConsumed());
    }
}
