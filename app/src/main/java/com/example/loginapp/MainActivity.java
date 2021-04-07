package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView nameTV, addressTV, accountNoTV, createBT;
    EditText nameET, addressET;
    Button clickBT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTV = findViewById(R.id.nameTV);
        addressTV = findViewById(R.id.addressTV);
        nameET = findViewById(R.id.nameET);
        addressET = findViewById(R.id.addressET);
        clickBT = findViewById(R.id.clickBT);
        accountNoTV = findViewById(R.id.accountNoTV);
        createBT = findViewById(R.id.createBT);

        clickBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(MainActivity.this, ClickActivity.class);
                in.putExtra("NAME",nameET.getText());
                int pass =Integer.valueOf(addressET.getText().toString());
                in.putExtra("PASSWORD",pass);
                startActivity(in);
                //Toast.makeText(getApplicationContext(), "Hello" + " " + nameET.getText() + " , " + addressET.getText(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        createBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Account creation option is under construction ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}