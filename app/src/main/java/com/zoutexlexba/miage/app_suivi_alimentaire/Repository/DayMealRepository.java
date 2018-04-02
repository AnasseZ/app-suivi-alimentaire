package com.zoutexlexba.miage.app_suivi_alimentaire.Repository;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.DayMealConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by JeanJack on 27/03/2018.
 */

public class DayMealRepository {
    public List<DayMealConsumed> getDayMealByDate(DatabaseHelper databaseHelper, String dateStr) {
        List<DayMealConsumed> listConso = null;
        RuntimeExceptionDao<DayMealConsumed, Integer> dayMealDao = databaseHelper.getDayMealConsumedRuntimeDao();
        QueryBuilder<DayMealConsumed, Integer> queryBuilder = dayMealDao.queryBuilder();

        try {
            queryBuilder.where().eq(DayMealConsumed.ID_DAY,dateStr);
            PreparedQuery<DayMealConsumed> preparedQuery = queryBuilder.prepare();
            listConso= dayMealDao.query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listConso;
    }

}
