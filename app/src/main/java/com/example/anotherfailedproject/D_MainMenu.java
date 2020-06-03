package com.example.anotherfailedproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class D_MainMenu extends AppCompatActivity implements View.OnClickListener{

    private CardView randomBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d__main_menu);

        randomBTN = findViewById(R.id.MMDrandomBTN);

        randomBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         if(v == randomBTN){
             Intent goRandomGame = new Intent(getApplicationContext(), D_RandomGame.class);
             startActivity(goRandomGame);
         }
    }
}
