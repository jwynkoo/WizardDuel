package com.example.jacob.wizardduel;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RulesMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_menu);
        this.setTitle("General and Gameplay Rules");
        TextView rules = (TextView) findViewById(R.id.rules);
        rules.setText("\n\nGeneral Rules:\n" +
                "Number of players: 2\n" +
                "Each player takes turns separately.\nAfter one player's turn, the phone should be handed off.\n" +
                "\n\nGameplay Rules:\n \n" +
                "1. Each Player starts with 100 HP and 10 Mana.\n \n" +
                "2. Players regenerate 10 Mana per turn.\n \n" +
                "3. Every attack spell costs varying amounts of Mana depending on the strength of the spell.\n \n" +
                "4. Shield spells negate all damage, but cost 12 Mana\n \n" +
                "5. Heal spells heal the player for 20 HP.\n \n");
    }
}
