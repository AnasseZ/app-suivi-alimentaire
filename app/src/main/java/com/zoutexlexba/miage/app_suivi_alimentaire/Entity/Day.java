package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "day")
public class Day {
    public static final String DATE_JOURNEE = "date_journee";

    //format de la date en jj/mm/yyyy
    @DatabaseField(id = true)
    private String dateJournee;

    public Day(){}

    public Day(String jour){
        dateJournee = jour;
    }

    public String getDateJournee() {
        return dateJournee;
    }

    @DatabaseField
    private int eneryGoal;
    @DatabaseField
    private int energyConsumed;

    @DatabaseField
    private double proteinGoal;
    @DatabaseField
    private double proteinConsumed;

    @DatabaseField
    private double fiberGoal;
    @DatabaseField
    private double fiberConsumed;

    @DatabaseField
    private double fatGoal;
    @DatabaseField
    private double fatConsumed;

    @DatabaseField
    private double carbohydratesGoal;

    @DatabaseField
    private double carbohydratesConsumed;

    private ArrayList<Food> listFood;

    public int getEneryGoal() {
        return eneryGoal;
    }

    public void setEneryGoal(int eneryGoal) {
        this.eneryGoal = eneryGoal;
    }

    public int getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(int energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public double getProteinGoal() {
        return proteinGoal;
    }

    public void setProteinGoal(double proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public double getProteinConsumed() {
        return proteinConsumed;
    }

    public void setProteinConsumed(double proteinConsumed) {
        this.proteinConsumed = proteinConsumed;
    }

    public double getFiberGoal() {
        return fiberGoal;
    }

    public void setFiberGoal(double fiberGoal) {
        this.fiberGoal = fiberGoal;
    }

    public double getFiberConsumed() {
        return fiberConsumed;
    }

    public void setFiberConsumed(double fiberConsumed) {
        this.fiberConsumed = fiberConsumed;
    }

    public double getFatGoal() {
        return fatGoal;
    }

    public void setFatGoal(double fatGoal) {
        this.fatGoal = fatGoal;
    }

    public double getFatConsumed() {
        return fatConsumed;
    }

    public void setFatConsumed(double fatConsumed) {
        this.fatConsumed = fatConsumed;
    }

    public double getCarbohydratesGoal() {
        return carbohydratesGoal;
    }

    public void setCarbohydratesGoal(double carbohydratesGoal) {
        this.carbohydratesGoal = carbohydratesGoal;
    }

    public double getCarbohydratesConsumed() {
        return carbohydratesConsumed;
    }

    public void setCarbohydratesConsumed(double carbohydratesConsumed) {
        this.carbohydratesConsumed = carbohydratesConsumed;
    }

    public ArrayList<Food> getListFood() {
        return listFood;
    }

    public void setListFood(ArrayList<Food> listFood) {
        this.listFood = listFood;
    }
}
