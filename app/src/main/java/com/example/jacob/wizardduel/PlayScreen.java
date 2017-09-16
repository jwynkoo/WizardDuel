package com.example.jacob.wizardduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        int player = 2;
        int p1Health = 100;
        int p2Health = 100;
        int p1Mana = 10;
        int p2Mana = 10;
        int maxMana = 100;
        int basic_cost = 0;
        int heavy_cost = 0;
        int dpr_cost = 0;
        int shield_cost = 0;
        int heal_cost = 0;
        boolean gameOver = false;
        final TextView turnID = (TextView)findViewById(R.id.turnID);
        final Button basic_attack = (Button)findViewById(R.id.basic_attack);
        final Button heavy_attack = (Button)findViewById(R.id.heavy_attack);
        final Button dpr_attack = (Button)findViewById(R.id.dpr_attack);
        final Button shield = (Button)findViewById(R.id.shield);
        final Button heal = (Button)findViewById(R.id.heal);

        if(gameOver == false) {
            if(player == 2) {
                turnID.setText("Player 1's Turn");
                player = 1;
            }
            else {
                turnID.setText("Player 2's Turn");
                player = 2;
            }

            basic_attack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });

            heavy_attack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });

            dpr_attack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });

            shield.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });

            heal.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
        }
    }
}