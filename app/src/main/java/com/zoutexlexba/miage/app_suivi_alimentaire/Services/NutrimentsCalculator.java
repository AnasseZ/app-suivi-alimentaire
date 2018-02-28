package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;

/**
 * Created by anassezougarh on 22/02/2018.
 */

public class NutrimentsCalculator {

    /**
     * Mise à jours des compteurs à appeler
     * à chaque ajout d'aliment
     *
     * @param dailyReport la Journée actuelle
     */
    public void updateGoals(Day dailyReport, Food food, float quantityConsumed) {

        double ratio = quantityConsumed / 100;
        dailyReport.setEnergyConsumed((int)(food.getNutriment().getEnergy_100g() * ratio));
        dailyReport.setCarbohydratesConsumed(food.getNutriment().getCarbohydrates_100g() * ratio);
        dailyReport.setFatConsumed(food.getNutriment().getFat_100g() * ratio);
        dailyReport.setProteinConsumed(food.getNutriment().getProteins_100g() * ratio);
        dailyReport.setFiberConsumed(food.getNutriment().getFiber_100g() * ratio);
    }

    public int getEnergyPercentage(Day dailyReport) {
        return dailyReport.getEnergyConsumed() == 0 ? 0 : dailyReport.getEnergyConsumed() / dailyReport.getEneryGoal();
    }

    public int getProteinPercentage(Day dailyReport) {
        return dailyReport.getProteinConsumed() == 0 ? 0 : (int)(dailyReport.getProteinConsumed() / dailyReport.getProteinGoal());
    }

    public int getCarbPercentage(Day dailyReport) {
        return dailyReport.getCarbohydratesConsumed() == 0 ? 0 : (int)(dailyReport.getCarbohydratesConsumed() / dailyReport.getCarbohydratesGoal());
    }

    public int getFatPercentage(Day dailyReport) {
        return dailyReport.getFatConsumed() == 0 ? 0 : (int)(dailyReport.getFatConsumed() / dailyReport.getFatGoal());
    }

    public int getFiberPercentage(Day dailyReport) {
        return dailyReport.getFiberConsumed() == 0 ? 0 : (int)(dailyReport.getFiberConsumed() / dailyReport.getFiberGoal());
    }
}
