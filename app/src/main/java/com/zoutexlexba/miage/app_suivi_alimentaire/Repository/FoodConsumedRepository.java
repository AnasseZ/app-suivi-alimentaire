package com.zoutexlexba.miage.app_suivi_alimentaire.Repository;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by anassezougarh on 27/02/2018.
 */

public class FoodConsumedRepository {

    public List<FoodConsumed> findFoodConsumedByDate(String dateStr, DatabaseHelper databaseHelper) {
        List<FoodConsumed> listConso = null;
        RuntimeExceptionDao<FoodConsumed, Integer> consommeDao = databaseHelper.getConsommeDataDao();
        QueryBuilder<FoodConsumed, Integer> queryBuilder = consommeDao.queryBuilder();

        try {
            queryBuilder.where().eq(FoodConsumed.ID_DAY,dateStr);
            PreparedQuery<FoodConsumed> preparedQuery = queryBuilder.prepare();
            listConso= consommeDao.query(preparedQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  listConso;
    }
}
