package com.example.keras_to_android_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
// 食譜
public class Main4Activity extends AppCompatActivity {
    URL url;
    TextView t01;
    Thread th;
    String weblocation;
    String te01,te02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        t01 = (TextView) this.findViewById(R.id.t01);

        Bundle bundle = getIntent().getExtras();
        weblocation = bundle.getString("message");

        //location = "yolk_pastry";
        th=new Thread(catch_data);  //執行緒
        th.start();
    }

    private Runnable catch_data = new Runnable(){
        public void run() {
            try {
                url = new URL(weblocation);
                Document doc_bread_pudding = Jsoup.parse(url, 3000);        //連結該網址
                Elements subtitle_bread_pudding = doc_bread_pudding.select("div.ingredients-groups div.group");
                for (int i = 0; i < subtitle_bread_pudding.size(); i++) {
                    te02 = subtitle_bread_pudding.get(i).text();
                    runOnUiThread(new Runnable() {
                        public void run() {
                            t01.append("\n" + te02 + "\n");
                        }
                    });
                    Thread.sleep(100);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                t01.append("error");
            }
        }
    };
}