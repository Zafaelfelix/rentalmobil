package com.example.myresep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Metode untuk tombol "INFORMASI MOBIL"
    public void Tombol_info(View view) {
        Intent intent = new Intent(MainActivity.this, DaftarMobilActivity.class);
        startActivity(intent);
    }

    // Metode untuk tombol "SEWA MOBIL"
    public void tombol_sewa(View view) {
        Intent intent = new Intent(MainActivity.this, SewaMobilActivity.class);
        startActivity(intent);
    }

    // Metode untuk tombol "CONTACT"
    public void tombol_contact(View view) {
        Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        startActivity(intent);
    }
}
