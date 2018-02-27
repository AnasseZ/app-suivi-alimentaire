package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.DailyReport;
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
    public void updateGoals(DailyReport dailyReport) {

        // Récupération du dernier aliment ajoutée à la consommation journalière
        Food food = dailyReport.getListFood().get(dailyReport.getListFood().size() -1);

        double ratio = food.getQuantityConsumed() / 100;
        dailyReport.setEnergyConsumed((int)(food.getNutriment().getEnergy_100g() * ratio));
        dailyReport.setCarbohydratesConsumed(food.getNutriment().getCarbohydrates_100g() * ratio);
        dailyReport.setFatConsumed(food.getNutriment().getFat_100g() * ratio);
        dailyReport.setProteinConsumed(food.getNutriment().getProteins_100g() * ratio);
        dailyReport.setFiberConsumed(food.getNutriment().getFiber_100g() * ratio);
    }

    public int getEnergyPercentage(DailyReport dailyReport) {
        return dailyReport.getEnergyConsumed() / dailyReport.getEneryGoal();
    }

    public int getProteinPercentage(DailyReport dailyReport) {
        return (int)(dailyReport.getProteinConsumed() / dailyReport.getProteinGoal());
    }

    public int getCarbPercentage(DailyReport dailyReport) {
        return (int)(dailyReport.getCarbohydratesConsumed() / dailyReport.getCarbohydratesGoal());
    }

    public int getFatPercentage(DailyReport dailyReport) {
        return (int)(dailyReport.getFatConsumed() / dailyReport.getFatGoal());
    }

    public int getFiberPercentage(DailyReport dailyReport) {
        return (int)(dailyReport.getFiberConsumed() / dailyReport.getFiberGoal());
    }
}
