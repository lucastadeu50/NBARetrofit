package com.example.arlinda.nbaretrofit.control;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;


import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.adapter.RecyclerViewTeamsAdapter;
import com.example.arlinda.nbaretrofit.animanddrawer.VerticalSpaceItemDecoration;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.example.arlinda.nbaretrofit.model.team.Team;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    Standard standard;
    private RecyclerViewTeamsAdapter adapter;
    private TextInputEditText textInputEditText;
    final ArrayList<Team> teamList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        recyclerView = findViewById(R.id.recyclerViewTeams);

        textInputEditText = findViewById(R.id.textFieldSearch);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(20));
        recyclerView.requestFocus();


        addTeamListt();

        adapter = new RecyclerViewTeamsAdapter(Main3Activity.this, teamList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Main3Activity.this));



        /**
         * Adiciona um listener para capturar qualer caractere digitado na barra de pesquisa
         */

        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<Team> filteredList = new ArrayList<>();
                filter(s.toString());

            }
        });

    }

    /**
     * Metodo identifica se a string digita pelo usuario esta presente na lista de times
     * @param text string a ser pesquisada
     */

    private void filter(String text) {
        ArrayList<Team> filteredList = new ArrayList<>();

        for (Team item : teamList) {
            if (item.getTeamName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
    /**
     * Adiciona todos os times a lista de times, junto com teamid e a logo do time
     */
    public void addTeamListt() {

        Team atlanta_hawks = new Team("1610612737", "Atlanta Hawks",
                "drawable://" + R.drawable.atl_logo);

        Team charlotte_hornets = new Team("1610612766", "Charlotte Hornets",
                "drawable://" + R.drawable.cha_logo);

        Team detroit_pistons = new Team("1610612765", "Detroit Pistons",
                "drawable://" + R.drawable.det_logo);

        Team brooklyn_nets = new Team("1610612765", "Brooklyn Nets",
                "drawable://" + R.drawable.bkn_logo);


        Team boston_celtics = new Team("1610612738", "Boston Celtics",
                "drawable://" + R.drawable.bos_logo);

        Team chicago_bulls = new Team("1610612741", "Chicago Bulls",
                "drawable://" + R.drawable.chi_logo);

        Team cleveland_cavaliers = new Team("1610612739", "Cleveland Cavaliers",
                "drawable://" + R.drawable.cle_logo);

        Team dallas_mavericks = new Team("1610612742", "Dallas Mavericks",
                "drawable://" + R.drawable.dal_logo);

        Team denver_nuggets = new Team("1610612743", "Denver Nuggets",
                "drawable://" + R.drawable.den_logo);

        Team houston_rockets = new Team("1610612745", "Houston Rockets",
                "drawable://" + R.drawable.hou_logo);


        Team golden_state_warriors = new Team("1610612744", "Golden State Warriors",
                "drawable://" + R.drawable.gsw_logo);

        Team indiana_pacers = new Team("1610612754", "Indiana Pacers",
                "drawable://" + R.drawable.ind_logo);

        Team la_clippers = new Team("1610612746", "LA Clippers",
                "drawable://" + R.drawable.lac_logo);

        Team los_angeles_lakers = new Team("1610612747", "Los Angeles Lakers",
                "drawable://" + R.drawable.lal_logo);

        Team memphis_grizzlies = new Team("1610612763", "Memphis Grizzlies",
                "drawable://" + R.drawable.mem_logo);

        Team miami_heat = new Team("1610612748", "Miami Heat",
                "drawable://" + R.drawable.mia_logo);

        Team milwaukee_bucks = new Team("1610612749", "Milwaukee Bucks",
                "drawable://" + R.drawable.mil_logo);

        Team minnesota_timberwolves = new Team("1610612750", "Minnesota Timberwolves",
                "drawable://" + R.drawable.min_logo);

        Team new_orleans_pelicans = new Team("1610612740", "New Orleans Pelicans",
                "drawable://" + R.drawable.nop_logo);

        Team new_york_knicks = new Team("1610612752", "New York Knicks",
                "drawable://" + R.drawable.nyk_logo);

        Team oklahoma_city_thunder = new Team("1610612760", "Oklahoma City Thunder",
                "drawable://" + R.drawable.okc_logo);

        Team orlando_magic = new Team("1610612753", "Orlando Magic",
                "drawable://" + R.drawable.orl_logo);

        Team philadelphia_76ers = new Team("1610612755", "Philadelphia 76ers",
                "drawable://" + R.drawable.phi_logo);

        Team phoenix_suns = new Team("1610612756", "Phoenix Suns",
                "drawable://" + R.drawable.phx_logo);

        Team portland_trail_blazers = new Team("1610612757", "Portland Trail Blazers",
                "drawable://" + R.drawable.por_logo);

        Team sacramento_kings = new Team("1610612758", "Sacramento Kings",
                "drawable://" + R.drawable.sac_logo);

        Team san_antonio_spurs = new Team("1610612759", "San Antonio Spurs",
                "drawable://" + R.drawable.sas_logo);

        Team toronto_raptors = new Team("1610612761", "Toronto Raptors",
                "drawable://" + R.drawable.tor_logo);

        Team utah_jazz = new Team("1610612762", "Utah Jazz",
                "drawable://" + R.drawable.uta_logo);

        Team washington_wizards = new Team("1610612764", "Washington Wizards",
                "drawable://" + R.drawable.was_logo);


        teamList.add(atlanta_hawks);
        teamList.add(boston_celtics);
        teamList.add(brooklyn_nets);
        teamList.add(charlotte_hornets);
        teamList.add(chicago_bulls);
        teamList.add(cleveland_cavaliers);
        teamList.add(dallas_mavericks);
        teamList.add(denver_nuggets);
        teamList.add(detroit_pistons);
        teamList.add(golden_state_warriors);
        teamList.add(houston_rockets);
        teamList.add(indiana_pacers);
        teamList.add(la_clippers);
        teamList.add(los_angeles_lakers);
        teamList.add(memphis_grizzlies);
        teamList.add(miami_heat);
        teamList.add(milwaukee_bucks);
        teamList.add(minnesota_timberwolves);
        teamList.add(new_orleans_pelicans);
        teamList.add(new_york_knicks);
        teamList.add(oklahoma_city_thunder);
        teamList.add(orlando_magic);
        teamList.add(philadelphia_76ers);
        teamList.add(portland_trail_blazers);
        teamList.add(phoenix_suns);
        teamList.add(sacramento_kings);
        teamList.add(san_antonio_spurs);
        teamList.add(toronto_raptors);
        teamList.add(utah_jazz);
        teamList.add(washington_wizards);

    }
}
