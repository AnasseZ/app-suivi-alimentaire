package com.zoutexlexba.miage.app_suivi_alimentaire.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.zoutexlexba.miage.app_suivi_alimentaire.R;
import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.User;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.SecurePassword;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Created by quentinlexert on 21/03/2018.
 */

public class CreaAccountActivity extends OrmLiteBaseActivity<DatabaseHelper> implements View.OnClickListener {
    public EditText password,pseudo,login,age,weight;
    public String radio;
    SecurePassword hashPassword = new SecurePassword();
    RadioGroup rg;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        pseudo = ((EditText)findViewById(R.id.editPseudo));;
        password = ((EditText)findViewById(R.id.editPw));
        login = ((EditText)findViewById(R.id.editID));
        age = ((EditText)findViewById(R.id.editAge));
        weight = ((EditText)findViewById(R.id.editWeigh));
        Button b = (Button)findViewById(R.id.b_insc);
        b.setOnClickListener(this);
        rg  = ((RadioGroup)findViewById(R.id.radio_group));
        /*rg.addView((RadioButton)findViewById(R.id.radioMaintien),0);
        rg.addView((RadioButton)findViewById(R.id.radioPerte),1);
        rg.addView((RadioButton)findViewById(R.id.radioPrise),2);*/

    }

    @Override
    public void onClick(View v) {

        switch(rg.getCheckedRadioButtonId()){
            case 0:
                radio = "maintien";
                break;
            case 1:
                radio = "perte";
                break;
            case 2 :
                radio = "prise";
                break;
        }

        if(pseudo.getText().toString().matches("") || password.getText().toString().matches("") || login.getText().toString().matches("") || age.getText().toString().matches("") || weight.getText().toString().matches(""))
        {
            Toast.makeText(getApplicationContext(), "Veuillez compléter tous les champs", Toast.LENGTH_SHORT).show();
        }
        else {

            try {
                String loginString = login.getText().toString().trim();
                String passwordString = hashPassword.generateStrongPasswordHash(password.getText().toString().trim());

                Double weightDouble = Double.parseDouble(weight.getText().toString().trim());
                Integer ageInt = Integer.parseInt(age.getText().toString().trim());

                RuntimeExceptionDao<User,String> userDao = getHelper().getUserRuntimeDao();
                User newOne = new User(loginString,passwordString,weightDouble,radio,ageInt);
                System.out.println(newOne.getAge() + " " + newOne.getLogin()+newOne.getWeight()+newOne.getPassword());
                userDao.createOrUpdate(newOne);

                Intent intent = new Intent(CreaAccountActivity.this, NavigationActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                System.out.println("<--ERREUR-->\n"+e.getMessage());
                System.out.println(e.getLocalizedMessage());
                //System.out.println(e.getCause());
            }
        }
    }
}