package com.example.diak.dolgozatsharepreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    private Button Button_elozoActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        init();

        Button_elozoActivity.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent elozoActivity = new Intent(Main4Activity.this, Main2Activity.class);
                startActivity(elozoActivity);
                finish();
            }
        });
    }

    public void init(){
        Button_elozoActivity = (Button) findViewById(R.id.Button_elozoActivity);
    }
}
