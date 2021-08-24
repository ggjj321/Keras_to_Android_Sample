package com.example.keras_to_android_sample;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main3Activity extends AppCompatActivity {

    Button buttonMap;
    Button buttonRecipe;
    Button buttonRecommd;



    String urlRecipe, urlRecommd;
    TextView t01,t02,txt1;
    Thread th;
    String location;
    String foodName;
    String te01,te02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonMap = (Button) findViewById(R.id.button1);
        buttonRecipe = (Button) findViewById(R.id.button2);


        //傳送資料到Activity3
        Bundle bundle = getIntent().getExtras();
        location = bundle.getString("message");

        //location = "yolk_pastry";
        //txt1.setText(location);
        th = new Thread(catch_data);  //執行緒
        th.start();

        buttonMap.setOnClickListener(new OnClickListener() {
            //跳轉食譜
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(foodName));
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        buttonRecipe.setOnClickListener(new OnClickListener() {
            //跳轉食譜
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("message", urlRecipe);
                intent.putExtras(bundle);
                intent.setClass(Main3Activity.this, Main4Activity.class);
                //跳轉到Main3Activity
                startActivity(intent);
            }
        });

    }
    private Runnable catch_data = new Runnable(){
        public void run(){
            try {

                switch (location)
                {
                    case "apple_pie" :
                        foodName = "蘋果派";
                        //recipe
                        urlRecipe = "https://a9556330.pixnet.net/blog/post/120768336-apple-pie";
                        urlRecommd = "https://ifoodie.tw/explore/list/%E8%98%8B%E6%9E%9C%E6%B4%BE?sortby=popular";
                        break;

                    case "baby_back_ribs" :
                        foodName = "美式烤肋排";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/320467";
                        urlRecommd = "https://ifoodie.tw/explore/list/%E7%83%A4%E8%82%8B%E6%8E%92?sortby=popular";
                        break;

                    case "bawan" :
                       foodName = "肉圓";
                       //recipe
                       urlRecipe = "https://icook.tw/recipes/193513";
                       break;

                    case "beef_carpaccio" :
                        foodName = "beef_carpaccio";
                        //recipe
                        urlRecipe = "https://www.japancentre.com/zh/recipes/1318-beef-tataki";
                        break;

                    case "beef_noodles" :
                        foodName = "beef_noodles";
                        //recipe
                        urlRecipe = "https://www.how-living.com/p/15335/%e6%af%94%e5%86%a0%e8%bb%8d%e5%90%8d%e5%ba%97%e9%82%84%e5%a5%bd%e5%90%83%ef%bc%81%e8%bf%b7%e4%ba%ba%e9%a3%84%e9%a6%99%e3%80%90%e7%95%aa%e8%8c%84%e7%b4%85%e7%87%92%e7%89%9b%e8%82%89%e9%ba%b5%e3%80%91";
                        break;

                    case "beef_tartare" :
                        foodName = "beef_tartare";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/207010";
                        break;

                    case "bibimbap" :
                        foodName = "bibimbap";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/328341";
                        break;

                    case "bitter_melon_with_salted_eggs" :
                        foodName = "bitter_melon_with_salted_eggs";
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/316807";
                        break;
                }

            }

            catch (Exception e){
            }
        }
    };

}
