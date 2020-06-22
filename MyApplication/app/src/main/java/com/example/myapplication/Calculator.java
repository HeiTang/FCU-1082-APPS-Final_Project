package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.Format;

public class Calculator extends AppCompatActivity {
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    Button btn_reset, btn_result, btn_add, btn_sub, btn_mul, btn_div , btn_div_2, btn_div_3;
    TextView textView;
    int flag = 0, temp = 0, result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btn_0 = (Button)findViewById(R.id.button_0);
        btn_1 = (Button)findViewById(R.id.button_1);
        btn_2 = (Button)findViewById(R.id.button_2);
        btn_3 = (Button)findViewById(R.id.button_3);
        btn_4 = (Button)findViewById(R.id.button_4);
        btn_5 = (Button)findViewById(R.id.button_5);
        btn_6 = (Button)findViewById(R.id.button_6);
        btn_7 = (Button)findViewById(R.id.button_7);
        btn_8 = (Button)findViewById(R.id.button_8);
        btn_9 = (Button)findViewById(R.id.button_9);
        btn_add = (Button)findViewById(R.id.button_add);
        btn_sub = (Button)findViewById(R.id.button_sub);
        btn_mul = (Button)findViewById(R.id.button_mul);
        btn_div = (Button)findViewById(R.id.button_div);
        btn_result = (Button)findViewById(R.id.button_result);
        btn_reset = (Button)findViewById(R.id.button_reset);
        btn_div_2 = (Button)findViewById(R.id.button_div_2);
        btn_div_3 = (Button)findViewById(R.id.button_div_3);
        textView = (TextView)findViewById(R.id.textViewResult);

        btn_0.setOnClickListener(btnclicklistener);
        btn_1.setOnClickListener(btnclicklistener);
        btn_2.setOnClickListener(btnclicklistener);
        btn_3.setOnClickListener(btnclicklistener);
        btn_4.setOnClickListener(btnclicklistener);
        btn_5.setOnClickListener(btnclicklistener);
        btn_6.setOnClickListener(btnclicklistener);
        btn_7.setOnClickListener(btnclicklistener);
        btn_8.setOnClickListener(btnclicklistener);
        btn_9.setOnClickListener(btnclicklistener);
        btn_add.setOnClickListener(btnclicklistener);
        btn_sub.setOnClickListener(btnclicklistener);
        btn_mul.setOnClickListener(btnclicklistener);
        btn_div.setOnClickListener(btnclicklistener);
        btn_reset.setOnClickListener(btnclicklistener);
        btn_div_2.setOnClickListener(btnclicklistener);
        btn_div_3.setOnClickListener(btnclicklistener);
        btn_result.setOnClickListener(btnclicklistener);

    }

    private View.OnClickListener btnclicklistener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            String cur = textView.getText().toString();

            switch (b_v.getId()) {
                case R.id.button_0:
                    if (cur.equals("0")) break;
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "0");
                    break;
                case R.id.button_1:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "1");
                    break;
                case R.id.button_2:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "2");
                    break;
                case R.id.button_3:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "3");
                    break;
                case R.id.button_4:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "4");
                    break;
                case R.id.button_5:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "5");
                    break;
                case R.id.button_6:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "6");
                    break;
                case R.id.button_7:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "7");
                    break;
                case R.id.button_8:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "8");
                    break;
                case R.id.button_9:
                    if (cur.equals("0")) cur = "";
                    else if (temp == Integer.valueOf(cur).intValue()) cur = "";
                    textView.setText(cur + "9");
                    break;
                case R.id.button_add:
                    temp = Integer.valueOf(cur).intValue();
                    textView.setText(cur);
                    flag = 1;
                    break;
                case R.id.button_sub:
                    temp = Integer.valueOf(cur).intValue();
                    textView.setText(cur);
                    flag = 2;
                    break;
                case R.id.button_mul:
                    temp = Integer.valueOf(cur).intValue();
                    textView.setText(cur);
                    flag = 3;
                    break;
                case R.id.button_div:
                    temp = Integer.valueOf(cur).intValue();
                    textView.setText(cur);
                    flag = 4;
                    break;
                case R.id.button_reset:
                    temp = 0;
                    flag = 0;
                    result = 0;
                    textView.setText("0");
                    break;
                case R.id.button_div_2:
                    if (result == 0) result = (Integer.valueOf(cur).intValue()) / 2;
                    else result = result / 2;
                    textView.setText(String.format("%d", result));
                    break;
                case R.id.button_div_3:
                    if (result == 0) result = (Integer.valueOf(cur).intValue()) / 3;
                    else result = result / 3;
                    textView.setText(String.format("%d", result));
                    break;
                case R.id.button_result:
                    if (flag == 1) {
                        result = temp + Integer.valueOf(cur).intValue();
                    } else if (flag == 2) {
                        result = temp - Integer.valueOf(cur).intValue();
                    } else if (flag == 3) {
                        result = temp * Integer.valueOf(cur).intValue();
                    } else {
                        if (Integer.valueOf(cur).intValue() == 0) {
                            textView.setText("不是數字ㄛ");
                            break;
                        } else {
                            result  = temp / Integer.valueOf(cur).intValue();
                        }
                    }
                    temp = 0;
                    flag = 0;
                    textView.setText(String.format("%d", result));
                    break;
                default:
            }
        }
    };
}