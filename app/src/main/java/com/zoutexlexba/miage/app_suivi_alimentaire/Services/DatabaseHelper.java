package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.table.TableUtils;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.AlimentConsomme;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Journee;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Repas;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Paulalex on 31/01/2018.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "foodsave.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the Aliment table
    private Dao<Food, Integer> foodDao = null;
    private RuntimeExceptionDao<Food, Integer> foodRuntimeDao = null;

    private Dao<AlimentConsomme, Integer> consommeDao = null;
    private RuntimeExceptionDao<AlimentConsomme, Integer> consommeRuntimeDao = null;

    private Dao<Journee, Date> journeeDao = null;
    private RuntimeExceptionDao<Journee, Date> journeeRuntimeDao = null;

    private Dao<Repas, Integer> repasDao = null;
    private RuntimeExceptionDao<Repas, Integer> repasRuntimeDao = null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource){
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, AlimentConsomme.class);
            TableUtils.createTable(connectionSource, Food.class);
            TableUtils.createTable(connectionSource, Journee.class);
            TableUtils.createTable(connectionSource, Repas.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion){
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, AlimentConsomme.class, true);
            TableUtils.dropTable(connectionSource, Food.class, true);
            TableUtils.dropTable(connectionSource, Repas.class, true);
            TableUtils.dropTable(connectionSource, Journee.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our SimpleData class. It will create it or just give the cached
     * value.
     */
    public Dao<AlimentConsomme, Integer> getConsommeDao() throws SQLException {
        if (consommeDao == null) {
            consommeDao = getDao(AlimentConsomme.class);
        }
        return consommeDao;
    }

    public Dao<Food, Integer> getfoodDao() throws SQLException {
        if (foodDao == null) {
            foodDao = getDao(Food.class);
        }
        return foodDao;
    }

    public Dao<Journee, Date> getJourneeDao() throws SQLException {
        if (journeeDao == null) {
            journeeDao = getDao(Journee.class);
        }
        return journeeDao;
    }

    public Dao<Repas, Integer> getRepasDao() throws SQLException {
        if (repasDao == null) {
            repasDao = getDao(Repas.class);
        }
        return repasDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Food, Integer> getFoodRuntimeDao() {
        if (foodRuntimeDao == null) {
            foodRuntimeDao = getRuntimeExceptionDao(Food.class);
        }
        return foodRuntimeDao;
    }

    public RuntimeExceptionDao<AlimentConsomme, Integer> getConsommeDataDao() {
        if (consommeRuntimeDao == null) {
            consommeRuntimeDao = getRuntimeExceptionDao(AlimentConsomme.class);
        }
        return consommeRuntimeDao;
    }

    public RuntimeExceptionDao<Journee, Date> getJourneeRuntimeDao() {
        if (journeeRuntimeDao == null) {
            journeeRuntimeDao = getRuntimeExceptionDao(Journee.class);
        }
        return journeeRuntimeDao;
    }

    public RuntimeExceptionDao<Repas, Integer> getRepasRuntimeDao() {
        if (repasRuntimeDao == null) {
            repasRuntimeDao = getRuntimeExceptionDao(Repas.class);
        }
        return repasRuntimeDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        foodDao = null;
        foodRuntimeDao = null;
        consommeDao = null;
        consommeRuntimeDao = null;
        journeeDao  = null;
        journeeRuntimeDao = null;
        repasDao = null;
        repasRuntimeDao = null;
    }
}
