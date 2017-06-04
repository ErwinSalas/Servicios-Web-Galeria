package com.example.pavilion.lab4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.pavilion.lab4.Backend.Pais;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavilion on 29/5/2017.
 */
public class ListViewCustomAdapter extends ArrayAdapter<Pais> {

    private final Activity context;
    private List<Pais> properties;


    public ListViewCustomAdapter(Activity context, List<Pais> properties) {
        super(context, R.layout.list_item, properties);
        this.context = context;
        this.properties = properties;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);


        TextView name = (TextView) rowView.findViewById(R.id.textViewNombre);
        TextView direccion = (TextView) rowView.findViewById(R.id.textViewAlpha2);
        TextView description = (TextView) rowView.findViewById(R.id.textViewAlpha3);



        name.setText(properties.get(position).getName());
        description.setText(properties.get(position).getAlpha2_code());
        direccion.setText(properties.get(position).getAlpha3_code());


        return rowView;
    }
}