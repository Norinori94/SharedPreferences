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
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText EditText_nev;
    private Button Button_kuldes;
    private SharedPreferences sharedPreferences;
    private String alap;

    private DialogInterface.OnClickListener dialogClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        sharedPreferences = getSharedPreferences("nevek", Context.MODE_PRIVATE);
        alap = "";
        String nev = sharedPreferences.getString("nev", alap);
        EditText_nev.setText(nev);

        dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        kovetkezo();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        EditText_nev.setText(alap);
                        break;
                }
            }
        };


        if(!(EditText_nev.getText().toString().equals(""))){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Üdvözöllek újra " + nev + "!\n\nFolytatod ezen a néven vagy újat akarsz?");
            builder.setPositiveButton("FOLYTATOM", dialogClickListener);
            builder.setNegativeButton("ÚJ JÁTÉK", dialogClickListener).show();
        }

        Button_kuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(EditText_nev.getText().toString().equals(""))){

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nev", EditText_nev.getText().toString());
                    editor.apply();

                    kovetkezo();
                    Toast.makeText(MainActivity.this, "Elmentve a neved!", Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(MainActivity.this, "Nem írtál be nevet!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init(){
        EditText_nev = (EditText) findViewById(R.id.EditText_nev);
        Button_kuldes = (Button) findViewById(R.id.Button_kuldes);
    }

    public void kovetkezo(){
        Intent kovetkezo = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(kovetkezo);
        finish();
    }
}
