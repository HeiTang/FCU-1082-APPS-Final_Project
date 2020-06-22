package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        TextView Result = (TextView)findViewById(R.id.Result_text);
        Bundle bundle = this.getIntent().getExtras();
        String get_text = bundle.getString("Result");
        Result.setText(get_text);
    }
}