package com.example.arlinda.nbaretrofit.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.control.ListaJogadoresActivity;
import com.example.arlinda.nbaretrofit.model.team.Team;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;



public class RecyclerViewTeamsAdapter extends RecyclerView.Adapter<RecyclerViewTeamsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Team> teamList = new ArrayList<>();

    public RecyclerViewTeamsAdapter(Context context, ArrayList<Team>  teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_teams, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewTeamsAdapter.ViewHolder holder, final int position) {

        // Image Loader
       int defaultImage = context.getResources().getIdentifier("@drawable/ic_close_black_24dp",null,context.getPackageName());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader.getInstance().init(config);
        ImageLoader imageLoader =  ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();
        imageLoader.displayImage(teamList.get(position).getImgURL(), holder.cardImage, options);



        holder.cardTitle.setText(teamList.get(position).getTeamName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ListaJogadoresActivity.class);
                intent.putExtra("teamid", teamList.get(position).getTeamId());
                context.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView cardTitle;
        ImageView cardImage;
        ConstraintLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            cardTitle= itemView.findViewById(R.id.cardTitle);

            cardImage = itemView.findViewById(R.id.cardImage);

            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
    public void filterList(ArrayList<Team> filteredList) {
        teamList = filteredList;
        notifyDataSetChanged();
    }
}
