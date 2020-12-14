package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn,btn1;
    TextView tv;
    Spinner spinner;
    List<String> idlist;
    Bundle bundle;
    EditText etusername,etage,etgender,etmail;
    String uname,uage,ugender,umail;
//test jenkins on monday testing again 2.55pm
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.loginBtn);
        etusername=findViewById(R.id.usernameET);
        etgender=findViewById(R.id.genderET);
        etage=findViewById(R.id.ageET);
        etmail=findViewById(R.id.usermaildET);
        bundle=new Bundle();
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        btn.setOnClickListener(view -> {
            uname=etusername.getText().toString().trim();
//            ugender= String.valueOf(etgender.getText().toString().charAt(0));
            uage=etage.getText().toString().trim();
            umail=etmail.getText().toString().trim();

            if(uname.isEmpty() && uage.isEmpty()){
                Toast.makeText(this, "Please fill fields", Toast.LENGTH_SHORT).show();
            } else if(!(uname.length()>=5 && uname.length()<=20)){
                etusername.setError("Enter atleast 5 words ");
                etusername.requestFocus();
            } else if(!(uage.length()==2)){
                etage.setError("Enter atleast 2 numbers ");
                etage.requestFocus();
            } else if(!(umail.contains("@gmail.com"))) {
                etmail.setError("Enter Valid Email id");
                etmail.requestFocus();
            }
            else {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            bundle.putString("name",uname);
            bundle.putString("age",uage);
            bundle.putString("gender",ugender);
            intent.putExtras(bundle);
            startActivity(intent);
            }
        });
}


}