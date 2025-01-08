package com.example.myresep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {
    // Variabel untuk komponen UI
    ListView listView;
    String[] mTitle = {"Facebook", "Whatsapp", "Instagram"};
    String[] mDescription = {"zafael", "082336422422", "yapaelll"};
    int[] images = {R.drawable.facebook, R.drawable.whatsapp, R.drawable.instagram};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Inisialisasi ListView
        listView = findViewById(R.id.ListView);

        // Mengatur adapter untuk ListView
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
    }

    // Metode untuk kembali ke halaman utama
    public void hal_utama(View view) {
        Intent intent = new Intent(ContactActivity.this, MainActivity.class);
        startActivity(intent);
    }

    // Kelas Adapter untuk ListView
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] rTitle;
        String[] rDescription;
        int[] rImgs;

        // Konstruktor
        MyAdapter(Context c, String[] title, String[] description, int[] imgs) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Mengatur LayoutInflater
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.row, parent, false);

            // Inisialisasi komponen dari row.xml
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // Menampilkan data pada row
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            // Menambahkan klik listener untuk membuka media sosial
            row.setOnClickListener(view -> {
                String url = "";

                // Menentukan URL berdasarkan pilihan
                switch (rTitle[position]) {
                    case "Facebook":
                        url = "https://www.facebook.com/share/15ocsc5cRk/?mibextid=wwXIfr";
                        break;
                    case "Whatsapp":
                        url = "https://wa.me/+6282336422422";
                        break;
                    case "Instagram":
                        url = "https://www.instagram.com/yapaelll?igsh=MTZxcXB6cGxlMmN0Yg%3D%3D&utm_source=qr";
                        break;
                    default:
                        break;
                }
                if (!url.isEmpty()) {
                    // Intent untuk membuka URL
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(android.net.Uri.parse(url));  // Menggunakan URL yang sudah ditentukan
                    context.startActivity(intent);
                }
            });

            return row;
        }
    }
}
