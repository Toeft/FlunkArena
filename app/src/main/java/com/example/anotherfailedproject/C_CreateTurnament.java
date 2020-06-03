package com.example.anotherfailedproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class C_CreateTurnament extends AppCompatActivity implements View.OnClickListener{

    private TextView[] TournPlayerTextViews;
    private Button addBtn, delBtn, startBtn, TeamSizeBtn2, TeamSizeBtn3, TeamSizeBtn4;
    private boolean[] DeleteList;
    private TextInputEditText NameInput;
    private List<Player> TournamentList;
    private String[] TeamNames = {"Team1","Team2","Team3","Team4","Team5","Team6","Team7","Team8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_create_turnament);

        addBtn = findViewById(R.id.HinzuBtn);
        addBtn.setOnClickListener(this);

        delBtn = findViewById(R.id.delBtn);
        delBtn.setOnClickListener(this);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(this);

        TeamSizeBtn2 = findViewById(R.id.CT_BTN2);
        TeamSizeBtn2.setOnClickListener(this);

        TeamSizeBtn3 = findViewById(R.id.CT_BTN3);
        TeamSizeBtn3.setOnClickListener(this);

        TeamSizeBtn4 = findViewById(R.id.CT_BTN4);
        TeamSizeBtn4.setOnClickListener(this);

        NameInput = findViewById(R.id.PlayerInput);

        TournPlayerTextViews = new TextView[18];
        TournPlayerTextViews[0] = findViewById(R.id.textViewPlayer1);
        TournPlayerTextViews[1] = findViewById(R.id.textViewPlayer2);
        TournPlayerTextViews[2] = findViewById(R.id.textViewPlayer3);
        TournPlayerTextViews[3] = findViewById(R.id.textViewPlayer4);
        TournPlayerTextViews[4] = findViewById(R.id.textViewPlayer5);
        TournPlayerTextViews[5] = findViewById(R.id.textViewPlayer6);
        TournPlayerTextViews[6] = findViewById(R.id.textViewPlayer7);
        TournPlayerTextViews[7] = findViewById(R.id.textViewPlayer8);
        TournPlayerTextViews[8] = findViewById(R.id.textViewPlayer9);
        TournPlayerTextViews[9] = findViewById(R.id.textViewPlayer10);
        TournPlayerTextViews[10] = findViewById(R.id.textViewPlayer11);
        TournPlayerTextViews[11] = findViewById(R.id.textViewPlayer12);
        TournPlayerTextViews[12] = findViewById(R.id.textViewPlayer13);
        TournPlayerTextViews[13] = findViewById(R.id.textViewPlayer14);
        TournPlayerTextViews[14] = findViewById(R.id.textViewPlayer15);
        TournPlayerTextViews[15] = findViewById(R.id.textViewPlayer16);
        TournPlayerTextViews[16] = findViewById(R.id.textViewPlayer17);
        TournPlayerTextViews[17] = findViewById(R.id.textViewPlayer18);

        TournPlayerTextViews[0].setOnClickListener(this);
        TournPlayerTextViews[1].setOnClickListener(this);
        TournPlayerTextViews[2].setOnClickListener(this);
        TournPlayerTextViews[3].setOnClickListener(this);
        TournPlayerTextViews[4].setOnClickListener(this);
        TournPlayerTextViews[5].setOnClickListener(this);
        TournPlayerTextViews[6].setOnClickListener(this);
        TournPlayerTextViews[7].setOnClickListener(this);
        TournPlayerTextViews[8].setOnClickListener(this);
        TournPlayerTextViews[9].setOnClickListener(this);
        TournPlayerTextViews[10].setOnClickListener(this);
        TournPlayerTextViews[11].setOnClickListener(this);
        TournPlayerTextViews[12].setOnClickListener(this);
        TournPlayerTextViews[13].setOnClickListener(this);
        TournPlayerTextViews[14].setOnClickListener(this);
        TournPlayerTextViews[15].setOnClickListener(this);
        TournPlayerTextViews[16].setOnClickListener(this);
        TournPlayerTextViews[17].setOnClickListener(this);

        TournamentList = new ArrayList<>();

        TournamentData.TPlayerCounter = 0;
        DeleteList = new boolean[18];
        teamSizeToggle();

    }

    public void onClick(View v) {

        if (v == addBtn)
        {
            if (NameInput.getText().toString().isEmpty()){
                Toast.makeText(this, "Namen eingeben!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(TournamentData.TPlayerCounter / TournamentData.TeamSize == 8)
            {
                Toast.makeText(this, "Max. Spielerzahl erreicht!", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                String Name = NameInput.getText().toString();
                Player player = new Player(Name);
                TournamentList.add(player);
                TournamentData.TPlayerCounter++;
                displayPlayers();
                NameInput.setText("");
            }
        }

        if(v == delBtn)
        {
            /* RANDOM TEAMS
            for (int i = (TournamentData.TPlayerCounter - 1); i >= 0; i--)
            {
                if (DeleteList[i])
                {
                    TournamentList.remove(i);
                    DeleteList[i] = switchDeleteState(TournPlayerTextViews[i],DeleteList[i]);
                    TournamentData.TPlayerCounter--;
                }
            }*/
            if (TournamentData.TPlayerCounter > 0) {
                TournamentData.TPlayerCounter--;
                TournamentList.remove(TournamentData.TPlayerCounter);
                displayPlayers();
            }
        }

        if(v == startBtn)
        {
            if (readyCheck())
            {
                TournamentData.TeamList = new ArrayList<>();
                if (TournamentData.TeamSize == 2)
                {
                    for (int i = 0; i < TournamentData.TPlayerCounter; i++)
                    {

                        if (i%2 == 0)
                        {
                            int TeamListNr = i/2;
                            String teamName = TeamNames[TeamListNr];
                            List<Player> teamPlayerList;

                            teamPlayerList = new ArrayList<>();
                            teamPlayerList.add(TournamentList.get(i));
                            teamPlayerList.add(TournamentList.get(i+1));

                            Team team = new Team(teamName,teamPlayerList);
                            TournamentData.TeamList.add(team);
                        }
                    }
                }

                if (TournamentData.TeamSize == 3)
                {
                    for (int i = 0; i < TournamentData.TPlayerCounter; i++)
                    {
                        if (i%3 == 0)
                        {
                            int TeamListNr = i/3;
                            String TeamName = TeamNames[TeamListNr];
                            List<Player> teamPlayerList;

                            teamPlayerList = new ArrayList<>();
                            teamPlayerList.add(TournamentList.get(i));
                            teamPlayerList.add(TournamentList.get(i+1));
                            teamPlayerList.add(TournamentList.get(i+2));

                            Team team = new Team(TeamName,teamPlayerList);
                            TournamentData.TeamList.add(team);
                        }
                    }
                }

                if (TournamentData.TeamSize == 4)
                {
                    for (int i = 0; i < TournamentData.TPlayerCounter; i++)
                    {
                        if (i%4 == 0)
                        {
                            int TeamListNr = i/4;
                            String TeamName = TeamNames[TeamListNr];
                            List<Player> teamPlayerList;

                            teamPlayerList = new ArrayList<>();
                            teamPlayerList.add(TournamentList.get(i));
                            teamPlayerList.add(TournamentList.get(i+1));
                            teamPlayerList.add(TournamentList.get(i+2));
                            teamPlayerList.add(TournamentList.get(i+3));

                            Team team = new Team(TeamName,teamPlayerList);
                            TournamentData.TeamList.add(team);
                        }
                    }
                }
                if(TournamentData.TPlayerCounter / TournamentData.TeamSize == 8)
                {
                Intent startTournament = new Intent(getApplicationContext(), C_TournamentQuarter.class);
                startActivity(startTournament);
                }

                if(TournamentData.TPlayerCounter / TournamentData.TeamSize == 4)
                {
                    TournamentData.TeamListHalf = new ArrayList<>(TournamentData.TeamList);
                    TournamentData.TeamListResult = new ArrayList<>();
                    Intent startTournament = new Intent(getApplicationContext(), C_TournamentHalf.class);
                    startActivity(startTournament);
                }
            }
        }

        if(v == TeamSizeBtn2)
        {
            if (TournamentData.TPlayerCounter > 16) //Um zu vermeiden das bei zuvielen Spieler von 4er auf 3er oder 2er gewchselt wird
            {
                Toast.makeText(this, "Zu viele Spieler!", Toast.LENGTH_SHORT).show();
                return;
            }
            TournamentData.TeamSize = 2;
            teamSizeToggle();
            displayPlayers();
        }

        if(v == TeamSizeBtn3)
        {
            if (TournamentData.TPlayerCounter > 24) //Um zu vermeiden das bei zuvielen Spieler von 4er auf 3er oder 2er gewchselt wird
            {
                Toast.makeText(this, "Zu viele Spieler!", Toast.LENGTH_SHORT).show();
                return;
            }
            TournamentData.TeamSize = 3;
            teamSizeToggle();
            displayPlayers();
        }
        if(v == TeamSizeBtn4)
        {
            TournamentData.TeamSize = 4;
            teamSizeToggle();
            displayPlayers();
        }

        if (v == TournPlayerTextViews[0]){
            //DeleteList[0] = switchDeleteState(TournPlayerTextViews[0],DeleteList[0]);
            TeamNameInput(0);
        }
        if (v == TournPlayerTextViews[1]){
            //DeleteList[1] = switchDeleteState(TournPlayerTextViews[1],DeleteList[1]);
            TeamNameInput(1);
        }
        if (v == TournPlayerTextViews[2]){
            //DeleteList[2] = switchDeleteState(TournPlayerTextViews[2],DeleteList[2]);
            TeamNameInput(2);
        }
        if (v == TournPlayerTextViews[3]){
            //DeleteList[3] = switchDeleteState(TournPlayerTextViews[3],DeleteList[3]);
            TeamNameInput(3);
        }
        if (v == TournPlayerTextViews[4]){
            //DeleteList[4] = switchDeleteState(TournPlayerTextViews[4],DeleteList[4]);
            TeamNameInput(4);
        }
        if (v == TournPlayerTextViews[5]){
            //DeleteList[5] = switchDeleteState(TournPlayerTextViews[5],DeleteList[5]);
            TeamNameInput(5);
        }
        if (v == TournPlayerTextViews[6]){
            //DeleteList[6] = switchDeleteState(TournPlayerTextViews[6],DeleteList[6]);
            TeamNameInput(6);
        }
        if (v == TournPlayerTextViews[7]){
            //DeleteList[7] = switchDeleteState(TournPlayerTextViews[7],DeleteList[7]);
            TeamNameInput(7);
        }
        /*
        if (v == TournPlayerTextViews[8]){
            DeleteList[8] = switchDeleteState(TournPlayerTextViews[8],DeleteList[8]);
        }
        if (v == TournPlayerTextViews[9]){
            DeleteList[9] = switchDeleteState(TournPlayerTextViews[9],DeleteList[9]);
        }
        if (v == TournPlayerTextViews[10]){
            DeleteList[10] = switchDeleteState(TournPlayerTextViews[10],DeleteList[10]);
        }
        if (v == TournPlayerTextViews[11]){
            DeleteList[11] = switchDeleteState(TournPlayerTextViews[11],DeleteList[11]);
        }
        if (v == TournPlayerTextViews[12]){
            DeleteList[12] = switchDeleteState(TournPlayerTextViews[12],DeleteList[12]);
        }
        if (v == TournPlayerTextViews[13]){
            DeleteList[13] = switchDeleteState(TournPlayerTextViews[13],DeleteList[13]);
        }
        if (v == TournPlayerTextViews[14]){
            DeleteList[14] = switchDeleteState(TournPlayerTextViews[14],DeleteList[14]);
        }
        if (v == TournPlayerTextViews[15]){
            DeleteList[15] = switchDeleteState(TournPlayerTextViews[15],DeleteList[15]);
        }
        if (v == TournPlayerTextViews[16]){
            DeleteList[16] = switchDeleteState(TournPlayerTextViews[16],DeleteList[16]);
        }
        if (v == TournPlayerTextViews[17]){
            DeleteList[17] = switchDeleteState(TournPlayerTextViews[17],DeleteList[17]);
        }*/

    }
    public void displayPlayers()
    {
        /* RANDOM TEAMS
        for (int i = 0; i < TournamentData.TPlayerCounter; i++)
        {
            TournPlayerTextViews[i].setText(TournamentList.get(i).getPlayerName());
            TournPlayerTextViews[i].setVisibility(View.VISIBLE);

        }
        for (int i = 17; i >= TournamentData.TPlayerCounter; i--){
            TournPlayerTextViews[i].setVisibility(View.GONE);
        }
        */

        if (TournamentData.TeamSize == 2)
        {
            for (int i = 0; i < TournamentData.TPlayerCounter; i++)
            {
                int TextViewCounter = i/2;
                if (i%2 == 0)
                {
                    //int TeamNr = (i / 2) + 1;
                    //String TeamName = "Team " + TeamNr + "\n";
                    int TeamListNr = i/2;
                    String TeamName = TeamNames[TeamListNr]+"\n";
                    TournPlayerTextViews[TextViewCounter].setText(TeamName);
                    TournPlayerTextViews[TextViewCounter].append(TournamentList.get(i).getPlayerName()+"\n");
                    TournPlayerTextViews[TextViewCounter].setVisibility(View.VISIBLE);
                }
                else
                {
                    TournPlayerTextViews[TextViewCounter].append(TournamentList.get(i).getPlayerName()+"\n");
                }
            }
        }

        if (TournamentData.TeamSize == 3)
        {
            for (int i = 0; i < TournamentData.TPlayerCounter; i++)
            {
                int TextViewCounter = i/3;
                if (i%3 == 0)
                {
                    //int TeamNr = (i / 3) + 1;
                    //String TeamName = "Team " + TeamNr + "\n";
                    int TeamListNr = i/3;
                    String TeamName = TeamNames[TeamListNr]+"\n";
                    TournPlayerTextViews[TextViewCounter].setText(TeamName);
                    TournPlayerTextViews[TextViewCounter].append(TournamentList.get(i).getPlayerName()+"\n");
                    TournPlayerTextViews[TextViewCounter].setVisibility(View.VISIBLE);
                }
                else
                {
                    TournPlayerTextViews[TextViewCounter].append(TournamentList.get(i).getPlayerName()+"\n");
                }
            }
        }

        if (TournamentData.TeamSize == 4)
        {
            for (int i = 0; i < TournamentData.TPlayerCounter; i++)
            {
                int TextViewCounter = i/4;
                if (i%4 == 0)
                {
                    //int TeamNr = (i / 4) + 1;
                    //String TeamName = "Team " + TeamNr + "\n";
                    int TeamListNr = i/4;
                    String TeamName = TeamNames[TeamListNr]+"\n";
                    TournPlayerTextViews[TextViewCounter].setText(TeamName);
                    TournPlayerTextViews[TextViewCounter].append(TournamentList.get(i).getPlayerName()+"\n");
                    TournPlayerTextViews[TextViewCounter].setVisibility(View.VISIBLE);
                }
                else
                {
                    TournPlayerTextViews[TextViewCounter].append(TournamentList.get(i).getPlayerName()+"\n");
                }
            }
        }
        for (int i = 17; i >= (((TournamentData.TPlayerCounter -1)/ TournamentData.TeamSize)+1); i--){
            if ( (TournamentData.TPlayerCounter -1) < 0)                               //Wenn Letzter Spieler gelöscht wird
            {
                TournPlayerTextViews[0].setVisibility(View.GONE);
            }
            else
                TournPlayerTextViews[i].setVisibility(View.GONE);
        }

    }
    private void teamSizeToggle (){

        if (TournamentData.TeamSize == 2){

            TeamSizeBtn2.setBackgroundResource(R.drawable.leftbtn_c2);
            TeamSizeBtn3.setBackgroundResource(R.drawable.middlebtn_c1);
            TeamSizeBtn4.setBackgroundResource(R.drawable.rightbtn_c1);
            return;
        }
        if (TournamentData.TeamSize == 3){
            TeamSizeBtn2.setBackgroundResource(R.drawable.leftbtn_c1);
            TeamSizeBtn3.setBackgroundResource(R.drawable.middlebtn_c2);
            TeamSizeBtn4.setBackgroundResource(R.drawable.rightbtn_c1);
            return;
        }
        if (TournamentData.TeamSize == 4){
            TeamSizeBtn2.setBackgroundResource(R.drawable.leftbtn_c1);
            TeamSizeBtn3.setBackgroundResource(R.drawable.middlebtn_c1);
            TeamSizeBtn4.setBackgroundResource(R.drawable.rightbtn_c2);
            return;
        }
    }

    private boolean switchDeleteState(TextView nameX,boolean DeleteX) {             //RANDOM TEAMS
        if (DeleteX == false){
            nameX.setTextColor(Color.parseColor("#0C6D29"));
            return true;
        } else {
            nameX.setTextColor(Color.parseColor("#FFD5B8"));
            return false;
        }
    }

    private boolean readyCheck()
    {
        if (TournamentData.TPlayerCounter%2 != 0)
        {
            Toast.makeText(this, "Spieleranzahl ändern!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TournamentData.TeamSize == 2 && (TournamentData.TPlayerCounter == 16 || TournamentData.TPlayerCounter == 8))
        {
            return true;
        }
        if (TournamentData.TeamSize == 3 && (TournamentData.TPlayerCounter == 24 || TournamentData.TPlayerCounter == 12))
        {
            return true;
        }
        if (TournamentData.TeamSize == 4 && (TournamentData.TPlayerCounter == 32 || TournamentData.TPlayerCounter == 16))
        {
            return true;
        }
        Toast.makeText(this, "Teamgröße oder Spieleranzahl ändern!", Toast.LENGTH_SHORT).show();
        return false;
    }

    private void TeamNameInput (final int TeamListNr)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hier Teamnamen eingeben:");
        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TeamNames[TeamListNr] = input.getText().toString();
                displayPlayers();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
