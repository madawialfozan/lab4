package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.lab4.DataBaseHelper;
import com.example.lab4.R;
import com.example.lab4.StudentMod;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // make a reference to buttons
    Button btn_add;
    EditText et_name, et_age;
    Switch sw_active;

    ArrayAdapter studentArrayAdapter;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         // on create, give value
         btn_add = findViewById(R.id.btn_add);
         et_age = findViewById(R.id.et_age);
         et_name = findViewById(R.id.et_name);
         sw_active = findViewById(R.id.sw_active);


         btn_add.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 // create model

                 StudentMod studentMod;
                 try {
                     studentMod = new StudentMod(0, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()), sw_active.isChecked());
                     DataBaseHelper dbh = new DataBaseHelper(MainActivity.this);
                     Boolean b = dbh.addOne(studentMod);
                     Toast.makeText(MainActivity.this, studentMod.toString(), Toast.LENGTH_SHORT).show();

                 } catch (Exception e) {
                     studentMod = new StudentMod(-1, "ERROR", 0, false);
                     Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();

                 }


             }
         });
     }}
