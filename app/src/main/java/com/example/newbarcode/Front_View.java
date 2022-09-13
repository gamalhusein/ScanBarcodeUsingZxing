package com.example.newbarcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.provider.FontRequest;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;


public class Front_View extends AppCompatActivity {
    String trial = "";

    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        floatingActionButton = findViewById(R.id.fab);

         getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, new HomeFragment()).commit();


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(Front_View.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Front_View.this, Manifest.permission.CAMERA)){
                        startscan();
                    } else {
                        ActivityCompat.requestPermissions(Front_View.this, new String[]{Manifest.permission.CAMERA}, 0);
                    }
                } else  {
                    startscan();
                }

            }



        });


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment pilihFragment = null ;

                switch (item.getItemId()){
                    case R.id.home:
                        Bundle amat = new Bundle();
                        amat.putString("ee", trial);
                        pilihFragment = new HomeFragment();
                        pilihFragment.setArguments(amat);
                        getSupportFragmentManager().beginTransaction().add(R.id.relativelayout, pilihFragment).commit();
                        break;
                    case R.id.add:
                        pilihFragment = new AddFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, pilihFragment).commit();

                return true;
            }
        });


    }

    private void startscan(){
        Intent intent = new Intent(getApplicationContext(), Scanner.class);
        startActivityForResult(intent,20);

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 20){
            if(resultCode == RESULT_OK && data != null){
               trial = data.getStringExtra("result");

                //Log.d("tag","test :"+data.getStringExtra("result"));
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startscan();
            }else {
                Toast.makeText(this, "Failed To Open Camera", Toast.LENGTH_SHORT).show();
            }
        }

    }
}