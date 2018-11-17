package com.example.diak.dolgozatsharepreference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private TextView TextView_nev;
    private Button Button_kovetkezoActivity, Button_nevValtoztatas, Button_informacio, Button_kilepes;

    private String nev;

    private DialogInterface.OnClickListener dialogOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();

        final SharedPreferences sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);
        nev = sharedPreferences.getString("nev", TextView_nev.getText().toString());
        TextView_nev.setText(nev);

        Button_kovetkezoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kovetkezoActivity = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(kovetkezoActivity);
                finish();
            }
        });

        Button_nevValtoztatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nevValtoztatas = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(nevValtoztatas);
                finish();
            }
        });

        Button_informacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "A neved: " + nev, Toast.LENGTH_SHORT).show();
            }
        });

        Button_kilepes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage("Biztos kilépsz?\n\n" + "Biztosan ki akarsz lépni a programból?");
                builder.setPositiveButton("FOLYTATOM",dialogOnClickListener);
                builder.setNegativeButton("KILÉPEK",dialogOnClickListener).show();
            }
        });
    }

    public void init(){
        TextView_nev = (TextView) findViewById(R.id.TextView_nev);
        Button_kovetkezoActivity = (Button) findViewById(R.id.Button_kovetkezoActivity);
        Button_nevValtoztatas = (Button) findViewById(R.id.Button_nevValtoztatas);
        Button_informacio = (Button) findViewById(R.id.Button_informacio);
        Button_kilepes = (Button) findViewById(R.id.Button_kilepes);
    }
}
