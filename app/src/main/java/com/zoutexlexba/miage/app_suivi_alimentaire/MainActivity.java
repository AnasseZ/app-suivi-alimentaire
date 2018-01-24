package com.zoutexlexba.miage.app_suivi_alimentaire;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zoutexlexba.miage.app_suivi_alimentaire.Services.FoodResponse;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.HttpHandler;

public class MainActivity extends AppCompatActivity {

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
