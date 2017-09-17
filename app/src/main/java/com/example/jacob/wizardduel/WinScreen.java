package com.example.jacob.wizardduel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);

        Bundle extras = getIntent().getExtras();
        String whatWasSent = extras.getString("KEY");


        this.setTitle("Winner");
        TextView winner = (TextView) findViewById(R.id.display_winner);
        winner.setText(whatWasSent + " is the winner!");

        final Button return_button = (Button)findViewById(R.id.return_button);
        return_button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                Intent showWinner = new Intent(WinScreen.this, MainMenu.class);
                startActivity(showWinner);
            }
        });
    }
}
