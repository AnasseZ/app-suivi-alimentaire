package com.zoutexlexba.miage.app_suivi_alimentaire;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.Aliment;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.DatabaseHelper;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.FoodResponse;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.HttpHandler;

import java.util.List;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    private String foodName;

    private String URL_1 = "https://world.openfoodfacts.org/cgi/search.pl?search_terms=";
    private String URL_2 = "&search_simple=1&action=process&json=1";

    public HttpHandler httpHandler = new HttpHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchFoodButton = (Button) findViewById(R.id.searchFoodButton);
        final EditText userInput = (EditText) findViewById(R.id.searchFoodTextInput);

        FoodResponse food = httpHandler.getFoodFromJson();

        TextView view = (TextView) findViewById(R.id.outputGson);
        view.setText(food.nom + " fait " + food.grammes + "grammes.");

        searchFoodButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                foodName = userInput.getText().toString();
                new ApiCallOperation().execute();
            }
        });



        // get our dao
        RuntimeExceptionDao<Aliment, String> alimentDao = getHelper().getAlimentDataDao();

        Aliment testaliment1 = alimentDao.queryForId("test");
        if(testaliment1 == null){
            testaliment1 = new Aliment("test");
            testaliment1.setCalories(1.0f);
            alimentDao.create(testaliment1);
        }

        testORM(alimentDao, testaliment1);



    }

    private void testORM(final RuntimeExceptionDao<Aliment, String> alimentDao, final Aliment testaliment1){

        final TextView testv = (TextView) findViewById(R.id.text_test);
        Button buttontest = (Button) findViewById(R.id.button_test);

        buttontest.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                testaliment1.setCalories(testaliment1.getCalories() + 1.0f);
                alimentDao.update(testaliment1);
                testv.setText(String.valueOf(testaliment1.getCalories()));
            }
        });

        testv.setText(String.valueOf(testaliment1.getCalories()));
    }

    private class ApiCallOperation extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            // API CALL HERE
            return httpHandler.makeServiceCall(URL_1 + foodName + URL_2);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            // Do things like update the progress bar
        }

        @Override
        /**
         * result est la valeur retournée par doInBackground
         */
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            TextView txt = (TextView) findViewById(R.id.outputGson);
            txt.setText(result);
        }
    }
}
