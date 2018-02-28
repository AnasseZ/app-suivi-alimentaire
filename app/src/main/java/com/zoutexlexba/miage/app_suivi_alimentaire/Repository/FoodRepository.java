package com.zoutexlexba.miage.app_suivi_alimentaire.Repository;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.zoutexlexba.miage.app_suivi_alimentaire.Activities.DailyActivity;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anassezougarh on 27/02/2018.
 */

public class FoodRepository {

    /**
     * Récupère tout les Food via leurs Id parmis les FoodConsumed
     * @param listConso
     * @param databaseHelper
     * @return
     */
   public ArrayList<Food> findFoodById(List<FoodConsumed> listConso, DatabaseHelper databaseHelper) {
       RuntimeExceptionDao<Food, Integer> foodDao = databaseHelper.getFoodRuntimeDao();
       ArrayList foodList = new ArrayList<Food>();

       for(int i = 0; i < listConso.size(); i++){
           Food toAdd = foodDao.queryForId(listConso.get(i).getIdFood());
           foodList.add(findOneFoodById(listConso,foodDao,i));
       }

       return  foodList;
   }

    /**
     * Récupère un seul Food par son id
     * @param listConso
     * @param foodDao
     * @param index
     * @return
     */
   public Food findOneFoodById(
           List<FoodConsumed> listConso,
           RuntimeExceptionDao<Food, Integer> foodDao,
           int index
   ) {
       return foodDao.queryForId(listConso.get(index).getIdFood());
   }

}
