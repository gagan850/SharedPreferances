package com.example.gagandeepbansal.sharedpreferances;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText name;
    EditText password;
    Button save;
    Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText)findViewById(R.id.name);
        password = (EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.save);
        load=(Button)findViewById(R.id.load);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        SharedPreferences preferances;
        SharedPreferences.Editor editor;
        if (v.getId() == R.id.save) {
            preferances = getSharedPreferences("Mydata", Context.MODE_PRIVATE);
            editor = preferances.edit();
            editor.putString("name",name.getText().toString());
            editor.putString("password",password.getText().toString());
            editor.commit();
        } else {

            preferances = getSharedPreferences("Mydata",Context.MODE_PRIVATE);
            String nm = preferances.getString("name","priyanka");
            String psd = preferances.getString("password","mangla");
            name.setText(nm);
            password.setText(psd);
        }
    }
}
