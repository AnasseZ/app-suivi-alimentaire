package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import java.util.ArrayList;

/**
 * Created by anassezougarh on 22/02/2018.
 */

public class DailyReport {

    private int eneryGoal;
    private int energyConsumed;

    private double proteinGoal;
    private double proteinConsumed;

    private double fiberGoal;
    private double fiberConsumed;

    private double fatGoal;
    private double fatConsumed;

    private double carbohydratesGoal;
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
