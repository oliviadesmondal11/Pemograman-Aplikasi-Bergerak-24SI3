package com.mobile.uph24si3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etAngka1, etAngka2;
    Button btnTambah, btnKurang, btnKali, btnBagi;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAngka1 = findViewById(R.id.etAngka1);
        etAngka2 = findViewById(R.id.etAngka2);

        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);

        tvHasil = findViewById(R.id.tvHasil);

        btnTambah.setOnClickListener(v -> hitung("+"));
        btnKurang.setOnClickListener(v -> hitung("-"));
        btnKali.setOnClickListener(v -> hitung("*"));
        btnBagi.setOnClickListener(v -> hitung("/"));
    }

    private void hitung(String operator) {

        String a = etAngka1.getText().toString();
        String b = etAngka2.getText().toString();

        if (a.isEmpty() || b.isEmpty()) {
            tvHasil.setText("Masukkan kedua angka");
            return;
        }

        double angka1 = Double.parseDouble(a);
        double angka2 = Double.parseDouble(b);
        double hasil = 0;

        switch (operator) {
            case "+":
                hasil = angka1 + angka2;
                break;

            case "-":
                hasil = angka1 - angka2;
                break;

            case "*":
                hasil = angka1 * angka2;
                break;

            case "/":
                if (angka2 == 0) {
                    tvHasil.setText("Tidak bisa dibagi 0");
                    return;
                }
                hasil = angka1 / angka2;
                break;
        }

        tvHasil.setText("Hasil: " + hasil);
    }
}