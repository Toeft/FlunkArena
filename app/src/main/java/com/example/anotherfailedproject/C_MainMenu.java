package com.example.anotherfailedproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class C_MainMenu extends AppCompatActivity implements View.OnClickListener{

    private CardView createBTN, joinBTN, infoBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_main_menu);

        createBTN = findViewById(R.id.turnamentcreateBTN);
        joinBTN = findViewById(R.id.turnamentjoinBTN);
        infoBTN = findViewById(R.id.turnamentinfoBTN);

        createBTN.setOnClickListener(this);
        joinBTN.setOnClickListener(this);
        infoBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == createBTN){
            Intent goCreateTurnament = new Intent(getApplicationContext(), C_CreateTurnament.class);
            startActivity(goCreateTurnament);
        }
        /**if (v == joinBTN){
            //PopUp
            Intent goJoinTurnament = new Intent(getApplicationContext(), C_JoinTurnament.class);
            startActivity(goJoinTurnament);
        }**/
        if (v == infoBTN){
            Intent goInfoTurnament = new Intent(getApplicationContext(), C_TournamentInfo.class);
            startActivity(goInfoTurnament);
        }
    }
}
