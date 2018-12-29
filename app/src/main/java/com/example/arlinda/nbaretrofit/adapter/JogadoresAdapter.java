package com.example.arlinda.nbaretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.arlinda.nbaretrofit.R;
import com.example.arlinda.nbaretrofit.model.Standard;

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

        textViewLastName.setText(standard.getLastName());
        textViewFirstName.setText(standard.getFirstName());

        return convertView;
    }

}
