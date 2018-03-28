package com.zoutexlexba.miage.app_suivi_alimentaire.Entity;

import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Test on 14/03/2018.
 */

@DatabaseTable(tableName = "User")
public class User {

    @DatabaseField(id = true,canBeNull = false)
    private String login;
    //@DatabaseField(columnName = "email")
    //private String email;
    @DatabaseField(canBeNull = false)
    private String password;
    @DatabaseField
    private Double weight ;
    @DatabaseField
    private String obj;
    @DatabaseField
    private Integer age;


    public Double getWeight() { return weight; }

    public void setWeight(Double weight) { this.weight = weight; }

    public String getObj() { return obj; }

    public void setObj(String obj) { this.obj = obj; }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    public String getLogin(){
        return this.login;
    }

    /*public String getEmail(){
        return this.email;
    }*/

    public String getPassword(){
        return this.password;
    }


    public void setLogin(String name){
        this.login=name;
    }

    /*public void setEmail(String email){
        this.email=email;
    }*/

    public void setPassword(String password){
        this.password=password;
    }

    public User()
    {

    }

    public User(String name, String email, String password){
        this.login=name;
        //this.email=email;
        this.password=password;
    }

    public User(String login, String password){
        this.login=login;
        this.password=password;

    }

    public User(String login, String password, Double weight , String obj, Integer age){
        this.login = login;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.obj = obj;
        //this.email = null;
    }

}
