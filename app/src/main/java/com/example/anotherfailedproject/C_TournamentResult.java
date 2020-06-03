package com.example.anotherfailedproject;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C_TournamentResult extends AppCompatActivity implements View.OnClickListener{

    private TextView[] SBX;
    private TextView returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_tournament_result);

        SBX = new TextView[16];
        SBX[0] = findViewById(R.id.TextViewPlace1);
        SBX[1] = findViewById(R.id.TextViewPlace2);
        SBX[2] = findViewById(R.id.TextViewPlace3);
        SBX[3] = findViewById(R.id.TextViewPlace4);
        SBX[4] = findViewById(R.id.TextViewPlace5);
        SBX[5] = findViewById(R.id.TextViewPlace6);
        SBX[6] = findViewById(R.id.TextViewPlace7);
        SBX[7] = findViewById(R.id.TextViewPlace8);
        SBX[8] = findViewById(R.id.TextViewPlace9);
        SBX[9] = findViewById(R.id.TextViewPlace10);
        SBX[10] = findViewById(R.id.TextViewPlace11);
        SBX[11] = findViewById(R.id.TextViewPlace12);
        SBX[12] = findViewById(R.id.TextViewPlace13);
        SBX[13] = findViewById(R.id.TextViewPlace14);
        SBX[14] = findViewById(R.id.TextViewPlace15);
        SBX[15] = findViewById(R.id.TextViewPlace16);

        returnBtn = findViewById(R.id.returnBTN);
        returnBtn.setOnClickListener(this);


        /*SBX[0].setOnClickListener(this);
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
        SBX[15].setOnClickListener(this);*/

        List<Team> tempList = new ArrayList<>(TournamentData.TeamListResult);
        Collections.reverse(tempList);

        for(int i = 0; i < tempList.size(); i++){

            SBX[i].setText(tempList.get(i).getTeamName());
            SBX[i].setVisibility(View.VISIBLE);
        }

    }
    public void onClick(View v) {
        if (v == returnBtn){
            Intent Return = new Intent(getApplicationContext(), C_MainMenu.class);
            startActivity(Return);
        }
    }
}