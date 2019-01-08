package com.example.arlinda.nbaretrofit.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.arlinda.nbaretrofit.animanddrawer.DropDownAnim;
import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.example.arlinda.nbaretrofit.model.stats.Latest;
import com.google.android.material.card.MaterialCardView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static java.lang.StrictMath.abs;

public class RecyclerViewJogadoresAdapter extends RecyclerView.Adapter<RecyclerViewJogadoresAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewJogadoresAd";

    private Context context;
    private ArrayList<Standard> standardArrayList = new ArrayList<>();
    private ArrayList<Latest> latestArrayList = new ArrayList<>();

    public RecyclerViewJogadoresAdapter(Context context, ArrayList<Latest> latestArrayList, ArrayList<Standard> standardArrayList) {
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

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(Calendar.getInstance().getTime());
        String dob = standardArrayList.get(position).getDateOfBirthUTC();

        Date datetoday = null;
        try {
            datetoday = sdf.parse(dob);
            Calendar caltoday = Calendar. getInstance();
            caltoday.setTime(datetoday);
            caltoday.get(Calendar.YEAR);
            Date datedob = sdf.parse(today);
            Calendar caldob = Calendar. getInstance();
            caldob.setTime(datedob);
            int age = abs(caltoday.get(Calendar.YEAR) - caldob.get(Calendar.YEAR));
            if (caltoday.get(Calendar.DAY_OF_YEAR) > caldob.get(Calendar.DAY_OF_YEAR)){
                age--;
                }
            holder.textViewDateOfBirth.setText("Age: " + age);
            } catch (ParseException e) {
            e.printStackTrace();
        }

        Double defRebPG;
        Double offRebPG;
        if (latestArrayList.get(position).getGamesPlayed() !=null || latestArrayList.get(position).getOffReb() !=null ||
                latestArrayList.get(position).getDefReb()!=null)
                {
             defRebPG = Double.valueOf(latestArrayList.get(position).getDefReb())/Double.valueOf(latestArrayList.get(position).getGamesPlayed());
                    defRebPG = (double) Math.round(defRebPG * 10) / 10;

                }
            else{
                     defRebPG = null;
                }

        if (latestArrayList.get(position).getGamesPlayed() !=null || latestArrayList.get(position).getOffReb() !=null ||
                latestArrayList.get(position).getDefReb()!=null)
        {
            offRebPG = Double.valueOf(latestArrayList.get(position).getOffReb())/Double.valueOf(latestArrayList.get(position).getGamesPlayed());
            offRebPG = (double) Math.round(offRebPG * 10) / 10;

        }
        else{
            offRebPG = null;
        }




        String playerId = standardArrayList.get(position).getPersonId();
        String teamId = standardArrayList.get(position).getTeamId();
        String url = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/"+ teamId +"/2018/260x190/"+ playerId +".png";
     Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(context)
             .asBitmap()
             .load(url)
              .into(holder.imageViewAvatar);




        // Image Loader
       /* int defaultImage = context.getResources().getIdentifier("@drawable/ic_close_black_24dp",null,context.getPackageName());
        ImageLoader imageLoader =  ImageLoader.getInstance();
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();
        imageLoader.displayImage(url, holder.imageViewAvatar, options);
        */


        holder.textViewFirstName.setText(standardArrayList.get(position).getFirstName());
        holder.textViewLastName.setText(standardArrayList.get(position).getLastName());
        holder.textViewHeight.setText("Height: "+ standardArrayList.get(position).getHeightFeet());
        holder.textViewJersey.setText(standardArrayList.get(position).getJersey());
        holder.textViewPos.setText("Pos: " + standardArrayList.get(position).getPos());
        holder.textViewPoints.setText(latestArrayList.get(position).getPpg());
        holder.textViewGames.setText(latestArrayList.get(position).getGamesPlayed());
        holder.textViewMinutes.setText(latestArrayList.get(position).getMpg());
        holder.textViewAssists.setText(latestArrayList.get(position).getApg());
        holder.textViewSteals.setText(latestArrayList.get(position).getSpg());
        holder.textViewBlocks.setText(latestArrayList.get(position).getBpg());
        holder.textViewFGpercentage.setText(latestArrayList.get(position).getFgp());
        holder.textViewFTA.setText(latestArrayList.get(position).getFta());
        holder.textViewFTM.setText(latestArrayList.get(position).getFtm());
        holder.textViewFTpercentage.setText(latestArrayList.get(position).getFtp());
        holder.textView3PM.setText(latestArrayList.get(position).getTpm());
        holder.textView3Ppercentage.setText(latestArrayList.get(position).getTpp());
        holder.textViewRebounding.setText(latestArrayList.get(position).getRpg());
        holder.textViewDefReb.setText(String.valueOf(defRebPG));
        holder.textViewOffReb.setText(String.valueOf(offRebPG));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WindowManager windowmanager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
                DisplayMetrics dimension = new DisplayMetrics();
                windowmanager.getDefaultDisplay().getMetrics(dimension);
                final int height = dimension.heightPixels;
                boolean down;
                int targetHeightUp = 487;
                int targetHeightDown = 160;
                if (view.getHeight() == targetHeightUp){
                    down = false;
                }
                else{
                    down = true;
                }
                DropDownAnim dropDownAnim = new DropDownAnim(view, targetHeightUp, targetHeightDown,down);
                dropDownAnim.setDuration(1000);
                dropDownAnim.initialize(view.getWidth(), view.getHeight(), view.getWidth(), height);
                view.startAnimation(dropDownAnim);


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
        TextView textViewPoints;
        TextView textViewGames;
        TextView textViewMinutes;
        TextView textViewAssists;
        TextView textViewSteals;
        TextView textViewBlocks;
        TextView textViewFGpercentage;
        TextView textViewFTA;
        TextView textViewFTM;
        TextView textViewFTpercentage;
        TextView textView3PM;
        TextView textView3Ppercentage;
        TextView textViewRebounding;
        TextView textViewOffReb;
        TextView textViewDefReb;



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
            textViewPoints = itemView.findViewById(R.id.textViewPoints);
            textViewGames = itemView.findViewById(R.id.textViewGames);
            textViewMinutes = itemView.findViewById(R.id.textViewMinutes);
            textViewAssists = itemView.findViewById(R.id.textViewAssists);
            textViewSteals = itemView.findViewById(R.id.textViewSteals);
            textViewBlocks = itemView.findViewById(R.id.textViewBlocks);
            textViewFGpercentage = itemView.findViewById(R.id.textViewFG);
            textViewFTA = itemView.findViewById(R.id.textViewFTA);
            textViewFTM = itemView.findViewById(R.id.textViewFTM);
            textViewFTpercentage = itemView.findViewById(R.id.textViewFTpercentage);
            textViewRebounding = itemView.findViewById(R.id.textViewRebouding);
            textViewOffReb = itemView.findViewById(R.id.textViewOffReb);
            textViewDefReb = itemView.findViewById(R.id.textViewDefReb);
            textView3PM = itemView.findViewById(R.id.textView3PM);
            textView3Ppercentage = itemView.findViewById(R.id.textView3percentage);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);

            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
