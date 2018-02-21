package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "aliment")
public class AlimentConsomme {

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private float quantite;
    @DatabaseField(canBeNull = false)
    private Integer id_food;

    public AlimentConsomme(){ }

    public Integer getId() {
        return id;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }
}
