package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "daymealconsumed")
public class DayMealConsumed {

    public static final String ID_DAY = "idDay";

    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField
    private Integer idMeal;

    @DatabaseField(columnName = ID_DAY)
    private String idDay;

    public DayMealConsumed(){

    }

    public DayMealConsumed(Integer id, String day){
        this.idDay = day;
        this.idMeal = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(Integer idMeal) {
        this.idMeal = idMeal;
    }

    public String getIdDay() {
        return idDay;
    }

    public void setIdDay(String idDay) {
        this.idDay = idDay;
    }
}
