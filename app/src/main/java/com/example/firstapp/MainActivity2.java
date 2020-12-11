package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Bundle bundle;
    String uname,uage,ugender;
    TextView tvwelocme;
    Button btnshow,btnhide;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        bundle=getIntent().getExtras();
        if(bundle!=null){
        uname=bundle.getString("name");
        uage=bundle.getString("age");
        ugender=bundle.getString("gender");}
        else{
            Log.i("yes", "onCreate");
        }
        tvwelocme=findViewById(R.id.welcomeTV);
        btnshow=findViewById(R.id.showBtn);
        btnhide=findViewById(R.id.hideBtn);
        radioGroup=findViewById(R.id.radioGroup);

        btnshow.setOnClickListener(view -> {
            tvwelocme.setText("Hi welcome to Facebook"+"  "+uname);
            tvwelocme.setVisibility(View.VISIBLE);
        });

        btnhide.setOnClickListener(view -> {

            tvwelocme.setVisibility(View.GONE);
        });


        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {

            switch (i){
                case R.id.maleradiBtn:
                    Toast.makeText(this, "Male Selected", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.femaleradiBtn:
                    Toast.makeText(this, "Female Selected", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

    }
}