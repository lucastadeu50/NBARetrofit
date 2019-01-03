package com.example.arlinda.nbaretrofit.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.arlinda.nbaretrofit.DropDownAnim;
import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.example.arlinda.nbaretrofit.model.stats.Latest;
import com.google.android.material.card.MaterialCardView;

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
        DropDownAnim dropDownAnim = new DropDownAnim(view, 200, false);
        dropDownAnim.initialize(view.getWidth(), view.getHeight(), view.getWidth(), view.getHeight()+200);
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
        holder.textViewDateOfBirth.setText(standardArrayList.get(position).getDateOfBirthUTC());
        holder.textViewHeight.setText("Height: "+ standardArrayList.get(position).getHeightFeet());
        holder.textViewJersey.setText(standardArrayList.get(position).getJersey());
        holder.textViewPos.setText("Pos: " + standardArrayList.get(position).getPos());

        //  holder.te.setText(latestArrayList.get(position).getPpg());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, String.valueOf(view.getWidth()), Toast.LENGTH_SHORT).show();
                DropDownAnim dropDownAnim = new DropDownAnim(view, 200, false);
              //
                // dropDownAnim.setDuration(500);
                dropDownAnim.initialize(view.getWidth(), view.getHeight(), view.getWidth(), view.getHeight()+200);

                view.startAnimation(dropDownAnim);
              //  dropDownAnim.setDuration(500);
              //  dropDownAnim.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return standardArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textViewLastName;
        TextView textViewFirstName;
        TextView textViewPos;
        TextView textViewDateOfBirth;
        TextView textViewHeight;
        TextView textViewJersey;
        ImageView imageViewAvatar;
        MaterialCardView parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            textViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            textViewLastName = itemView.findViewById(R.id.textViewLastName);
            textViewPos = itemView.findViewById(R.id.textViewPos);
            textViewDateOfBirth = itemView.findViewById(R.id.textViewDateOfBirth);
            textViewHeight = itemView.findViewById(R.id.textViewHeight);
            textViewJersey = itemView.findViewById(R.id.textViewJersey);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);

            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
