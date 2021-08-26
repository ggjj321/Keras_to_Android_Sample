package com.example.keras_to_android_sample;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out
                .println(jsonGetRequest("http://server.org/weather?q=New York&format=json"));
    }

    private static String streamToString(InputStream inputStream) {
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    public static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
public class MainActivityigc extends AppCompatActivity {
    String url;
    TextView t01;
    Thread th;
    String food;
    String te01,te02;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activityigc);
        t01 = (TextView) this.findViewById(R.id.t01);

        Bundle bundle = getIntent().getExtras();
        food = bundle.getString("message");

        //location = "yolk_pastry";
        th = new Thread(catch_data);  //執行緒
        th.start();
    }

    private Runnable catch_data = new Runnable(){
        public void run() {
            try {
                URL url = new URL("https://www.instagram.com/explore/tags/\" + food + \"/?__a=1");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
//                int responsecode = conn.getResponseCode();
//                if (responsecode != 200) {
//                    throw new RuntimeException("HttpResponseCode: " + responsecode);
//                } else {
//
//                    String inline = "";
//                    Scanner scanner = new Scanner(url.openStream());
//
//                    //Write all the JSON data into a string using a scanner
//                    while (scanner.hasNext()) {
//                        inline += scanner.nextLine();
//                    }
//
//                    //Close the scanner
//                    scanner.close();
//
//                    //Using the JSON simple library parse the string into a json object
//                    JSONParser parse = new JSONParser();
//                    JSONObject data_obj = (JSONObject) parse.parse(inline);
//
//                    //Get the required object from the above created object
//                    JSONObject obj = (JSONObject) data_obj.get("Global");
//
//                    //Get the required data using its key
//                    System.out.println(obj.get("TotalRecovered"));
//                }

//                data = Main.jsonGetRequest(url);
//                JSONObject jsonObject = new JSONObject(data);
//                String picUrl = jsonObject.getString("profile_pic_url");
//                t01.append(picUrl);
//                Document doc_bread_pudding = Jsoup.parse(url, 3000);        //連結該網址
//                Elements subtitle_bread_pudding = doc_bread_pudding.select("div.ingredients-groups div.group");
//                for (int i = 0; i < subtitle_bread_pudding.size(); i++) {
//                    te02 = subtitle_bread_pudding.get(i).text();
//                    runOnUiThread(new Runnable() {
//                        public void run() {
//                            t01.append("\n" + te02 + "\n");
//                        }
//                    });
//                    Thread.sleep(100);
//                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                t01.append("error");
            }
        }
    };
}