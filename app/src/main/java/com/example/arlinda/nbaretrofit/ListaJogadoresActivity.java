package com.example.arlinda.nbaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.arlinda.nbaretrofit.adapter.JogadoresAdapter;
import com.example.arlinda.nbaretrofit.interfaces.NbaAPI;
import com.example.arlinda.nbaretrofit.model.Feed;
import com.example.arlinda.nbaretrofit.model.Standard;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaJogadoresActivity extends AppCompatActivity  {
    ListView listViewJogadores;
    public Standard standard;
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "http://data.nba.net/";
    String teamId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogadores);


        listViewJogadores = findViewById(R.id.listViewJogadores);


        teamId = getIntent().getExtras().getString("teamid");
        Toast.makeText(this, teamId, Toast.LENGTH_SHORT).show();


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
                ArrayList<Standard> standardListFiltatrada = new ArrayList<>();
                for (int i = 0; i < standardList.size(); i++) {
                    int x = 0;
                    if (standardList.get(i).getTeamId().equals(teamId)) {
                        standardListFiltatrada.add(x, standardList.get(i));
                        x++;
                    }
                }

                if (standardListFiltatrada != null) {
                    JogadoresAdapter cus = new JogadoresAdapter(ListaJogadoresActivity.this, standardListFiltatrada);
                    listViewJogadores.setAdapter(cus);
                } else {
                    Toast.makeText(ListaJogadoresActivity.this, "Lista Vazia", Toast.LENGTH_SHORT).show();
                }
                for (int i = 0; i < standardList.size(); i++) {
                    Log.d(TAG, "onResponse: \n" +
                            "First Name: " + standardList.get(i).getFirstName() + "\n" +
                            "Last Name: " + standardList.get(i).getLastName() + "\n" +
                            "-------------------------------------------------------------------------\n\n");
                }
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong: " + t.getMessage());
                Toast.makeText(ListaJogadoresActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }
}


