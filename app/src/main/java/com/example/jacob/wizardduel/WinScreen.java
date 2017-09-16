package com.example.jacob.wizardduel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_screen);
        this.setTitle("Winner");
        TextView winner = (TextView) findViewById(R.id.display_winner);
        winner.setText("is the winner!");
    }
}