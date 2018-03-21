package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.table.TableUtils;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.FoodConsumed;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Meal;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.User;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;

import java.sql.SQLException;

/**
 * Created by Paulalex on 31/01/2018.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "foodsave.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 4;

    // the DAO object we use to access the Aliment table
    private Dao<User,Integer> userDao=null;
    private RuntimeExceptionDao<User,Integer> userRuntimeDao=null;

    private Dao<Food, Integer> foodDao = null;
    private RuntimeExceptionDao<Food, Integer> foodRuntimeDao = null;

    private Dao<FoodConsumed, Integer> consommeDao = null;
    private RuntimeExceptionDao<FoodConsumed, Integer> consommeRuntimeDao = null;

    private Dao<Day, String> journeeDao = null;
    private RuntimeExceptionDao<Day, String> journeeRuntimeDao = null;

    private Dao<Meal, Integer> repasDao = null;
    private RuntimeExceptionDao<Meal, Integer> repasRuntimeDao = null;

    /*private String TABLE_USER = "user";
    private int COLUMN_USER_ID;
    private String COLUMN_USER_NAME = "name";
    private String COLUMN_USER_EMAIL = "email";
    private String COLUMN_USER_PASSWORD = "password";*/

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource){
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTableIfNotExists(connectionSource, FoodConsumed.class);
            TableUtils.createTableIfNotExists(connectionSource, Food.class);
            TableUtils.createTableIfNotExists(connectionSource, Day.class);
            TableUtils.createTableIfNotExists(connectionSource, Meal.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion){

        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, FoodConsumed.class, true);
            TableUtils.dropTable(connectionSource, Food.class, true);
            TableUtils.dropTable(connectionSource, Meal.class, true);
            TableUtils.dropTable(connectionSource, Day.class, true);
           // db.execSQL("create table User(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,email TEXT, password TEXT)");
          //  TableUtils.dropTable(connectionSource,User.class,true);
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

    public Dao<User,Integer> getUserDao() throws SQLException{
        if (userDao==null){
            userDao=getDao(User.class);
        }
        return userDao;
    }

    public Dao<FoodConsumed, Integer> getConsommeDao() throws SQLException {
        if (consommeDao == null) {
            consommeDao = getDao(FoodConsumed.class);
        }
        return consommeDao;
    }

    public Dao<Food, Integer> getfoodDao() throws SQLException {
        if (foodDao == null) {
            foodDao = getDao(Food.class);
        }
        return foodDao;
    }

    public Dao<Day, String> getJourneeDao() throws SQLException {
        if (journeeDao == null) {
            journeeDao = getDao(Day.class);
        }
        return journeeDao;
    }

    public Dao<Meal, Integer> getRepasDao() throws SQLException {
        if (repasDao == null) {
            repasDao = getDao(Meal.class);
        }
        return repasDao;
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<User,Integer> getUserRuntimeDao(){
        if (userRuntimeDao==null){
            userRuntimeDao=getRuntimeExceptionDao(User.class);
        }
        return userRuntimeDao;
    }

    public RuntimeExceptionDao<Food, Integer> getFoodRuntimeDao() {
        if (foodRuntimeDao == null) {
            foodRuntimeDao = getRuntimeExceptionDao(Food.class);
        }
        return foodRuntimeDao;
    }

    public RuntimeExceptionDao<FoodConsumed, Integer> getConsommeDataDao() {
        if (consommeRuntimeDao == null) {
            consommeRuntimeDao = getRuntimeExceptionDao(FoodConsumed.class);
        }
        return consommeRuntimeDao;
    }

    public RuntimeExceptionDao<Day, String> getJourneeRuntimeDao() {
        if (journeeRuntimeDao == null) {
            journeeRuntimeDao = getRuntimeExceptionDao(Day.class);
        }
        return journeeRuntimeDao;
    }

    public RuntimeExceptionDao<Meal, Integer> getRepasRuntimeDao() {
        if (repasRuntimeDao == null) {
            repasRuntimeDao = getRuntimeExceptionDao(Meal.class);
        }
        return repasRuntimeDao;
    }

    /*public Boolean addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
       /values.put("name", "ouleye");
        values.put("email", "barrouleye4@gmail.com");
        values.put("password", "yenapas");

        // Inserting Row
       long ins= db.insert(TABLE_USER, null, values);
       if (ins==-1) return false;
       else return true;
    }

    public boolean isUser(String login, String pwd){
        SQLiteDatabase db = this.getReadableDatabase();
        String request="SELECT * from User where name=? and pwd=?";
        Cursor cursor=db.rawQuery(request,new String[]{login,pwd});
        if (cursor.getCount()>0)
            return false;
        else
            return true;
    }*/

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        userDao=null;
        foodDao = null;
        foodRuntimeDao = null;
        consommeDao = null;
        userRuntimeDao=null;
        consommeRuntimeDao = null;
        journeeDao  = null;
        journeeRuntimeDao = null;
        repasDao = null;
        repasRuntimeDao = null;
    }
}
