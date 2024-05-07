package com.example.quiz2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class InvoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);


        TextView textViewDeskripsi = findViewById(R.id.deskripsi);


        Intent intent = getIntent();
        String selectedConsole = intent.getStringExtra("selectedConsole");
        String selectedFood = intent.getStringExtra("selectedFood");
        String waktuBermain = intent.getStringExtra("waktuBermain");


        int hargaConsole = 0;
        if (selectedConsole.equals("PS5")) {
            hargaConsole = 10000;
        } else if (selectedConsole.equals("PS4")) {
            hargaConsole = 8000;
        } else if (selectedConsole.equals("PS3")) {
            hargaConsole = 5000;
        } else if (selectedConsole.equals("PSVR")) {
            hargaConsole = 20000;
        }

        // Menetapkan harga untuk setiap jenis makanan
        int hargaFood = 0;
        if (selectedFood.equals("Indomie")) {
            hargaFood = 7000;
        } else if (selectedFood.equals("Mie Ayam")) {
            hargaFood = 10000;
        } else if (selectedFood.equals("Somay")) {
            hargaFood = 5000;
        }

        int waktuBermainInt = Integer.parseInt(waktuBermain);
        int totalHarga = (hargaConsole + hargaFood) * waktuBermainInt;


        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        String totalHargaRupiah = formatRupiah.format(totalHarga);


        String deskripsi = "Anda telah memilih PlayStation " + selectedConsole + " dengan tambahan " + selectedFood +
                ". Anda akan bermain selama " + waktuBermain + " jam.\n\n" +
                "Harga PlayStation per Jam: " + formatRupiah.format(hargaConsole) + "\n" +
                "Harga Makanan: " + formatRupiah.format(hargaFood) + "\n" +
                "Total Harga: " + totalHargaRupiah;


        textViewDeskripsi.setText(deskripsi);
    }
}
