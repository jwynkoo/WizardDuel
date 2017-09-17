package com.example.jacob.wizardduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        final Button gotoPlay = (Button) findViewById(R.id.gotoPlay);
        gotoPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goPlay = new Intent(MainMenu.this, PlayScreen.class);
                startActivity(goPlay);
            }
        });

        final Button gotoPlayGestures = (Button) findViewById(R.id.gotoPlayGestures);
        gotoPlayGestures.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goPlayGestures = new Intent(MainMenu.this, GesturePlayScreen.class);
                startActivity(goPlayGestures);
            }
        });

        final Button gotoRules = (Button) findViewById(R.id.gotoRules);
        gotoRules.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent goRules = new Intent(MainMenu.this, RulesMenu.class);
                startActivity(goRules);
            }
        });

    }
}
