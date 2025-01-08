package com.example.myresep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SewaMobilActivity extends AppCompatActivity {
    // Variabel global
    int harga_sewa_mobil, jml_lmsw, ttl_hargasewa, jml_uang;
    String s_nama;

    Spinner ad_listmobil;
    TextView harga_mobil;
    EditText lama_sewa, uangbayar, nama_penyewa;

    String[] list_mobil = {"Toyota", "Avanza", "Xenia", "Pajero", "Fortuner"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_mobil);

        // Inisialisasi View
        nama_penyewa = findViewById(R.id.nama_penyewa);
        ad_listmobil = findViewById(R.id.ad_listmobil);
        harga_mobil = findViewById(R.id.harga_mobil);
        lama_sewa = findViewById(R.id.lama_sewa);
        uangbayar = findViewById(R.id.uangbayar);

        // Mengatur adapter untuk Spinner
        ArrayAdapter<String> ad_mbl = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                list_mobil
        );
        ad_listmobil.setAdapter(ad_mbl);
    }

    public void tmbl_OK(View view) {
        try {
            // Ambil nilai dari input
            jml_lmsw = Integer.parseInt(lama_sewa.getText().toString());
            s_nama = nama_penyewa.getText().toString();

            // Hitung harga berdasarkan mobil yang dipilih
            switch (ad_listmobil.getSelectedItem().toString()) {
                case "Avanza":
                    harga_sewa_mobil = 300000;
                    break;
                case "Xenia":
                    harga_sewa_mobil = 350000;
                    break;
                case "Pajero":
                    harga_sewa_mobil = 400000;
                    break;
                case "Fortuner":
                    harga_sewa_mobil = 500000;
                    break;
                default:
                    harga_sewa_mobil = 0;
            }

            // Hitung total harga sewa
            ttl_hargasewa = jml_lmsw * harga_sewa_mobil;
            harga_mobil.setText(String.valueOf(ttl_hargasewa));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Harap masukkan data dengan benar", Toast.LENGTH_SHORT).show();
        }
    }

    public void tombol_sewa2(View view) {
        try {
            jml_uang = Integer.parseInt(uangbayar.getText().toString());
            if (jml_uang < ttl_hargasewa) {
                Toast.makeText(this, "Uang kurang", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(SewaMobilActivity.this, StrukActivity.class);

                // Kirim data ke StrukActivity
                intent.putExtra("nama", s_nama);
                intent.putExtra("mobil", ad_listmobil.getSelectedItem().toString());
                intent.putExtra("lama", jml_lmsw);
                intent.putExtra("total", ttl_hargasewa);
                intent.putExtra("uang", jml_uang);
                intent.putExtra("kembalian", jml_uang - ttl_hargasewa);

                startActivity(intent);
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Harap masukkan jumlah uang", Toast.LENGTH_SHORT).show();
        }
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(SewaMobilActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
