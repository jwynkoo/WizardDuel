package com.example.jacob.wizardduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayScreen extends AppCompatActivity {

    int player = 1;
    int p1Health = 100;
    int p2Health = 100;
    int p1Mana = 10;
    int p2Mana = 10;
    int maxMana = 100;
    int basic_cost = 0;
    int basic_damage = 1;
    int heavy_cost = 30;
    int heavy_damage = 25;
    int dpr_cost = 0;
    int dpr_base_damage = 0;
    int dpr_round_damage = 0;
    int dpr_rounds_left = 0;
    boolean p1_dpr = false;
    boolean p2_dpr = false;
    int shield_cost = 0;
    boolean shield_status = false;
    int heal_cost = 0;
    int heal_effect = 5;
    final int mana_per_round = 5;
    boolean turnOver = false;
    boolean gameOver = false;
    int refresh = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);

        final Button basic_attack = (Button) findViewById(R.id.basic_attack);
        final Button heavy_attack = (Button) findViewById(R.id.heavy_attack);
        final Button dpr_attack = (Button) findViewById(R.id.dpr_attack);
        final Button shield = (Button) findViewById(R.id.shield);
        final Button heal = (Button) findViewById(R.id.heal);
        final Button do_nothing = (Button)findViewById(R.id.do_nothing);

        updateUI(p1Health, p2Health);

        basic_attack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player == 1 && checkForCost(basic_cost, p1Mana)) || (player == 2 && checkForCost(basic_cost, p2Mana))) {
                    if (!checkShield(shield_status)) {
                        if (player == 1) {
                            p2Health -= basic_damage;
                        } else {
                            p1Health -= basic_damage;
                        }
                    } else {
                        turnOffShield();
                    }
                    if (player == 1) {
                        p1Mana -= basic_cost;
                    } else {
                        p2Mana -= basic_cost;
                    }
                    turnOver = true;
                    Toast toast = Toast.makeText(getApplicationContext(), "Used " + basic_cost + " mana and did " + basic_damage + " damage.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                    updateUI(p1Health, p2Health);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Not enough mana, lose a turn", Toast.LENGTH_SHORT);
                    toast.show();
                    turnOver = true;
                    updateUI(p1Health, p2Health);
                }
            }
        });

        heavy_attack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player == 1 && checkForCost(heavy_cost, p1Mana)) || (player == 2 && checkForCost(heavy_cost, p2Mana))) {
                    if (!checkShield(shield_status)) {
                        if (player == 1) {
                            p2Health -= heavy_damage;
                        } else {
                            p1Health -= heavy_damage;
                        }
                    } else {
                        turnOffShield();
                    }
                    if (player == 1) {
                        p1Mana -= heavy_cost;
                    } else {
                        p2Mana -= heavy_cost;
                    }
                    turnOver = true;
                    Toast toast = Toast.makeText(getApplicationContext(), "Used " + heavy_cost + " mana and did " + heavy_damage + " damage.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                    updateUI(p1Health, p2Health);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Not enough mana, lose a turn", Toast.LENGTH_SHORT);
                    toast.show();
                    turnOver = true;
                    updateUI(p1Health, p2Health);
                }
            }
        });

        dpr_attack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player == 1 && checkForCost(dpr_cost, p1Mana)) || (player == 2 && checkForCost(dpr_cost, p2Mana))) {
                    if (!checkShield(shield_status)) {
                        dpr_rounds_left = 6;
                        if (player == 1) {
                            p2Health -= dpr_base_damage;
                            p2_dpr = true;
                        } else {
                            p1Health -= dpr_base_damage;
                            p2_dpr = true;
                        }
                        dpr_rounds_left -= 1;
                    } else {
                        turnOffShield();
                    }
                    if (player == 1) {
                        p1Mana -= dpr_cost;
                    } else {
                        p2Mana -= dpr_cost;
                    }
                    turnOver = true;
                    Toast toast = Toast.makeText(getApplicationContext(), "Used " + dpr_cost + " mana and did " + dpr_base_damage + " damage. Will do " + dpr_round_damage + " for " + dpr_rounds_left + " rounds.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                    updateUI(p1Health, p2Health);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Not enough mana, lose a turn", Toast.LENGTH_SHORT);
                    toast.show();
                    turnOver = true;
                    updateUI(p1Health, p2Health);
                }
            }
        });

        shield.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player == 1 && checkForCost(shield_cost, p1Mana)) || (player == 2 && checkForCost(shield_cost, p2Mana))) {
                    shield_status = true;
                    if (player == 1) {
                        p1Mana -= shield_cost;
                    } else {
                        p2Mana -= shield_cost;
                    }
                    turnOver = true;
                    Toast toast = Toast.makeText(getApplicationContext(), "Used " + shield_cost + " mana and blocked next round.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                    updateUI(p1Health, p2Health);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Not enough mana, lose a turn", Toast.LENGTH_SHORT);
                    toast.show();
                    turnOver = true;
                    updateUI(p1Health, p2Health);
                }
            }
        });

        heal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((player == 1 && checkForCost(heal_cost, p1Mana)) || (player == 2 && checkForCost(heal_cost, p2Mana))) {
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
                    if (player == 1) {
                        p1Mana -= heal_cost;
                    } else {
                        p2Mana -= heal_cost;
                    }
                    turnOver = true;
                    Toast toast = Toast.makeText(getApplicationContext(), "Used " + heal_cost + " mana and regained " + heal_effect + " health.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 0);
                    toast.show();
                    updateUI(p1Health, p2Health);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Not enough mana, lose a turn", Toast.LENGTH_SHORT);
                    toast.show();
                    turnOver = true;
                    updateUI(p1Health, p2Health);
                }
            }
        });

        do_nothing.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                turnOver = true;
                Toast toast = Toast.makeText(getApplicationContext(), "Did nothing", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
                updateUI(p1Health, p2Health);
            }
        });
    }

    void updateUI(int p1Health, int p2Health) {
        final TextView turnID = (TextView) findViewById(R.id.turnID);
        final TextView stats = (TextView) findViewById(R.id.stats);

        if (p1Health <= 0) {
            //print Player 2 wins
            gameOver = true;
            Intent whoWon = new Intent(PlayScreen.this, WinScreen.class);
            whoWon.putExtra("KEY", "Player 2");
            startActivity(whoWon);
        } else if (p2Health <= 0) {
            //print Player 1 wins
            gameOver = true;
            Intent whoWon = new Intent(PlayScreen.this, WinScreen.class);
            whoWon.putExtra("KEY", "Player 2");
            startActivity(whoWon);
        }

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


        if (player == 1) {
            turnID.setText("Player 1's Turn");
            checkForDPR(p1_dpr);
        } else {
            turnID.setText("Player 2's Turn");
            checkForDPR(p2_dpr);
        }
        stats.setText("P1 Health: " + p1Health + "/100\n" + "P1 Mana: " + p1Mana + "/100\n" + "P2 Health: " + p2Health + "/100\n" + "P2 Mana: " + p2Mana + "/100\n");
    }

    void checkForDPR(boolean status) {
        if (status) {
            if (player == 1) {
                p1Health -= dpr_round_damage;
                dpr_rounds_left -= 1;
                if (dpr_rounds_left == 0) {
                    p1_dpr = false;
                }
            } else {
                p2Health -= dpr_round_damage;
                dpr_rounds_left -= 1;
                if (dpr_rounds_left == 0) {
                    p2_dpr = false;
                }
            }
            if (p1Health <= 0) {
                //player 2 wins
                System.exit(0);
            } else if (p2Health <= 0) {
                //player 1 wins
                System.exit(0);
            }
        }
    }

    boolean checkForCost(int cost, int have) {
        if (cost < have) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkShield(boolean s) {
        return s;
    }

    void turnOffShield() {
        shield_status = false;
    }
}
