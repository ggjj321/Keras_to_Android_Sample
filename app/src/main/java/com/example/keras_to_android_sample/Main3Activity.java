package com.example.keras_to_android_sample;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    String te01,te02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        buttonMap = (Button) findViewById(R.id.button1);
        buttonRecipe = (Button) findViewById(R.id.button2);
        buttonRecommd = (Button) findViewById(R.id.button3);


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
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("message", urlRecipe);
                intent.putExtras(bundle);
                intent.setClass(Main3Activity.this, Main4Activity.class);
                //跳轉到Main3Activity
                startActivity(intent);
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

        buttonRecommd.setOnClickListener(new OnClickListener() {
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
                        //recipe
                        urlRecipe = "https://a9556330.pixnet.net/blog/post/120768336-apple-pie";
                        urlRecommd = "https://ifoodie.tw/explore/list/%E8%98%8B%E6%9E%9C%E6%B4%BE?sortby=popular";
                        break;

                    case "baby_back_ribs" :
                        //recipe
                        urlRecipe = "https://icook.tw/recipes/320467";
                        urlRecommd = "https://ifoodie.tw/explore/list/%E7%83%A4%E8%82%8B%E6%8E%92?sortby=popular";
                        break;

                   case "bawan" :

                       //recipe
                       urlRecipe = "https://icook.tw/recipes/193513";
                       urlRecommd = "https://ifoodie.tw/explore/list/%E8%82%89%E5%9C%93?sortby=popular";
                       break;


                }

            }

            catch (Exception e){
            }
        }
    };

}
