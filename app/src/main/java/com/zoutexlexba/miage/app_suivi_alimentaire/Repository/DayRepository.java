package com.zoutexlexba.miage.app_suivi_alimentaire.Repository;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Day;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;

/**
 * Created by anassezougarh on 27/02/2018.
 */

public class DayRepository {

    public Day findDayByDate(String dateStr, DatabaseHelper helper) {
        RuntimeExceptionDao<Day, String> journeeDao = helper.getJourneeRuntimeDao();
        Day currentJournee =  journeeDao.queryForId(dateStr);
        if(currentJournee == null) {
            currentJournee = new Day(dateStr);
            journeeDao.create(currentJournee);
        }

        return currentJournee;
    }
}
