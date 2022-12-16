package com.example.firstexam;

import java.util.*;
import java.io.*;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.Random;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText letters;
    TextView word;
    String[] words;
    boolean DidWin;
    int randint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        randint = rand.nextInt((10 - 1) + 1);
        letters = findViewById(R.id.letters);
        word = findViewById(R.id.word);
        Intent intent = new Intent(MainActivity.this, EndScrn.class);
        DidWin = true;
        words = new String[]{"balloon", "anxiety", "chapter", "extreme", "factory", "licence", "program", "support", "welcome", "traffic"};
        String str = words[randint];
        Button button = (Button) findViewById(R.id.button);
        str = getScrambled(str);
        word = findViewById(R.id.word);
        word.setText("word: "+str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (letters.getText().toString().equals(words[randint])) {
                    intent.putExtra("DidWin", true);
                } else {
                    intent.putExtra("DidWin", false);
                }
                startActivity(intent);
            }
        });
    }
    public static String getScrambled(String s) {
        String[] scram = s.split("");
        List<String> letters = Arrays.asList(scram);
        Collections.shuffle(letters);
        StringBuilder sb = new StringBuilder(s.length());
        for (String c : letters) {
            sb.append(c);
        }
        return sb.toString();
    }
}