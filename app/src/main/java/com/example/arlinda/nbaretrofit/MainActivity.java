package com.example.arlinda.nbaretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.arlinda.nbaretrofit.adapter.TeamsAdapter;
import com.example.arlinda.nbaretrofit.model.Feed;
import com.example.arlinda.nbaretrofit.model.Standard;
import com.example.arlinda.nbaretrofit.model.Team;

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
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.listViewTeams);

        Team atlanta_hawks = new Team("1610612737", "Atlanta Hawks",
                "drawable://" + R.drawable.ic_atl_logo);
        Team charlotte_hornets = new Team("1610612766", "Charlotte Hornets",
                "drawable://" + R.drawable.ic_cha_logo);
        Team detroit_pistons = new Team("1610612765", "Detroit Pistons",
                "drawable://" + R.drawable.ic_det_logo);



        ArrayList<Team> teamList = new ArrayList<>();


        //Add the Person objects to an ArrayList
        teamList.add(atlanta_hawks);
        teamList.add(charlotte_hornets);
        teamList.add(detroit_pistons);


        TeamsAdapter adapter = new TeamsAdapter(this, R.layout.activity_teams_adapter, teamList);
        mListView.setAdapter(adapter);


        //   CardView cardViewHawk = findViewById(R.id.cardViewHawk);


        //   cardViewHawk.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //    public void onClick(View v) {
        //           Intent intent = new Intent(MainActivity.this, ListaJogadoresActivity.class);
        //        startActivity(intent);
        //   }
        // });

    }
}