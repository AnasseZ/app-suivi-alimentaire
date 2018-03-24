package com.zoutexlexba.miage.app_suivi_alimentaire.Repository;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

import java.sql.SQLException;
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
}
