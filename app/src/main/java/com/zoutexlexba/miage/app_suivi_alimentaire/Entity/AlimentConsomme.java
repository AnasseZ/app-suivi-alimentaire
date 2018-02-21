package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Paulalex on 31/01/2018.
 */

@DatabaseTable(tableName = "consomme")
public class AlimentConsomme {

    public static final String TYPE = "type";
    public static final String ID_TYPE = "id_type";

    @DatabaseField(generatedId = true)
    private Integer id;
    @DatabaseField(canBeNull = false)
    private float quantite;
    @DatabaseField(canBeNull = false)
    private Integer id_food;
    @DatabaseField(canBeNull = false, columnName = TYPE)
    private String type;
    @DatabaseField(canBeNull = false, columnName = ID_TYPE)
    private String id_type;


    public AlimentConsomme(){ }

    public AlimentConsomme(float quantite, Integer id){
        this.quantite = quantite;
        this.id_food = id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }
}
