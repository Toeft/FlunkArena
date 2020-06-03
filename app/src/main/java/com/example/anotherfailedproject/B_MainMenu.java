package com.example.anotherfailedproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class B_MainMenu extends AppCompatActivity implements View.OnClickListener {

    private CardView matchday, playerdit, rangliste, rules;
    private TextView patchNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_main_menu);

        matchday = (CardView) findViewById(R.id.spieltagBTN);
        playerdit = (CardView) findViewById(R.id.spielerBTN);
        rangliste = (CardView) findViewById(R.id.ranglisteBTN);
        patchNotes = (TextView) findViewById(R.id.patchNotesBTN);
        rules = (CardView) findViewById(R.id.regelnBTN);
        matchday.setOnClickListener(this);
        playerdit.setOnClickListener(this);
        rangliste.setOnClickListener(this);
        patchNotes.setOnClickListener(this);
        rules.setOnClickListener(this);


        new B_FirebaseDatabaseHelper().readPlayer(new B_FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {

                SaisonData.playerList = new ArrayList<>();
                SaisonData.playercount = keys.size();

                for(int i = 0; i < SaisonData.playercount; i++){
                    SaisonData.playerList.add(DatabasePlayerList.get(i));
                    SaisonData.playerList.get(i).setKey(keys.get(i));

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

        makeQuote();
    }

    @Override
    public void onClick(View v) {

        if(v == playerdit){
            Intent goPlayeredit = new Intent(getApplicationContext(), B_PlayerEdit.class);
            startActivity(goPlayeredit);
            //vorher SaisonData.playerList Array lesen und prüfen
        }

        if(v == matchday){

            Intent goMatchday = new Intent(getApplicationContext(), B_MatchDay.class);
            startActivity(goMatchday);
            //vorher checken ob ein Spiel läuft
        }

        if(v == rangliste){
            Intent goRangliste = new Intent(getApplicationContext(), B_ScoreBoard.class);
            startActivity(goRangliste);
        }

        if(v == patchNotes){
            Intent goPatchNotes = new Intent(getApplicationContext(), B_PatchNotes.class);
            startActivity(goPatchNotes);
        }

        if(v == rules){
            Intent goRules = new Intent(getApplicationContext(), B_Rules.class);
            startActivity(goRules);
        }
    }

    public void makeQuote(){

        for (int i = 0; i < SaisonData.playercount; i++)
        {

            if (SaisonData.playerList.get(i).getGames() > 0){
                double thisQuote =  (double) SaisonData.playerList.get(i).getPoints()/ (double) SaisonData.playerList.get(i).getGames();
                SaisonData.playerList.get(i).setQuote(thisQuote);

                new B_FirebaseDatabaseHelper().updatePlayer(SaisonData.playerList.get(i).getKey(), SaisonData.playerList.get(i), new B_FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {
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
            else return;
        }
    }

}
