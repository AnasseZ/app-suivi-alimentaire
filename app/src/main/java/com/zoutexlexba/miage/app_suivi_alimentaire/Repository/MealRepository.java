package com.zoutexlexba.miage.app_suivi_alimentaire.Repository;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.DayMealConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeanJack on 23/03/2018.
 */

public class MealRepository {

    public List<Meal> getAllMeal(DatabaseHelper databaseHelper) {
        List<Meal> listConso = null;
        RuntimeExceptionDao<Meal, Integer> mealDao = databaseHelper.getRepasRuntimeDao();

        listConso= mealDao.queryForAll();

        return  listConso;
    }

    public ArrayList<Meal> getMealByDate(DatabaseHelper databaseHelper, String dateStr) {
        DayMealRepository repository = new DayMealRepository();
        ArrayList<Meal> listConso = new ArrayList<Meal>();

        RuntimeExceptionDao<Meal, Integer> mealDao = databaseHelper.getRepasRuntimeDao();
        List<DayMealConsumed> listDayMealConso = repository.getDayMealByDate(databaseHelper, dateStr);

        for(DayMealConsumed d : listDayMealConso){
            Meal meal = mealDao.queryForId(d.getIdMeal());
            listConso.add(meal);
        }

        return listConso;
    }
}
