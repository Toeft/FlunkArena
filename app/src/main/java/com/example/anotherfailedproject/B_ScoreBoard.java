package com.example.anotherfailedproject;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_ScoreBoard extends AppCompatActivity implements View.OnClickListener{

    private TextView[] SBX;
    private List<Player> sortedPlayers;

    Dialog PopUp;
    TextView winsX, loosesX, gamesX, pointsX, playerNameX, quoteX, alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_score_board);

        gettingData();

        SBX = new TextView[20];
        SBX[0] = findViewById(R.id.SB_P1);
        SBX[1] = findViewById(R.id.SB_P2);
        SBX[2] = findViewById(R.id.SB_P3);
        SBX[3] = findViewById(R.id.SB_P4);
        SBX[4] = findViewById(R.id.SB_P5);
        SBX[5] = findViewById(R.id.SB_P6);
        SBX[6] = findViewById(R.id.SB_P7);
        SBX[7] = findViewById(R.id.SB_P8);
        SBX[8] = findViewById(R.id.SB_P9);
        SBX[9] = findViewById(R.id.SB_P10);
        SBX[10] = findViewById(R.id.SB_P11);
        SBX[11] = findViewById(R.id.SB_P12);
        SBX[12] = findViewById(R.id.SB_P13);
        SBX[13] = findViewById(R.id.SB_P14);
        SBX[14] = findViewById(R.id.SB_P15);
        SBX[15] = findViewById(R.id.SB_P16);
        SBX[16] = findViewById(R.id.SB_P17);
        SBX[17] = findViewById(R.id.SB_P18);
        SBX[18] = findViewById(R.id.SB_P19);
        SBX[19] = findViewById(R.id.SB_P20);

        SBX[0].setOnClickListener(this);
        SBX[1].setOnClickListener(this);
        SBX[2].setOnClickListener(this);
        SBX[3].setOnClickListener(this);
        SBX[4].setOnClickListener(this);
        SBX[5].setOnClickListener(this);
        SBX[6].setOnClickListener(this);
        SBX[7].setOnClickListener(this);
        SBX[8].setOnClickListener(this);
        SBX[9].setOnClickListener(this);
        SBX[10].setOnClickListener(this);
        SBX[11].setOnClickListener(this);
        SBX[12].setOnClickListener(this);
        SBX[13].setOnClickListener(this);
        SBX[14].setOnClickListener(this);
        SBX[15].setOnClickListener(this);
        SBX[16].setOnClickListener(this);
        SBX[17].setOnClickListener(this);
        SBX[18].setOnClickListener(this);
        SBX[19].setOnClickListener(this);

        //playerValues = new Player[12];

        PopUp = new Dialog(this);
    }

    private void gettingData() {
        new B_FirebaseDatabaseHelper().readPlayer(new B_FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {

                sortedPlayers = new ArrayList<>(DatabasePlayerList);
                Collections.sort(sortedPlayers, Collections.reverseOrder());

                for(int i = 0; i< SaisonData.playercount; i++){

                    SBX[i].setText(sortedPlayers.get(i).getPlayerName());
                    SBX[i].setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }

    private void PopUp(int i){

        PopUp.setContentView(R.layout.z_pop_up_scoreboard);

        winsX = PopUp.findViewById(R.id.PU_wins);
        loosesX = PopUp.findViewById(R.id.PU_looses);
        pointsX = PopUp.findViewById(R.id.PU_points);
        playerNameX = PopUp.findViewById(R.id.PU_playerName);
        gamesX = PopUp.findViewById(R.id.PU_games);
        quoteX = PopUp.findViewById(R.id.PU_quote);
        alert = PopUp.findViewById(R.id.PU_alert);

        if (sortedPlayers.get(i).getGames() < 11){
            alert.setText("Von der Wertung ausgeschlossen");
        }else{
            alert.setVisibility(View.GONE);
        }

        int tempLooses = sortedPlayers.get(i).getGames() - sortedPlayers.get(i).getWins();
        winsX.setText("Siege: " + sortedPlayers.get(i).getWins());
        loosesX.setText("Niederlagen: " + tempLooses);
        pointsX.setText("Punkte: " + sortedPlayers.get(i).getPoints());
        playerNameX.setText(sortedPlayers.get(i).getPlayerName());
        gamesX.setText("Spiele: " + sortedPlayers.get(i).getGames());
        quoteX.setText("Quote: " + sortedPlayers.get(i).getQuote());

        PopUp.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        PopUp.show();


    }

    @Override
    public void onClick(View v) {
        if(v == SBX[0]){PopUp(0);}
        if(v == SBX[1]){PopUp(1);}
        if(v == SBX[2]){PopUp(2);}
        if(v == SBX[3]){PopUp(3);}
        if(v == SBX[4]){PopUp(4);}
        if(v == SBX[5]){PopUp(5);}
        if(v == SBX[6]){PopUp(6);}
        if(v == SBX[7]){PopUp(7);}
        if(v == SBX[8]){PopUp(8);}
        if(v == SBX[9]){PopUp(9);}
        if(v == SBX[10]){PopUp(10);}
        if(v == SBX[11]){PopUp(11);}
        if(v == SBX[12]){PopUp(12);}
        if(v == SBX[13]){PopUp(13);}
        if(v == SBX[14]){PopUp(14);}
        if(v == SBX[15]){PopUp(15);}
        if(v == SBX[16]){PopUp(16);}
        if(v == SBX[17]){PopUp(17);}
        if(v == SBX[18]){PopUp(18);}
        if(v == SBX[19]){PopUp(19);}
    }
}
