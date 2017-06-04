package com.example.pavilion.lab4;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavilion.lab4.Backend.ConnectionManager;
import com.example.pavilion.lab4.Backend.Data;
import com.example.pavilion.lab4.Backend.Galeries;
import com.example.pavilion.lab4.Backend.Galery;
import com.example.pavilion.lab4.Backend.MainInterface;
import com.example.pavilion.lab4.Backend.Pais;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Data datos;
    ListView list;
    ListViewCustomAdapter adapter;
    ConnectionManager cnManager;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        cnManager=new ConnectionManager();
        //Log.v(TAG,datos.toString());
         list = (ListView) findViewById(R.id.listView);
        getAllCouuntries();

    }

    public void getAllCouuntries(){
        Call<Data> call = cnManager.getMainInterface().getCountries();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                inflateList(response.body().getRestResponse().getResult());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "falla", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void inflateList(ArrayList<Pais> data){
        adapter=new ListViewCustomAdapter(this,data);
        this.list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
                Bundle b = new Bundle();
                TextView txt =  (TextView) view.findViewById(R.id.textViewNombre);
                String name =  txt.getText().toString();
                b.putString("name", name);
                intent.putExtras(b);
                startActivity(intent);

            }
        });


    }
}
