package com.example.diak.dolgozatsharepreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText EditText_nev;
    private Button Button_kuldes;
    private String nev;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        init();

        sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);
        nev = sharedPreferences.getString("nev", EditText_nev.getText().toString());
        EditText_nev.setText(nev);

        Button_kuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(EditText_nev.getText().toString().equals(""))){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nev", EditText_nev.getText().toString());
                    editor.apply();

                    Intent kuldes = new Intent(Main3Activity.this, Main2Activity.class);
                    startActivity(kuldes);
                    finish();

                    Toast.makeText(Main3Activity.this, "Neved mentve!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Main3Activity.this, "Nem írtál be nevet!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){
        EditText_nev = (EditText) findViewById(R.id.EditText_nev);
        Button_kuldes = (Button) findViewById(R.id.Button_kuldes);
    }
}
