package com.example.anotherfailedproject;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class D_RandomGame extends AppCompatActivity implements View.OnClickListener{

    private TextInputEditText nameInput;
    private Button toggle2, toggle3, toggle4, startBTN, addButton;
    private LinearLayout.LayoutParams paramsX;
    private LinearLayout linLay;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d__random_game);

        nameInput = findViewById(R.id.DRG_nameInput);
        toggle2 = findViewById(R.id.DRG_BTN2);
        toggle3 = findViewById(R.id.DRG_BTN3);
        toggle4 = findViewById(R.id.DRG_BTN4);
        startBTN = findViewById(R.id.DRG_startBTN);
        addButton = findViewById(R.id.DRG_addBTN);

        linLay = findViewById(R.id.DRG_linLayout);
        paramsX = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        //GameData.CasualGameList = new ArrayList<>();

        addButton.setOnClickListener(this);
    }

    private void addName() {

        if(nameInput.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Namen eingeben!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            String tempName = nameInput.getText().toString().trim();
            TextView name = new TextView(this);
            name.setText(tempName);
            name.setTextAppearance(R.style.TextViewStyle_Standard);
            name.setLayoutParams(paramsX);
            linLay.addView(name);
            nameInput.setText("");
            /*namesX[i].setText(tempName);
            namesX[i].setTextAppearance(R.style.TextViewStyle_Standard);
            namesX[i].setLayoutParams(paramsX);
            linLay.addView(namesX[i]);
            i++;
            nameInput.setText("");*/
            return;
        }
    }

    @Override
    public void onClick(View v) {
        if(v == addButton){
            addName();
        }
    }
}
