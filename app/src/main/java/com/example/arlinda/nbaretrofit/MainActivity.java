package com.example.arlinda.nbaretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.arlinda.nbaretrofit.model.Feed;
import com.example.arlinda.nbaretrofit.model.Standard;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "http://data.nba.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CardView cardViewHawk = findViewById(R.id.cardViewHawk);



        cardViewHawk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                NbaAPI nbaAPI = retrofit.create(NbaAPI.class);
                Call<Feed> call = nbaAPI.getData();

                call.enqueue(new Callback<Feed>() {
                    @Override
                    public void onResponse(Call<Feed> call, Response<Feed> response) {
                        Log.d(TAG, "onResponse: Server Response: " + response.toString());
                        Log.d(TAG, "onResponse: received information: " + response.body().toString());

                        ArrayList<Standard> standardList = response.body().getLeague().getStandard();
                        for( int i = 0; i<standardList.size(); i++){
                            Log.d(TAG, "onResponse: \n" +
                                    "First Name: " + standardList.get(i).getFirstName() + "\n" +
                                    "Last Name: " + standardList.get(i).getLastName() + "\n" +
                                    "-------------------------------------------------------------------------\n\n");
                        }
                    }

                    @Override
                    public void onFailure(Call<Feed> call, Throwable t) {
                        Log.e(TAG, "onFailure: Something went wrong: " + t.getMessage() );
                        Toast.makeText(MainActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}