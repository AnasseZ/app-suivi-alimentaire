package com.zoutexlexba.miage.app_suivi_alimentaire;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.zoutexlexba.miage.app_suivi_alimentaire.Entity.Food;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.FoodAdapter;
import com.zoutexlexba.miage.app_suivi_alimentaire.Services.HttpHandler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String foodName;

    private String URL_1 = "https://world.openfoodfacts.org/cgi/search.pl?search_terms=";
    private String URL_2 = "&search_simple=1&action=process&json=1";

    public HttpHandler httpHandler = new HttpHandler();
    public ArrayList<Food> foodList;

    private FoodAdapter foodAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchFoodButton = (Button) findViewById(R.id.searchFoodButton);
        final EditText userInput = (EditText) findViewById(R.id.searchFoodTextInput);

        searchFoodButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                foodName = userInput.getText().toString();
                new ApiCallOperation().execute();
            }
        });

        listView = (ListView) findViewById(R.id.foodList);
    }

    private class ApiCallOperation extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            // API CALL HERE
            String apiResponse = httpHandler.makeServiceCall(URL_1 + foodName + URL_2);
            foodList = httpHandler.getFoodFromJson(apiResponse).foodList;
            return  foodList.size() + " aliments trouvés.";
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

            foodAdapter = new FoodAdapter(MainActivity.this, foodList);
            listView.setAdapter(foodAdapter);
        }
    }
}
