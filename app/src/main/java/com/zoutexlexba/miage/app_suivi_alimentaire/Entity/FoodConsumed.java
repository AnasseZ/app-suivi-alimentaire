package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "foodconsumed")
public class FoodConsumed {

    public static final String TYPE = "type";
    public static final String ID_TYPE = "idType";

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private float quantity;
    @DatabaseField(canBeNull = false)
    private Integer idFood;
    @DatabaseField(canBeNull = false, columnName = TYPE)
    private String type;
    @DatabaseField(canBeNull = false, columnName = ID_TYPE)
    private Integer idType;


    public FoodConsumed(){ }

    public FoodConsumed(float quantity, Integer id){
        this.quantity = quantity;
        this.idFood = id;
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

    public Integer getId_type() {
        return idType;
    }

    public void setId_type(Integer id_type) {
        this.idType = id_type;
    }
}
