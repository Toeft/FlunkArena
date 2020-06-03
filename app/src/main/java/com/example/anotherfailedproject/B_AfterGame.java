package com.example.anotherfailedproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class B_AfterGame extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference mRef;
    private FirebaseDatabase database;
    private TextView[] AGX;
    private TextView returnBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_after_game);

        database = FirebaseDatabase.getInstance();
        mRef = database.getReference().child("saison1").child("gamelog");

        AGX = new TextView[8];
        AGX[0] = findViewById(R.id.AG_P1);
        AGX[1] = findViewById(R.id.AG_P2);
        AGX[2] = findViewById(R.id.AG_P3);
        AGX[3] = findViewById(R.id.AG_P4);
        AGX[4] = findViewById(R.id.AG_P5);
        AGX[5] = findViewById(R.id.AG_P6);
        AGX[6] = findViewById(R.id.AG_P7);
        AGX[7] = findViewById(R.id.AG_P8);

        returnBTN = findViewById(R.id.returnBTN);
        returnBTN.setOnClickListener(this);

        makeGameLog();
        displayNames();


        addWins();
        addPoints();
        addGames();
    }

    private void displayNames() {

        int k = SaisonData.doneList.size();
        for (int i=0; i<k; i++){
            AGX[i].setText(SaisonData.doneList.get(i).getPlayerName());
            AGX[i].setVisibility(View.VISIBLE);
        }

    }

    private void makeGameLog(){

        LocalDate currentTime = LocalDate.now();
        final String TimeX = currentTime.toString();

        /**mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer value = dataSnapshot.child(TimeX).getValue(Integer.class);
                if(value == null){
                    mRef.child(TimeX).setValue(1);
                    return;
                }else{
                    mRef.child(TimeX).setValue(value+1);
                    return;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });**/
        mRef.child(TimeX).setValue(1);
    }

    @Override
    public void onClick(View v) {
        if(v == returnBTN){
            Intent Return = new Intent(getApplicationContext(), B_MainMenu.class);
            startActivity(Return);
        }
    }

    private void addWins(){
        int j = SaisonData.winnerList.size();

        for (int i=0;i<j;i++)
        {
            SaisonData.winnerList.get(i).setWins(SaisonData.winnerList.get(i).getWins()+1);

            new B_FirebaseDatabaseHelper().updatePlayer(SaisonData.winnerList.get(i).getKey(), SaisonData.winnerList.get(i), new B_FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {
                }
                @Override
                public void DataIsInserted() {
                }
                @Override
                public void DataIsUpdated() {
                    Toast.makeText(B_AfterGame.this, "Updated", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void DataIsDeleted() {
                }
            });
        }
    }

    private void addPoints(){
        int j = SaisonData.doneList.size();


        for (int i=0;i<j;i++)
        {
            SaisonData.doneList.get(i).setPoints(SaisonData.doneList.get(i).getPoints()+1);

            new B_FirebaseDatabaseHelper().updatePlayer(SaisonData.doneList.get(i).getKey(), SaisonData.doneList.get(i), new B_FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {
                }
                @Override
                public void DataIsInserted() {
                }
                @Override
                public void DataIsUpdated() {
                    //Toast.makeText(AfterGame.this, "Updated", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void DataIsDeleted() {
                }
            });
        }
    }

    private void addGames(){
        int j = SaisonData.participantList.size();

        for (int i=0;i<j;i++)
        {
            SaisonData.participantList.get(i).setGames(SaisonData.participantList.get(i).getGames()+1);
            double thisQuote =  (double) SaisonData.playerList.get(i).getPoints()/ (double) SaisonData.playerList.get(i).getGames();
            SaisonData.playerList.get(i).setQuote(thisQuote);

            new B_FirebaseDatabaseHelper().updatePlayer(SaisonData.participantList.get(i).getKey(), SaisonData.participantList.get(i), new B_FirebaseDatabaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {
                }
                @Override
                public void DataIsInserted() {
                }
                @Override
                public void DataIsUpdated() {
                    //Toast.makeText(B_AfterGame.this, "Updated", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void DataIsDeleted() {
                }
            });
        }
    }
}
