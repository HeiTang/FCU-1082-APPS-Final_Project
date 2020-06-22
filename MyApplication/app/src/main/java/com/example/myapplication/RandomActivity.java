package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class RandomActivity extends AppCompatActivity {

    public class shop {
        String name;
        double latitude;
        double longitude;

        public shop (String name, double latitude, double longitude) {
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getName () {
            return name;
        }

        public double getLatitude () {
            return latitude;
        }

        public double getLongitude () {
            return longitude;
        }
    }

    Button ok, again;
    TextView result;
    int[] resIDs;
    shop[] shops;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        initData();
        initButton();
        setListeners();
        index = (int)(Math.random() * 10) % 10;
        result.setText(shops[index].getName());
    }

    private void initData () {
        resIDs = new int[] { R.drawable.aa, R.drawable.bb, R.drawable.cc };
        shop shop1 = new shop("麥當勞", 24.179, 120.646);
        shop shop2 = new shop("肯德基", 24.183, 120.646);
        shop shop3 = new shop("小辣椒", 24.179, 120.646);
        shop shop4 = new shop("八方雲集",24.176,120.650);
        shop shop5 = new shop("泰神打拋豬",24.182,120.647);
        shop shop6 = new shop("吉野烤肉飯",24.180,120.646);
        shop shop7 = new shop("小紅帽韓式烤肉",24.180,120.646);
        shop shop8 = new shop("擄胃專家",24.180,120.645);
        shop shop9 = new shop("紅黑咖哩",24.181,120.646);
        shop shop10 = new shop("黑豬咖哩",24.182,120.646);

        shops = new shop[] { shop1, shop2, shop3, shop4, shop5, shop6, shop7, shop8, shop9, shop10 };
    }

    private void initButton () {
        ok = (Button)findViewById(R.id.button_ok);
        again = (Button)findViewById(R.id.button_again);
        result = (TextView)findViewById(R.id.random_result);
    }

    private void setListeners () {
        ok.setOnClickListener(new okClickListener());
        again.setOnClickListener(new againClickListener());
    }

    private final class okClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            if (ok == b_v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                String result = String.valueOf(index);
                intent.setClass(RandomActivity.this, MapsActivity.class);
                bundle.putString("Result", result);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        }
    }

    private final class againClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Button b_v = (Button)view;
            if (again == b_v) {
                int index = (int)(Math.random() * 10) % 10;
                result.setText(shops[index].getName());
            }
        }
    }
}