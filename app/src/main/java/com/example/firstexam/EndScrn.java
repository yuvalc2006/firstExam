package com.example.firstexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EndScrn extends AppCompatActivity {
    boolean DidWin;
    TextView WOL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_scr);
        Intent intent = getIntent();
        WOL = findViewById(R.id.win_or_lose);
        DidWin = intent.getExtras().getBoolean("DidWin");
        if (DidWin == true){
            WOL.setText("YOU WON");
        }
        else{
            WOL.setText("YOU LOST");
        }
    }
}