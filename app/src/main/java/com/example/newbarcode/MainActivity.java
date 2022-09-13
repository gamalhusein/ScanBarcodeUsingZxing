package com.example.newbarcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView username, password;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();

                if (Username.equals("gamal") && Password.equals("test123")){
                    //Toast.makeText(MainActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                    Intent pindahhalaman = new Intent(MainActivity.this, Front_View.class);
                    startActivity(pindahhalaman);
                } else if (Username.isEmpty()){
                    Toast.makeText(MainActivity.this, "Silahkan Masukkan Username", Toast.LENGTH_SHORT).show();
                }else if(Password.isEmpty()){
                    Toast.makeText(MainActivity.this, "Silahkan Masukkan Password", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Silahkan isi field yang tersedia", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}