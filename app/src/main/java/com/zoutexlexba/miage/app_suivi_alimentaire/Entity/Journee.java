package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "journee")
public class Journee {
    //format de la date en jj/mm/yyyy
    @DatabaseField(id = true)
    private String date_journee;

    public Journee(){}

    public Journee(String jour){
        date_journee = jour;
    }

    public String getDate_journee() {
        return date_journee;
    }

}
