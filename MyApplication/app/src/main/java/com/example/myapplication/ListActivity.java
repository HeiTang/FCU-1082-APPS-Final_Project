package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

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

    ListView listview;
    int[] resIDs;
    shop[] shops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initData();
        initListView();
    }

    private void initData () {
//        shop_name = new String[] { "麥當勞", "肯德基", "小辣椒", "八方雲集", "泰神打拋豬", "吉野烤肉飯", "小紅帽韓式烤肉", "擄胃專家", "紅黑咖哩", "黑豬咖哩" };
//        latitudes = new double[] { 24.179, 24.183, 24.179, 24.176, 24.182, 24.180, 24.180, 24.180, 24.181, 24.182 };
//        longitudes = new double[] { 120.646, 120.646, 120.646, 120.650, 120.647, 120.646, 120.646, 120.645, 120.646, 120.646 };
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

    private void initListView () {
        listview = (ListView)findViewById(R.id.list);
        MyAdapter myAdapter = new MyAdapter(this);
        listview.setAdapter(myAdapter);
        listview.setOnItemClickListener(new MyOnItemClickListener());
    }

    private final class MyOnItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String result = adapterView.getItemAtPosition(i).toString();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            intent.setClass(ListActivity.this, MapsActivity.class);
            bundle.putString("Result", result);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;

        public MyAdapter (Context c) {
            layoutInflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount() {
            return shops.length;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = layoutInflater.inflate(R.layout.list_layout, null);

//            ImageView img = (ImageView)view.findViewById(R.id.img1);
            TextView first_text = (TextView)view.findViewById(R.id.first_text);
            TextView second_text = (TextView)view.findViewById(R.id.second_text);
            TextView third_text = (TextView)view.findViewById(R.id.third_text);

//            img.setImageResource(resIDs[i]);
            first_text.setText(shops[i].getName());
            second_text.setText("經度：" + shops[i].getLatitude());
            third_text.setText(", 緯度：" + shops[i].getLongitude());
            return view;
        }
    }
}