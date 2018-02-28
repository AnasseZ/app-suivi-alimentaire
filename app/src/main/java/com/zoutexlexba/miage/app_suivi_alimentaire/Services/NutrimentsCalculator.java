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
        dailyReport.updateEnergyConsumed(food.getEnergy_100g(), ratio);
        dailyReport.updateCarbohydratesConsumed(food.getCarbohydrates_100g(), ratio);
        dailyReport.updateFatConsumed(food.getFat_100g(),ratio);
        dailyReport.updateProteinConsumed(food.getProteins_100g(), ratio);
        dailyReport.updateFiberConsumed(food.getFiber_100g(), ratio);
    }

    public int getEnergyPercentage(Day dailyReport) {

        double energy = dailyReport.getEnergyConsumed();
        double rate = energy / 2930;
        double percentage = rate * 100;

        return dailyReport.getEnergyConsumed() == 0 ? 0 : (int)percentage;
    }

    public int getProteinPercentage(Day dailyReport) {
        return dailyReport.getProteinConsumed() == 0 ? 0 : (int)((dailyReport.getProteinConsumed() / 147) * 100);
    }

    public int getCarbPercentage(Day dailyReport) {
        return dailyReport.getCarbohydratesConsumed() == 0 ? 0 : (int)((dailyReport.getCarbohydratesConsumed() / 366) * 100);
    }

    public int getFatPercentage(Day dailyReport) {
        return dailyReport.getFatConsumed() == 0 ? 0 : (int)((dailyReport.getFatConsumed() / 98) * 100 );
    }

    public int getFiberPercentage(Day dailyReport) {
        return dailyReport.getFiberConsumed() == 0 ? 0 : (int)((dailyReport.getFiberConsumed() / 38) * 100);
    }
}
