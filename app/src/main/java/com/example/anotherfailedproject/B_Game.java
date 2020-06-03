package com.example.anotherfailedproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_Game extends AppCompatActivity implements View.OnClickListener {

    private TextView[] GX;
    boolean[] done;
    final List<Player> tempList = new ArrayList<>(SaisonData.participantList);

    Dialog PopUpConfirm;
    Button confirmBTN, declineBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_game);

        GX = new TextView[12];
        GX[0] = findViewById(R.id.G_N1);
        GX[1] = findViewById(R.id.G_N5);
        GX[2] = findViewById(R.id.G_N2);
        GX[3] = findViewById(R.id.G_N6);
        GX[4] = findViewById(R.id.G_N3);
        GX[5] = findViewById(R.id.G_N7);
        GX[6] = findViewById(R.id.G_N4);
        GX[7] = findViewById(R.id.G_N8);

        GX[0].setOnClickListener(this);
        GX[1].setOnClickListener(this);
        GX[2].setOnClickListener(this);
        GX[3].setOnClickListener(this);
        GX[4].setOnClickListener(this);
        GX[5].setOnClickListener(this);
        GX[6].setOnClickListener(this);
        GX[7].setOnClickListener(this);

        done = new boolean[8];

        PopUpConfirm = new Dialog(this);

        gameSetup();
    }

    @Override
    public void onClick(View v) {
        if (v == GX[0]){
            done[0] = switchPlayerDone(GX[0],done[0]);
            checkWin(checkGameDone());

        }
        if (v == GX[1]){
            done[1] = switchPlayerDone(GX[1],done[1]);
            checkWin(checkGameDone());

        }
        if (v == GX[2]){
            done[2] = switchPlayerDone(GX[2],done[2]);
            checkWin(checkGameDone());

        }
        if (v == GX[3]){
            done[3] = switchPlayerDone(GX[3],done[3]);
            checkWin(checkGameDone());

        }
        if (v == GX[4]){
            done[4] = switchPlayerDone(GX[4],done[4]);
            checkWin(checkGameDone());

        }
        if (v == GX[5]){
            done[5] = switchPlayerDone(GX[5],done[5]);
            checkWin(checkGameDone());

        }
        if (v == GX[6]){
            done[6] = switchPlayerDone(GX[6],done[6]);
            checkWin(checkGameDone());

        }
        if (v == GX[7]){
            done[7] = switchPlayerDone(GX[7],done[7]);
            checkWin(checkGameDone());
        }
    }

    private void gameSetup (){

        Collections.shuffle(tempList);

        if (SaisonData.teamsize == 2){
            GX[0].setText(tempList.get(0).getPlayerName());
            GX[1].setText(tempList.get(1).getPlayerName());
            GX[2].setText(tempList.get(2).getPlayerName());
            GX[3].setText(tempList.get(3).getPlayerName());

            GX[4].setVisibility(View.GONE);
            GX[5].setVisibility(View.GONE);
            GX[6].setVisibility(View.GONE);
            GX[7].setVisibility(View.GONE);
        }

        if (SaisonData.teamsize == 3){
            GX[0].setText(tempList.get(0).getPlayerName());
            GX[1].setText(tempList.get(1).getPlayerName());
            GX[2].setText(tempList.get(2).getPlayerName());
            GX[3].setText(tempList.get(3).getPlayerName());
            GX[4].setText(tempList.get(4).getPlayerName());
            GX[5].setText(tempList.get(5).getPlayerName());

            GX[6].setVisibility(View.GONE);
            GX[7].setVisibility(View.GONE);
        }

        if (SaisonData.teamsize == 4){
            GX[0].setText(tempList.get(0).getPlayerName());
            GX[1].setText(tempList.get(1).getPlayerName());
            GX[2].setText(tempList.get(2).getPlayerName());
            GX[3].setText(tempList.get(3).getPlayerName());
            GX[4].setText(tempList.get(4).getPlayerName());
            GX[5].setText(tempList.get(5).getPlayerName());
            GX[6].setText(tempList.get(6).getPlayerName());
            GX[7].setText(tempList.get(7).getPlayerName());
        }
    }

    private boolean switchPlayerDone(TextView playerX,boolean doneX) {
        if (doneX == false){
            playerX.setTextColor(Color.parseColor("#0C6D29"));
            return true;
        } else {
            playerX.setTextColor(Color.parseColor("#FFD5B8"));
            return false;
        }
    }

    private boolean checkGameDone() {
        if (SaisonData.teamsize == 2)
        {
            if (done[0] && done[2])
            {
                SaisonData.winnerList = new ArrayList<>();
                SaisonData.winnerList.add(tempList.get(0));
                SaisonData.winnerList.add(tempList.get(2));
                return true;
            }
            if (done[1] && done[3])
            {
                SaisonData.winnerList = new ArrayList<>();
                SaisonData.winnerList.add(tempList.get(1));
                SaisonData.winnerList.add(tempList.get(3));
                return true;
            }
        }
        if (SaisonData.teamsize == 3)
        {
            if (done[0] && done[2] && done[4])
            {
                SaisonData.winnerList = new ArrayList<>();
                SaisonData.winnerList.add(tempList.get(0));
                SaisonData.winnerList.add(tempList.get(2));
                SaisonData.winnerList.add(tempList.get(4));
                return true;
            }
            if (done[1] && done[3] && done[5])
            {
                SaisonData.winnerList = new ArrayList<>();
                SaisonData.winnerList.add(tempList.get(1));
                SaisonData.winnerList.add(tempList.get(3));
                SaisonData.winnerList.add(tempList.get(5));
                return true;
            }
        }
        if (SaisonData.teamsize == 4)
        {
            if (done[0] && done[2] && done[4] && done[6])
            {
                SaisonData.winnerList = new ArrayList<>();
                SaisonData.winnerList.add(tempList.get(0));
                SaisonData.winnerList.add(tempList.get(2));
                SaisonData.winnerList.add(tempList.get(4));
                SaisonData.winnerList.add(tempList.get(6));
                return true;
            }
            if (done[1] && done[3] && done[5] && done[7])
            {
                SaisonData.winnerList = new ArrayList<>();
                SaisonData.winnerList.add(tempList.get(1));
                SaisonData.winnerList.add(tempList.get(3));
                SaisonData.winnerList.add(tempList.get(5));
                SaisonData.winnerList.add(tempList.get(7));
                return true;
            }
        }
        return false;
    }

    private void checkWin(boolean gameDone) {
        if (gameDone)
        {
            makeDoneList();
            PopUpConfirm();
        }
    }


    private void makeDoneList (){
        //Wieviele Spieler spielen
        int l = SaisonData.teamsize*2;
        //Done Liste anlegen
        SaisonData.doneList = new ArrayList<>();
        //schauen welche Spieler done sind
        for(int i=0; i<l; i++){
            if(done[i] == true){
                SaisonData.doneList.add(tempList.get(i));}
        }
    }

    private void PopUpConfirm(){

        PopUpConfirm.setContentView(R.layout.z_pop_up_game);

        declineBTN = PopUpConfirm.findViewById(R.id.PPdecline);
        confirmBTN = PopUpConfirm.findViewById(R.id.PPaccept);

        declineBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpConfirm.dismiss();
            }
        });

        confirmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goAfterGame = new Intent(getApplicationContext(), B_AfterGame.class);
                startActivity(goAfterGame);
            }
        });

        PopUpConfirm.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        PopUpConfirm.show();
    }
}