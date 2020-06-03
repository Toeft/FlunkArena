package com.example.anotherfailedproject;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class C_TournamentHalf extends AppCompatActivity implements View.OnClickListener {

    public LinearLayout Match1, Match2;
    public TextView[] MatchPlayersTextView, MatchTeamNameTextView, PopupTextViewT1, PopupTextViewT2;
    public boolean[] MatchDoneList;
    Dialog MatchPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_tournament_half);

        Match1 = findViewById(R.id.LinLayM1);
        Match1.setOnClickListener(this);

        Match2 = findViewById(R.id.LinLayM2);
        Match2.setOnClickListener(this);

        MatchPlayersTextView = new TextView[4];
        MatchPlayersTextView[0] = findViewById(R.id.textViewM1T1);
        MatchPlayersTextView[1] = findViewById(R.id.textViewM1T2);
        MatchPlayersTextView[2] = findViewById(R.id.textViewM2T1);
        MatchPlayersTextView[3] = findViewById(R.id.textViewM2T2);

        for (int i = 0; i < MatchPlayersTextView.length; i++)
        {
            MatchPlayersTextView[i].setText(TournamentData.TeamListHalf.get(i).printPlayers());
        }

        MatchTeamNameTextView = new TextView[4];
        MatchTeamNameTextView[0] = findViewById(R.id.textViewM1T1N);
        MatchTeamNameTextView[1] = findViewById(R.id.textViewM1T2N);
        MatchTeamNameTextView[2] = findViewById(R.id.textViewM2T1N);
        MatchTeamNameTextView[3] = findViewById(R.id.textViewM2T2N);

        for (int i = 0; i < MatchTeamNameTextView.length; i++)
        {
            MatchTeamNameTextView[i].setText(TournamentData.TeamListHalf.get(i).getTeamName());
            TournamentData.TeamListHalf.get(i).doneList = new boolean[TournamentData.TeamSize];
        }

        MatchDoneList = new boolean[2];
    }

    public void onClick(View v) {

        if (v == Match1)
        {
            TournamentData.LastMatchNr = 0;
            PopupSetup(0);
        }
        if (v == Match2)
        {
            TournamentData.LastMatchNr = 1;
            PopupSetup(1);
        }
        //Team 1 Spieler "Fertig-Status Wechsel"
        if (v == PopupTextViewT1[1])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[0] =
                    switchPlayerDone(PopupTextViewT1[1], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[0]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }
        if (v == PopupTextViewT1[2])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[1] =
                    switchPlayerDone(PopupTextViewT1[2], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[1]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }
        if (v == PopupTextViewT1[3])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[2] =
                    switchPlayerDone(PopupTextViewT1[3], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[2]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }
        if (v == PopupTextViewT1[4])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[3] =
                    switchPlayerDone(PopupTextViewT1[4], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)).doneList[3]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }

        //Team 2 Spieler "Fertig-Status Wechsel"
        if (v == PopupTextViewT2[1])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[0] =
                    switchPlayerDone(PopupTextViewT2[1], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[0]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }
        if (v == PopupTextViewT2[2])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[1] =
                    switchPlayerDone(PopupTextViewT2[2], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[1]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }
        if (v == PopupTextViewT2[3])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[2] =
                    switchPlayerDone(PopupTextViewT2[3], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[2]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }
        if (v == PopupTextViewT2[4])
        {
            TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[3] =
                    switchPlayerDone(PopupTextViewT2[4], TournamentData.TeamListHalf.get((TournamentData.LastMatchNr*2)+1).doneList[3]);
            MatchDoneList[TournamentData.LastMatchNr] = CheckGameDone(TournamentData.LastMatchNr);
            NextRound();
        }

    }

    public void PopupSetup(int MatchNr)
    {
        MatchPopup = new Dialog(this);
        MatchPopup.setContentView(R.layout.popup_c_match);

        PopupTextViewT1 = new TextView[5];
        PopupTextViewT2 = new TextView[5];

        PopupTextViewT1[0] = MatchPopup.findViewById(R.id.textViewT1N);
        PopupTextViewT1[1] = MatchPopup.findViewById(R.id.textViewT1P1);
        PopupTextViewT1[2] = MatchPopup.findViewById(R.id.textViewT1P2);
        PopupTextViewT1[3] = MatchPopup.findViewById(R.id.textViewT1P3);
        PopupTextViewT1[4] = MatchPopup.findViewById(R.id.textViewT1P4);

        PopupTextViewT1[1].setVisibility(View.GONE);
        PopupTextViewT1[2].setVisibility(View.GONE);
        PopupTextViewT1[3].setVisibility(View.GONE);
        PopupTextViewT1[4].setVisibility(View.GONE);

        PopupTextViewT1[1].setOnClickListener(this);
        PopupTextViewT1[2].setOnClickListener(this);
        PopupTextViewT1[3].setOnClickListener(this);
        PopupTextViewT1[4].setOnClickListener(this);


        PopupTextViewT2[0] = MatchPopup.findViewById(R.id.textViewT2N);
        PopupTextViewT2[1] = MatchPopup.findViewById(R.id.textViewT2P1);
        PopupTextViewT2[2] = MatchPopup.findViewById(R.id.textViewT2P2);
        PopupTextViewT2[3] = MatchPopup.findViewById(R.id.textViewT2P3);
        PopupTextViewT2[4] = MatchPopup.findViewById(R.id.textViewT2P4);

        PopupTextViewT2[1].setVisibility(View.GONE);
        PopupTextViewT2[2].setVisibility(View.GONE);
        PopupTextViewT2[3].setVisibility(View.GONE);
        PopupTextViewT2[4].setVisibility(View.GONE);

        PopupTextViewT2[1].setOnClickListener(this);
        PopupTextViewT2[2].setOnClickListener(this);
        PopupTextViewT2[3].setOnClickListener(this);
        PopupTextViewT2[4].setOnClickListener(this);

        PopupTextViewT1[0].setText(TournamentData.TeamListHalf.get((MatchNr*2)).getTeamName());
        if (TournamentData.TeamListHalf.get((MatchNr*2)).isTeamDone())
        {
            PopupTextViewT1[0].setTextColor(Color.parseColor("#0C6D29"));
            PopupTextViewT2[0].setTextColor(Color.parseColor("#8A0808"));
        }

        PopupTextViewT2[0].setText(TournamentData.TeamListHalf.get((MatchNr*2)+1).getTeamName());
        if (TournamentData.TeamListHalf.get((MatchNr*2)+1).isTeamDone())
        {
            PopupTextViewT2[0].setTextColor(Color.parseColor("#0C6D29"));
            PopupTextViewT1[0].setTextColor(Color.parseColor("#8A0808"));
        }


        for (int i = 1; i <= TournamentData.TeamSize; i++)              // Jeweils den i-ten Spieler beider Teams anzeigen
        {
            PopupTextViewT1[i].setText(TournamentData.TeamListHalf.get((MatchNr*2)).TeamPlayerList.get(i-1).getPlayerName());
            PopupTextViewT2[i].setText(TournamentData.TeamListHalf.get((MatchNr*2)+1).TeamPlayerList.get(i-1).getPlayerName());
            PopupTextViewT1[i].setVisibility(View.VISIBLE);
            PopupTextViewT2[i].setVisibility(View.VISIBLE);

            if (TournamentData.TeamListHalf.get((MatchNr*2)).doneList[i-1])
            {
                PopupTextViewT1[i].setTextColor(Color.parseColor("#0C6D29"));
            }
            if (TournamentData.TeamListHalf.get((MatchNr*2)+1).doneList[i-1])
            {
                PopupTextViewT2[i].setTextColor(Color.parseColor("#0C6D29"));
            }
        }

        MatchPopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        MatchPopup.show();
    }
    private boolean switchPlayerDone(TextView nameX,boolean DeleteX) {
        if (!DeleteX){
            nameX.setTextColor(Color.parseColor("#0C6D29"));
            return true;
        } else {
            nameX.setTextColor(Color.parseColor("#FFD5B8"));
            return false;
        }
    }
    private boolean CheckGameDone(int MatchNr)
    {
        if (TournamentData.TeamListHalf.get((MatchNr*2)).isTeamDone())
        {
            PopupTextViewT1[0].setTextColor(Color.parseColor("#0C6D29"));
            PopupTextViewT2[0].setTextColor(Color.parseColor("#8A0808"));

            MatchTeamNameTextView[MatchNr*2].setTextColor(Color.parseColor("#0C6D29"));
            MatchPlayersTextView[MatchNr*2].setTextColor(Color.parseColor("#0C6D29"));

            MatchTeamNameTextView[MatchNr*2+1].setTextColor(Color.parseColor("#8A0808"));
            MatchPlayersTextView[MatchNr*2+1].setTextColor(Color.parseColor("#8A0808"));

            return true;
        }
        if (TournamentData.TeamListHalf.get((MatchNr*2)+1).isTeamDone())
        {
            PopupTextViewT2[0].setTextColor(Color.parseColor("#0C6D29"));
            PopupTextViewT1[0].setTextColor(Color.parseColor("#8A0808"));

            MatchTeamNameTextView[MatchNr*2+1].setTextColor(Color.parseColor("#0C6D29"));
            MatchPlayersTextView[MatchNr*2+1].setTextColor(Color.parseColor("#0C6D29"));

            MatchTeamNameTextView[MatchNr*2].setTextColor(Color.parseColor("#8A0808"));
            MatchPlayersTextView[MatchNr*2].setTextColor(Color.parseColor("#8A0808"));
            return true;
        }

        PopupTextViewT1[0].setTextColor(Color.parseColor("#FFD5B8"));
        PopupTextViewT2[0].setTextColor(Color.parseColor("#FFD5B8"));

        MatchTeamNameTextView[MatchNr*2].setTextColor(Color.parseColor("#FFD5B8"));
        MatchPlayersTextView[MatchNr*2].setTextColor(Color.parseColor("#FFD5B8"));

        MatchTeamNameTextView[MatchNr*2+1].setTextColor(Color.parseColor("#FFD5B8"));
        MatchPlayersTextView[MatchNr*2+1].setTextColor(Color.parseColor("#FFD5B8"));

        return false;
    }
    private void NextRound()
    {
        for (boolean b : MatchDoneList) {
            if (!b) return;
        }

        List<Team> WinnerList = new ArrayList<>();
        List<Team> LoserList = new ArrayList<>();

        for (int i=0; i<2;i++)
        {
            if (TournamentData.TeamListHalf.get(i*2).isTeamDone())
            {
                WinnerList.add(TournamentData.TeamListHalf.get(i*2));
                LoserList.add(TournamentData.TeamListHalf.get(i*2+1));
            }
            else {
                WinnerList.add(TournamentData.TeamListHalf.get(i*2+1));
                LoserList.add(TournamentData.TeamListHalf.get(i*2));
            }
        }
        TournamentData.TeamListFinal = new ArrayList<>(LoserList);
        TournamentData.TeamListFinal.addAll(WinnerList);

        Intent Final = new Intent(getApplicationContext(), C_TournamentFinal.class);
        startActivity(Final);
    }
}