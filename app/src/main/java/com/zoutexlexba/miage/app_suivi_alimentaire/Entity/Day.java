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
}
