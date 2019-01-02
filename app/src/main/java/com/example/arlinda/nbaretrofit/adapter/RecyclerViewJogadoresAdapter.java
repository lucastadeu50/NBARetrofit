package com.example.arlinda.nbaretrofit.adapter;

import android.content.Context;
import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.example.arlinda.nbaretrofit.model.stats.Latest;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewJogadoresAdapter extends RecyclerView.Adapter<RecyclerViewJogadoresAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewJogadoresAd";




    private Context context;
    private ArrayList<Standard> standardArrayList = new ArrayList<>();
    private ArrayList<Latest> latestArrayList = new ArrayList<>();

    public RecyclerViewJogadoresAdapter(Context context, ArrayList<Standard> standardArrayList, ArrayList<Latest> latestArrayList) {
        this.context = context;
        this.standardArrayList = standardArrayList;
        this.latestArrayList = latestArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String playerId = standardArrayList.get(position).getPersonId();
        String teamId = standardArrayList.get(position).getTeamId();
        String url = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/"+ teamId +"/2018/260x190/"+ playerId +".png";
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(context)
             .asBitmap()
             .load(url)
              .into(holder.imageViewAvatar);

        holder.textViewFirstName.setText(standardArrayList.get(position).getFirstName());
        holder.textViewLastName.setText(standardArrayList.get(position).getLastName());
        holder.textViewPPG.setText(latestArrayList.get(position).getPpg());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "sdfgd", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return standardArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewAvatar;
        TextView textViewFirstName;
        TextView textViewLastName;
        TextView textViewPPG;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewPPG = itemView.findViewById(R.id.textViewPPG);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
