package com.example.arlinda.nbaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.arlinda.nbaretrofit.adapter.TeamsAdapter;
import com.example.arlinda.nbaretrofit.model.Team;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity   {
    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "http://data.nba.net/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = (ListView) findViewById(R.id.listViewTeams);

        Team atlanta_hawks = new Team("1610612737", "Atlanta Hawks",
                "drawable://" + R.drawable.atl_logo);
        Team charlotte_hornets = new Team("1610612766", "Charlotte Hornets",
                "drawable://" + R.drawable.ic_cha_logo);
        Team detroit_pistons = new Team("1610612765", "Detroit Pistons",
                "drawable://" + R.drawable.ic_det_logo);
        Team boston_celtics = new Team("1610612738", "Boston Celtics",
                "drawable://" + R.drawable.ic_det_logo);

        Team chicago_bulls = new Team("1610612741", "Chicago Bulls",
                "drawable://" + R.drawable.ic_det_logo);

        Team cleveland_cavaliers = new Team("1610612739", "Cleveland Cavaliers",
                "drawable://" + R.drawable.ic_det_logo);

        Team dallas_mavericks = new Team("1610612742", "Dallas Mavericks",
                "drawable://" + R.drawable.ic_det_logo);

        Team denver_nuggets = new Team("1610612743", "Denver Nuggets",
                "drawable://" + R.drawable.ic_det_logo);

        Team golden_state_warriors = new Team("1610612744", "Golden State Warriors",
                "drawable://" + R.drawable.ic_det_logo);

        Team indiana_pacers = new Team("1610612754", "Indiana Pacers",
                "drawable://" + R.drawable.ic_det_logo);

        Team la_clippers = new Team("1610612746", "LA Clippers",
                "drawable://" + R.drawable.ic_det_logo);

        Team los_angeles_lakers = new Team("1610612747", "Los Angeles Lakers",
                "drawable://" + R.drawable.ic_det_logo);

        Team memphis_grizzlies = new Team("1610612763", "Memphis Grizzlies",
                "drawable://" + R.drawable.ic_det_logo);

        Team miami_heat = new Team("1610612748", "Miami Heat",
                "drawable://" + R.drawable.ic_det_logo);

        Team milwaukee_bucks = new Team("1610612749", "Milwaukee Bucks",
                "drawable://" + R.drawable.ic_det_logo);

        Team minnesota_timberwolves = new Team("1610612750", "Minnesota Timberwolves",
                "drawable://" + R.drawable.ic_det_logo);

        Team new_orleans_pelicans = new Team("1610612740", "New Orleans Pelicans",
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