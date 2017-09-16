package com.example.jacob.wizardduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayScreen extends AppCompatActivity {

    int player = 1;
    int p1Health = 100;
    int p2Health = 100;
    int p1Mana = 10;
    int p2Mana = 10;
    int maxMana = 100;
    int basic_cost = 0;
    int basic_damage = 0;
    int heavy_cost = 0;
    int heavy_damage = 0;
    int dpr_cost = 0;
    int dpr_base_damage = 0;
    int dpr_round_damage = 0;
    int dpr_rounds_left = 0;
    int shield_cost = 0;
    boolean shield_status = false;
    int heal_cost = 0;
    int heal_effect = 0;
    final int mana_per_round = 0;
    boolean turnOver = false;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        final TextView turnID = (TextView) findViewById(R.id.turnID);
        final Button basic_attack = (Button) findViewById(R.id.basic_attack);
        final Button heavy_attack = (Button) findViewById(R.id.heavy_attack);
        final Button dpr_attack = (Button) findViewById(R.id.dpr_attack);
        final Button shield = (Button) findViewById(R.id.shield);
        final Button heal = (Button) findViewById(R.id.heal);
        final TextView stats = (TextView) findViewById(R.id.stats);
        gameLoop:
        if (gameOver == false) {
            if (player == 1) {
                turnID.setText("Player 1's Turn");
            } else {
                turnID.setText("Player 2's Turn");
            }
            if (player == 1) {
                stats.setText("Health: " + p1Health + "/100\n" + "Mana: " + p1Mana + "/100");
            }

            else {
                stats.setText("Health: " + p2Health+ "/100\n" + "Mana: " + p2Mana + "/100");
            }

            basic_attack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!checkShield(shield_status)) {
                        if (player == 1) {
                            p2Health -= basic_damage;
                        } else {
                            p1Health -= basic_damage;
                        }
                    }
                    turnOver = true;
                }
            });

            heavy_attack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!checkShield(shield_status)) {
                        if (player == 1) {
                            p2Health -= heavy_damage;
                        } else {
                            p1Health -= heavy_damage;
                        }
                    }
                    turnOver = true;
                }
            });

            dpr_attack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (!checkShield(shield_status)) {
                        if (player == 1) {
                            p2Health -= dpr_base_damage;
                        } else {
                            p1Health -= dpr_base_damage;
                        }
                        dpr_rounds_left -= 1;
                    }
                    turnOver = true;
                }
            });

            shield.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    shield_status = true;
                    turnOver = true;
                }
            });

            heal.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (player == 1) {
                        p1Health += heal_effect;
                        if (p1Health > 100) {
                            p1Health = 100;
                        }
                    } else {
                        p2Health += heal_effect;
                        if (p2Health > 100) {
                            p2Health = 100;
                        }
                    }
                    turnOver = true;
                }
            });

            if (p1Health == 0) {
                //print Player 2 wins
                gameOver = true;
            } else if (p2Health == 0) {
                //print Player 1 wins
                gameOver = true;
            } else {
                if (turnOver && player == 1) {
                    p1Mana += mana_per_round;
                    if (p1Mana > maxMana) {
                        p1Mana = maxMana;
                    }
                    player = 2;
                } else if (turnOver && player == 2) {
                    p2Mana += mana_per_round;
                    if (p2Mana > maxMana) {
                        p2Mana = maxMana;
                    }
                    player = 1;
                }
            }
        }
    }

    boolean checkShield(boolean s) {
        return s;
    }

    boolean setShield(boolean s) {
        s = false;
        return s;
    }
}
