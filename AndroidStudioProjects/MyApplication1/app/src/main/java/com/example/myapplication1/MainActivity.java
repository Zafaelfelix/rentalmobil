package com.example.myapplication1;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        radio1=findViewById(R.id.radio1);
        radio2=findViewById(R.id.radio2);
        radio3=findViewById(R.id.radio3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void showText(View view) {
        String np = editText.getText().toString();
        String pilih=" ";
        if (radio1.isChecked()){
            pilih = "Telp Rumah";
        } else if (radio2.isChecked()){
            pilih = "Mobile";
        } else if (radio3.isChecked()){
            pilih = "Telp Kantor";
        }

        Toast.makeText(this, pilih + ":" + np, Toast.LENGTH_SHORT).show();

    }
}