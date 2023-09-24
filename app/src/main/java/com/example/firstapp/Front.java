package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Front extends AppCompatActivity {


    EditText name;
    Button start;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);
        name=findViewById(R.id.editTextText);
        start=(Button) findViewById(R.id.button);

        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String na = name.getText().toString();

                String s = start.getText().toString();
                start.setText(s);

                if(na.isEmpty()) {

                    Toast.makeText(Front.this, "Please Enter Your name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent =new Intent(Front.this, MainActivity2.class);
                    startActivity(intent);
                }

            }
        });
    }
}