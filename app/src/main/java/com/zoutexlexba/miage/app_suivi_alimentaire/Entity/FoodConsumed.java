package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "foodconsumed")
public class FoodConsumed {

    public static final String TYPE = "type";
    public static final String ID_MEAL = "idMeal";
    public static final String ID_DAY = "idDay";

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private float quantity;
    @DatabaseField(canBeNull = false)
    private Integer idFood;
    //day or meal
    @DatabaseField(canBeNull = false,columnName = TYPE)
    private String type;
    //id of tuple meal
    @DatabaseField(columnName = ID_MEAL)
    private Integer idMeal;
    //id of tuple day
    @DatabaseField(columnName = ID_DAY)
    private String dateJour;



    public FoodConsumed(){ }

    public FoodConsumed(float quantity, Integer id){
        this.quantity = quantity;
        this.idFood = id;
    }

    public FoodConsumed(float quantity, Integer idFood, String type, Integer idMeal){
        this.quantity = quantity;
        this.idFood = idFood;
        this.type = type;
        this.idMeal = idMeal;
    }

    public FoodConsumed(float quantity, Integer idFood, String type, String idDay){
        this.quantity = quantity;
        this.idFood = idFood;
        this.type = type;
        this.dateJour = idDay;
    }


    public Integer getId() {
        return id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Integer getIdFood() {
        return idFood;
    }

    public void setIdFood(Integer idFood) {
        this.idFood = idFood;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Integer idMeal) {
        this.idMeal = idMeal;
    }

    public String getDateJour() {
        return dateJour;
    }

    public void setDateJour(String dateJour) {
        this.dateJour = dateJour;
    }

    public void getCalories(){

    }
}
