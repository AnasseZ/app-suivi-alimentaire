package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Aliment;

import java.io.File;

/**
 * Created by Paulalex on 31/01/2018.
 */

public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    private static final Class<?>[] classes = new Class[] {
            Aliment.class,
    };
    public static void main(String[] args) throws Exception {
        writeConfigFile(new File("./app/src/main/res/raw/ormlite_config.txt"), classes);
    }
}
