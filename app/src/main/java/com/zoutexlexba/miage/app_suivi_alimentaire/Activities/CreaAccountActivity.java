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
                //getHelper().getUserRuntimeDao().create(new User(login.getText().toString(),password.getText().toString(),42/*Integer.getInteger(age.getText().toString())*/,radio,34/*Integer.getInteger(weight.getText().toString())*/));
                getHelper().getUserRuntimeDao().create(new User("toto","tutu",42/*Integer.getInteger(age.getText().toString())*/,radio,34/*Integer.getInteger(weight.getText().toString())*/));

                Intent intent = new Intent(CreaAccountActivity.this, NavigationActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                System.out.println("<--ERREUR-->\n"+e.getMessage());
            }
        }
    }

    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        int iterations = 10000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}