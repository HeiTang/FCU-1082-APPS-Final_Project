package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button Choose, Random, Calc, Vote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        setListeners();
    }

    private void initButton () {
        Choose = (Button)findViewById(R.id.button_choose);
        Random = (Button)findViewById(R.id.button_random);
        Calc = (Button)findViewById(R.id.button_calc);
        Vote = (Button)findViewById(R.id.button_vote);
    }

    private void setListeners () {
        Choose.setOnClickListener(new ChooseClickListener());
        Random.setOnClickListener(new RandomClickListener());
        Calc.setOnClickListener(new CalcClickListener());
        Vote.setOnClickListener(new VoteClickListener());
    }

    private final class ChooseClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            if (Choose == b_v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        }
    }

    private final class RandomClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            if (Random == b_v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, RandomActivity.class);
                startActivity(intent);
            }
        }
    }

    private final class CalcClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            if (Calc == b_v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Calculator.class);
                startActivity(intent);
            }
        }
    }

    private final class VoteClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            if (Vote == b_v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, FutureActivity.class);
                startActivity(intent);
            }
        }
    }
}