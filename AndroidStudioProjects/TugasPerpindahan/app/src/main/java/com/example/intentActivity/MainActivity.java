package com.example.intentActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.btnMove);
        Button btnShare = findViewById(R.id.btnshare);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity . class));
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent Implicit untuk share ke sosial media
                Intent intent = new Intent(Intent.ACTION_SEND);

                // Membawa data / pesan yang ingin di-share
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo saya share ke sosial media");
                intent.setType("text/plain");

                startActivity(Intent.createChooser(intent, "Share to:"));
            }
        });
    }
}
