package com.zoutexlexba.miage.app_suivi_alimentaire.Services;

import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Aliment;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Journee;

/**
 * Created by anassezougarh on 22/02/2018.
 */

public class NutrimentsCalculator {



    public int getTotalProteinByDay(Journee journee) {

        int total = 0;

        for(Aliment aliment  :  journee.getList_aliment()
             ) {

        }


        return 1;
    }
}
