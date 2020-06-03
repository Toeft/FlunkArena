package com.example.anotherfailedproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class A_MainMenu extends AppCompatActivity implements View.OnClickListener{

    private CardView saisonBtn, turnamentBTN, casualBTN, settingsBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_main_menu);

        saisonBtn = findViewById(R.id.saisonBTN);
        turnamentBTN = findViewById(R.id.turnierBTN);
        casualBTN = findViewById(R.id.casualBTN);
        settingsBTN = findViewById(R.id.settingsBTN);

        saisonBtn.setOnClickListener(this);
        turnamentBTN.setOnClickListener(this);
        casualBTN.setOnClickListener(this);
        settingsBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == saisonBtn){
            Intent goSaison = new Intent(getApplicationContext(), B_MainMenu.class);
            startActivity(goSaison); }
        if(v == turnamentBTN){
            Intent goTurnament = new Intent(getApplicationContext(), C_MainMenu.class);
            startActivity(goTurnament);}
        if(v == casualBTN){
            Intent goCasual = new Intent(getApplicationContext(), D_MainMenu.class);
            startActivity(goCasual);}
        /**if(v == settingsBTN){
            Intent goSettings = new Intent(getApplicationContext(), E_MainMenu.class);
            startActivity(goSettings);}**/
    }
}
