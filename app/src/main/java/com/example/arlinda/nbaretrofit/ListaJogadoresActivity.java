package com.example.arlinda.nbaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.arlinda.nbaretrofit.adapter.JogadoresAdapter;
import com.example.arlinda.nbaretrofit.adapter.RecyclerViewJogadoresAdapter;
import com.example.arlinda.nbaretrofit.interfaces.NbaAPI;
import com.example.arlinda.nbaretrofit.interfaces.StatsAPI;
import com.example.arlinda.nbaretrofit.model.player.Feed;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.example.arlinda.nbaretrofit.model.stats.Latest;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaJogadoresActivity extends AppCompatActivity {
    ListView listViewJogadores;

    RecyclerView recyclerView;
    public Standard standard;
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "http://data.nba.net/";
    String teamId = null;
    private ArrayList<Standard> standardListFiltatrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_jogadores);

       recyclerView = findViewById(R.id.recyclerViewJogadores);


        teamId = getIntent().getExtras().getString("teamid");

        standardListFiltatrada = new ArrayList<>();
        callPlayers();
        //  Toast.makeText(this, standardListFiltatrada.get(0).getPersonId(), Toast.LENGTH_SHORT).show()

    }


    public void callPlayers() {

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

                for (int i = 0; i < standardList.size(); i++) {
                    if (standardList.get(i).getTeamId().equals(teamId)) {

                        standardListFiltatrada.add(standardList.get(i));

                    }
                }
                callStats(standardListFiltatrada);
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong: " + t.getMessage());
                Toast.makeText(ListaJogadoresActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void callStats(final ArrayList<Standard> arrayList) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StatsAPI statsAPI = retrofit.create(StatsAPI.class);
        final ArrayList<Latest> latestArrayList = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            String personId = arrayList.get(i).getPersonId();
            final Call<com.example.arlinda.nbaretrofit.model.stats.Response> call = statsAPI.getData(personId);

            final int finalI = i;
            call.enqueue(new Callback<com.example.arlinda.nbaretrofit.model.stats.Response>() {
                @Override
                public void onResponse(Call<com.example.arlinda.nbaretrofit.model.stats.Response> call, Response<com.example.arlinda.nbaretrofit.model.stats.Response> response) {
                    int code = response.code();
                    if (code == 200) {
                        com.example.arlinda.nbaretrofit.model.stats.Response response1 = response.body();
                   //     String x = response1.getLeague().getStandard().getStats().getLatest().getAssists();
                        latestArrayList.add(response1.getLeague().getStandard().getStats().getLatest());
                     //   Toast.makeText(ListaJogadoresActivity.this, latestArrayList.get(0).getAssists(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getBaseContext(), "Falha ao acessar Web Service, anote o codigo: " + String.valueOf(code),
                                Toast.LENGTH_LONG).show();
                    }
                    try {


                        if (!arrayList.isEmpty() && !latestArrayList.isEmpty() && (finalI == arrayList.size() - 1)) {
                            Toast.makeText(ListaJogadoresActivity.this, latestArrayList.get(0).getPpg(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(ListaJogadoresActivity.this, arrayList.get(0).getLastName(), Toast.LENGTH_SHORT).show();
                            RecyclerViewJogadoresAdapter adapter = new RecyclerViewJogadoresAdapter(ListaJogadoresActivity.this,
                                    arrayList, latestArrayList);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(ListaJogadoresActivity.this));

                        }
                    }catch (Exception e){
                         Log.d(String.valueOf(e), "erro");
                    }

                }

                @Override
                public void onFailure(Call<com.example.arlinda.nbaretrofit.model.stats.Response> call, Throwable t) {
                    Toast.makeText(getBaseContext(), t.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            });

        }


    }


}


