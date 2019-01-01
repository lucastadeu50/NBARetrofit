package com.example.arlinda.nbaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.arlinda.nbaretrofit.adapter.JogadoresAdapter;
import com.example.arlinda.nbaretrofit.interfaces.NbaAPI;
import com.example.arlinda.nbaretrofit.interfaces.StatsAPI;
import com.example.arlinda.nbaretrofit.model.player.Feed;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.example.arlinda.nbaretrofit.model.stats.Latest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaJogadoresActivity extends AppCompatActivity {
    ListView listViewJogadores;
    public Standard standard;
    private static final String TAG = "MainActivity";
    private static final String BASE_URL = "http://data.nba.net/";
    String teamId = null;
    private ArrayList<Standard> standardListFiltatrada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jogadores);

        listViewJogadores = findViewById(R.id.listViewJogadores);

        teamId = getIntent().getExtras().getString("teamid");

        standardListFiltatrada = new ArrayList<>();
        callPlayers();
        //  Toast.makeText(this, standardListFiltatrada.get(0).getPersonId(), Toast.LENGTH_SHORT).show()

        listViewJogadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String x = String.valueOf(position);
                Toast.makeText(ListaJogadoresActivity.this, x, Toast.LENGTH_SHORT).show();

                //     String personID = standardListFiltatrada.get(position).getPersonId();

                //   callStats(personID);

            }
        });


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
                    int x = 0;
                    if (standardList.get(i).getTeamId().equals(teamId)) {

                        standardListFiltatrada.add(x, standardList.get(i));

                        x++;
                    }
                }

                if (standardListFiltatrada != null) {
                    JogadoresAdapter cus = new JogadoresAdapter(ListaJogadoresActivity.this, standardListFiltatrada);
                    listViewJogadores.setAdapter(cus);
                    callStats(standardListFiltatrada);
                } else {
                    Toast.makeText(ListaJogadoresActivity.this, "Lista Vazia", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "onFailure: Something went wrong: " + t.getMessage());
                Toast.makeText(ListaJogadoresActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void callStats(ArrayList<Standard> arrayList) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        StatsAPI statsAPI = retrofit.create(StatsAPI.class);
        final ArrayList<Latest> latestArrayList = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            String personId = arrayList.get(i).getPersonId();
            final Call<com.example.arlinda.nbaretrofit.model.stats.Response> call = statsAPI.getData(personId);

            call.enqueue(new Callback<com.example.arlinda.nbaretrofit.model.stats.Response>() {
                @Override
                public void onResponse(Call<com.example.arlinda.nbaretrofit.model.stats.Response> call, Response<com.example.arlinda.nbaretrofit.model.stats.Response> response) {
                    int code = response.code();
                    if (code == 200) {
                        com.example.arlinda.nbaretrofit.model.stats.Response response1 = response.body();
                   //     String x = response1.getLeague().getStandard().getStats().getLatest().getAssists();
                        latestArrayList.add(response1.getLeague().getStandard().getStats().getLatest());
                        Toast.makeText(ListaJogadoresActivity.this, latestArrayList.get(0).getAssists(), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getBaseContext(), "Falha ao acessar Web Service, anote o codigo: " + String.valueOf(code),
                                Toast.LENGTH_LONG).show();
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


