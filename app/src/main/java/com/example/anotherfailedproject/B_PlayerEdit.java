package com.example.anotherfailedproject;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class B_PlayerEdit extends AppCompatActivity implements View.OnClickListener{

    private TextInputEditText playerINPUT;
    private Button addBTN;
    private int j;
    private TextView[] PX;
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    Dialog PopUpDel;
    TextView title;
    Button acceptBTN, declineBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_player_edit);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("saison1").child("player");

        playerINPUT = findViewById(R.id.PE_PI);
        addBTN = findViewById(R.id.PE_ADD);

        addBTN.setOnClickListener(this);

        PX = new TextView[20];
        PX[0] = findViewById(R.id.PE_P1);
        PX[1] = findViewById(R.id.PE_P2);
        PX[2] = findViewById(R.id.PE_P3);
        PX[3] = findViewById(R.id.PE_P4);
        PX[4] = findViewById(R.id.PE_P5);
        PX[5] = findViewById(R.id.PE_P6);
        PX[6] = findViewById(R.id.PE_P7);
        PX[7] = findViewById(R.id.PE_P8);
        PX[8] = findViewById(R.id.PE_P9);
        PX[9] = findViewById(R.id.PE_P10);
        PX[10] = findViewById(R.id.PE_P11);
        PX[11] = findViewById(R.id.PE_P12);
        PX[12] = findViewById(R.id.PE_P13);
        PX[13] = findViewById(R.id.PE_P14);
        PX[14] = findViewById(R.id.PE_P15);
        PX[15] = findViewById(R.id.PE_P16);
        PX[16] = findViewById(R.id.PE_P17);
        PX[17] = findViewById(R.id.PE_P18);
        PX[18] = findViewById(R.id.PE_P19);
        PX[19] = findViewById(R.id.PE_P20);

        PX[0].setOnClickListener(this);
        PX[1].setOnClickListener(this);
        PX[2].setOnClickListener(this);
        PX[3].setOnClickListener(this);
        PX[4].setOnClickListener(this);
        PX[5].setOnClickListener(this);
        PX[6].setOnClickListener(this);
        PX[7].setOnClickListener(this);
        PX[8].setOnClickListener(this);
        PX[9].setOnClickListener(this);
        PX[10].setOnClickListener(this);
        PX[11].setOnClickListener(this);
        PX[12].setOnClickListener(this);
        PX[13].setOnClickListener(this);
        PX[14].setOnClickListener(this);
        PX[15].setOnClickListener(this);
        PX[16].setOnClickListener(this);
        PX[17].setOnClickListener(this);
        PX[18].setOnClickListener(this);
        PX[19].setOnClickListener(this);

        readPlayernames();

        PopUpDel = new Dialog(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addBTN){
            if (playerINPUT.getText().toString().isEmpty()){
                Toast.makeText(this, "Name eingeben!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                addPlayer();
                playerINPUT.setText("");
                return;
            }
        }
        if(v == PX[0]){PopUp(0);}
        if(v == PX[1]){PopUp(1);}
        if(v == PX[2]){PopUp(2);}
        if(v == PX[3]){PopUp(3);}
        if(v == PX[4]){PopUp(4);}
        if(v == PX[5]){PopUp(5);}
        if(v == PX[6]){PopUp(6);}
        if(v == PX[7]){PopUp(7);}
        if(v == PX[8]){PopUp(8);}
        if(v == PX[9]){PopUp(9);}
        if(v == PX[10]){PopUp(10);}
        if(v == PX[11]){PopUp(11);}
        if(v == PX[12]){PopUp(12);}
        if(v == PX[13]){PopUp(13);}
        if(v == PX[14]){PopUp(14);}
        if(v == PX[15]){PopUp(15);}
        if(v == PX[16]){PopUp(16);}
        if(v == PX[17]){PopUp(17);}
        if(v == PX[18]){PopUp(18);}
        if(v == PX[19]){PopUp(19);}
    }

    private void readPlayernames (){

        new B_FirebaseDatabaseHelper().readPlayer(new B_FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {

                SaisonData.playerList = new ArrayList<>();
                SaisonData.playercount = keys.size();

                for(int i = 0; i < SaisonData.playercount; i++){
                    PX[i].setVisibility(View.VISIBLE);
                    PX[i].setText(DatabasePlayerList.get(i).getPlayerName());
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
    }

    private void addPlayer(){
        Player player = new Player();
        player.setPlayerName(playerINPUT.getText().toString());

        new B_FirebaseDatabaseHelper().addPlayer(player, new B_FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Player> DatabasePlayerList, List<String> keys) {

            }

            @Override
            public void DataIsInserted() {
                Toast.makeText(B_PlayerEdit.this, "Hinzugefügt", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }

    private void PopUp(final int i){
        PopUpDel.setContentView(R.layout.z_pop_up_game);
        acceptBTN = PopUpDel.findViewById(R.id.PPaccept);
        declineBTN = PopUpDel.findViewById(R.id.PPdecline);
        title = PopUpDel.findViewById(R.id.textView3);

        title.setText(PX[i].getText().toString() + " löschen?");
        acceptBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new B_FirebaseDatabaseHelper().deletePlayer(SaisonData.playerList.get(i).getKey(), new B_FirebaseDatabaseHelper.DataStatus() {
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
                        PX[i].setVisibility(View.GONE);
                        Toast.makeText(B_PlayerEdit.this, "Spieler erfolgreich gelöscht", Toast.LENGTH_SHORT).show();
                        PopUpDel.dismiss();
                    }
                });
            }
        });
        declineBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUpDel.dismiss();
            }
        });

        PopUpDel.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        PopUpDel.show();
    }
}
