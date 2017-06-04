package com.example.pavilion.lab4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavilion.lab4.Backend.Galeries;
import com.example.pavilion.lab4.Backend.Galery;

import java.util.ArrayList;

public class CreateActivity extends AppCompatActivity {
    String contryName;
    TextView labelName;
    FloatingActionButton btnCamera,btnBack;
    LinearLayout container;
    Galery photos;
    int cont;
    public final int REQUEST_IMAGE_CAPTURE= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        btnCamera = (FloatingActionButton) findViewById(R.id.btnCam);
        btnBack = (FloatingActionButton) findViewById(R.id.btnBack);
        labelName = (TextView) findViewById(R.id.textViewNameCountry);
        container =  (LinearLayout) findViewById(R.id.container);
        cont = 0;
        Bundle b = getIntent().getExtras();
        if(b != null) {
            contryName=b.getString("name");
            photos=Galeries.getInstance().searchGalery(contryName);
            if (photos==null){
                photos=new Galery(contryName,new ArrayList<Bitmap>());
            }
            labelName.setText(contryName);

        }
        loadGalery();
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callIntent();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeIntent();
            }
        });


    }
    public void callIntent(){
        Intent cameraView = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraView.resolveActivity(getPackageManager())!=null){
            startActivityForResult(cameraView,REQUEST_IMAGE_CAPTURE);

        }
    }
    public void closeIntent(){
        this.finish();
    }
    public void updateGalery(){
        Galeries.getInstance().update(photos);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            if (photos!=null){
                photos.addPhoto(imageBitmap);

            }
            loadImageInView(imageBitmap);



        }
    }
    public void loadImageInView(Bitmap img){
        ImageView imageView = new ImageView(this);
        imageView.setMaxWidth(100);
        imageView.setMaxHeight(100);
        imageView.setImageBitmap(img);
        imageView.setPadding(10,5,10,5);
        container.addView(imageView);
        updateGalery();
    }
    public void loadGalery(){
        if (photos!=null){
            for(Bitmap bmap: photos.getImages()){
                ImageView imageView = new ImageView(this);
                imageView.setMaxWidth(100);
                imageView.setMaxHeight(100);
                imageView.setImageBitmap(bmap);
                imageView.setPadding(10,5,10,5);
                container.addView(imageView);
            }
        }

    }


}
