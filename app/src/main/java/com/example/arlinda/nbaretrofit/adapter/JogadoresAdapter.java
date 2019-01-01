package com.example.arlinda.nbaretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.model.player.Standard;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class JogadoresAdapter extends ArrayAdapter<Standard> {
    private ArrayList<Standard> standards;
    public JogadoresAdapter(@NonNull Context context, List<Standard> standards) {

        super(context,0, standards);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Standard standard = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_jogadores_adapter, parent, false);
        TextView textViewLastName = convertView.findViewById(R.id.textViewLastName);
        TextView textViewFirstName = convertView.findViewById(R.id.textViewFirstName);
        ImageView imageViewAvatar = convertView.findViewById(R.id.imageViewAvatar);

        textViewLastName.setText(standard.getLastName());
        textViewFirstName.setText(standard.getFirstName());
        String playerId = standard.getPersonId();
        String teamId = standard.getTeamId();
        String url = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/"+ teamId +"/2018/260x190/"+ playerId +".png";
        ImageLoader imageLoader= ImageLoader.getInstance();

        imageLoader.displayImage(url, imageViewAvatar);


        return convertView;
    }

}
