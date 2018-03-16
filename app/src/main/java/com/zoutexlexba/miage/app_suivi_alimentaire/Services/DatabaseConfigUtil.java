package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.User;

import java.io.File;

/**
 * Created by Paulalex on 31/01/2018.
 */

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {
            FoodConsumed.class,
            Food.class,
            Day.class,
            Meal.class,
           // User.class
    };
    public static void main(String[] args) throws Exception {
        writeConfigFile(new File("./app/src/main/res/raw/ormlite_config.txt"), classes);
    }
}
