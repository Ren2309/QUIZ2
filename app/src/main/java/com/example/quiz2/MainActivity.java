package com.example.quiz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


    public class MainActivity extends AppCompatActivity {

        private RadioGroup radioGroupConsole, radioGroupFood;
        private EditText editTextTime;
        private Button buttonPesan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            radioGroupConsole = findViewById(R.id.radioGroupConsole);
            radioGroupFood = findViewById(R.id.radioGroupFood);
            editTextTime = findViewById(R.id.editTextTime);
            buttonPesan = findViewById(R.id.buttonpesan);


            buttonPesan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Mendapatkan id radio button terpilih dari setiap radio group
                    int selectedConsoleId = radioGroupConsole.getCheckedRadioButtonId();
                    int selectedFoodId = radioGroupFood.getCheckedRadioButtonId();

                    String waktuBermain = editTextTime.getText().toString();


                    Intent intent = new Intent(com.example.quiz2.MainActivity.this, InvoiceActivity.class);

                    intent.putExtra("selectedConsole", getSelectedConsole(selectedConsoleId));
                    intent.putExtra("selectedFood", getSelectedFood(selectedFoodId));
                    intent.putExtra("waktuBermain", waktuBermain);

                    startActivity(intent);
                }
            });
        }


        private String getSelectedConsole(int id) {
            RadioButton radioButton = findViewById(id);
            if (radioButton != null) {
                return radioButton.getText().toString();
            }
            return "";
        }


        private String getSelectedFood(int id) {
            RadioButton radioButton = findViewById(id);
            if (radioButton != null) {
                return radioButton.getText().toString();
            }
            return "";
        }
    }
