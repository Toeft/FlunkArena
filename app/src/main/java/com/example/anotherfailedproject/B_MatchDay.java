package com.example.anotherfailedproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class B_MatchDay extends AppCompatActivity implements View.OnClickListener{

    private Button teamsizeBTN2, teamsizeBTN3, teamsizeBTN4, startBTN;
    private int j, o;
    boolean[] participant;
    private TextView[] NX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_match_day);
        NX = new TextView[20];
        NX[0] = findViewById(R.id.MD_N1);
        NX[1] = findViewById(R.id.MD_N2);
        NX[2] = findViewById(R.id.MD_N3);
        NX[3] = findViewById(R.id.MD_N4);
        NX[4] = findViewById(R.id.MD_N5);
        NX[5] = findViewById(R.id.MD_N6);
        NX[6] = findViewById(R.id.MD_N7);
        NX[7] = findViewById(R.id.MD_N8);
        NX[8] = findViewById(R.id.MD_N9);
        NX[9] = findViewById(R.id.MD_N10);
        NX[10] = findViewById(R.id.MD_N11);
        NX[11] = findViewById(R.id.MD_N12);
        NX[12] = findViewById(R.id.MD_N12);
        NX[13] = findViewById(R.id.MD_N12);
        NX[14] = findViewById(R.id.MD_N12);
        NX[15] = findViewById(R.id.MD_N12);
        NX[16] = findViewById(R.id.MD_N12);
        NX[17] = findViewById(R.id.MD_N12);
        NX[18] = findViewById(R.id.MD_N12);
        NX[19] = findViewById(R.id.MD_N12);

        teamsizeBTN2 = findViewById(R.id.MD_BTN2);
        teamsizeBTN3 = findViewById(R.id.MD_BTN3);
        teamsizeBTN4 = findViewById(R.id.MD_BTN4);

        startBTN = findViewById(R.id.MD_BTN_start);

        teamsizeBTN2.setOnClickListener(this);
        teamsizeBTN3.setOnClickListener(this);
        teamsizeBTN4.setOnClickListener(this);

        NX[0].setOnClickListener(this);
        NX[1].setOnClickListener(this);
        NX[2].setOnClickListener(this);
        NX[3].setOnClickListener(this);
        NX[4].setOnClickListener(this);
        NX[5].setOnClickListener(this);
        NX[6].setOnClickListener(this);
        NX[7].setOnClickListener(this);
        NX[8].setOnClickListener(this);
        NX[9].setOnClickListener(this);
        NX[10].setOnClickListener(this);
        NX[11].setOnClickListener(this);
        NX[12].setOnClickListener(this);
        NX[13].setOnClickListener(this);
        NX[14].setOnClickListener(this);
        NX[15].setOnClickListener(this);
        NX[16].setOnClickListener(this);
        NX[17].setOnClickListener(this);
        NX[18].setOnClickListener(this);
        NX[19].setOnClickListener(this);

        startBTN.setOnClickListener(this);

        readPlayernames();
        teamSizeToggle();

        participant = new boolean[20];

        SaisonData.participantList = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {

        if (v == teamsizeBTN2){
            SaisonData.teamsize = 2;
            teamSizeToggle();

        }
        if (v == teamsizeBTN3){
            SaisonData.teamsize = 3;
            teamSizeToggle();

        }
        if (v == teamsizeBTN4){
            SaisonData.teamsize = 4;
            teamSizeToggle();
        }

        if (v == startBTN){
            //startgame();
            //readyCheck();
            if (readyCheck() == false){
                return;
            }
            else{
                startgame();
                Intent goGame = new Intent(getApplicationContext(), B_Game.class);
                startActivity(goGame);
                //erneut Prüfen ob ein Spiel läuft oder ggf. starten
            }

        }

        if (v == NX[0]){
            participant[0] = switchPlayerState(NX[0],participant[0]);
        }
        if (v == NX[1]){
            participant[1] = switchPlayerState(NX[1],participant[1]);
        }
        if (v == NX[2]){
            participant[2] = switchPlayerState(NX[2],participant[2]);
        }
        if (v == NX[3]){
            participant[3] = switchPlayerState(NX[3],participant[3]);
        }
        if (v == NX[4]){
            participant[4] = switchPlayerState(NX[4],participant[4]);
        }
        if (v == NX[5]){
            participant[5] = switchPlayerState(NX[5],participant[5]);
        }
        if (v == NX[6]){
            participant[6] = switchPlayerState(NX[6],participant[6]);
        }
        if (v == NX[7]){
            participant[7] = switchPlayerState(NX[7],participant[7]);
        }
        if (v == NX[8]){
            participant[8] = switchPlayerState(NX[8],participant[8]);
        }
        if (v == NX[9]){
            participant[9] = switchPlayerState(NX[9],participant[9]);
        }
        if (v == NX[10]){
            participant[10] = switchPlayerState(NX[10],participant[10]);
        }
        if (v == NX[11]){
            participant[11] = switchPlayerState(NX[11],participant[11]);
        }
        if (v == NX[12]){
            participant[12] = switchPlayerState(NX[12],participant[12]);
        }
        if (v == NX[13]){
            participant[13] = switchPlayerState(NX[13],participant[13]);
        }
        if (v == NX[14]){
            participant[14] = switchPlayerState(NX[14],participant[14]);
        }
        if (v == NX[15]){
            participant[15] = switchPlayerState(NX[15],participant[15]);
        }
        if (v == NX[16]){
            participant[16] = switchPlayerState(NX[16],participant[16]);
        }
        if (v == NX[17]){
            participant[17] = switchPlayerState(NX[17],participant[17]);
        }
        if (v == NX[18]){
            participant[18] = switchPlayerState(NX[18],participant[18]);
        }
        if (v == NX[19]){
            participant[19] = switchPlayerState(NX[19],participant[19]);
        }
    }

    private void startgame (){
        SaisonData.participantList.clear();
        for(int i=0; i<20; i++){
            if(participant[i] == true){
                SaisonData.participantList.add(SaisonData.playerList.get(i));
            }
        }
    }

    private void teamSizeToggle (){

        if (SaisonData.teamsize == 2){
            teamsizeBTN2.setBackgroundResource(R.drawable.leftbtn_c2);
            teamsizeBTN3.setBackgroundResource(R.drawable.middlebtn_c1);
            teamsizeBTN4.setBackgroundResource(R.drawable.rightbtn_c1);
            return;
        }
        if (SaisonData.teamsize == 3){
            teamsizeBTN2.setBackgroundResource(R.drawable.leftbtn_c1);
            teamsizeBTN3.setBackgroundResource(R.drawable.middlebtn_c2);
            teamsizeBTN4.setBackgroundResource(R.drawable.rightbtn_c1);
            return;
        }
        if (SaisonData.teamsize == 4){
            teamsizeBTN2.setBackgroundResource(R.drawable.leftbtn_c1);
            teamsizeBTN3.setBackgroundResource(R.drawable.middlebtn_c1);
            teamsizeBTN4.setBackgroundResource(R.drawable.rightbtn_c2);
            return;
        }

    }

    private boolean switchPlayerState(TextView nameX,boolean participantX) {
        if (participantX == false){
            nameX.setTextColor(Color.parseColor("#0C6D29"));
            return true;
        } else {
            nameX.setTextColor(Color.parseColor("#FFD5B8"));
            return false;
        }
    }

    private void readPlayernames (){

        j = SaisonData.playercount;

        for(int i=0; i < j; i++){
            NX[i].setVisibility(View.VISIBLE);
            NX[i].setText(SaisonData.playerList.get(i).getPlayerName());
        }
    }

    private boolean readyCheck () {
        int spieleranzahl = 0;
        for(int i=0; i<20; i++){
            if(participant[i] == true){
                spieleranzahl++;
            }
        }
        o = spieleranzahl/ SaisonData.teamsize;
        if(o != 2 || spieleranzahl% SaisonData.teamsize != 0){
            Toast.makeText(this, "Teamgröße oder Spieleranzahl ändern!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
