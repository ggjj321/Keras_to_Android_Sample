package com.example.keras_to_android_sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator {

    public static void main(String[] args) throws IOException {
        String url = ("https://icook.tw/recipes/140671");
        //Translated text: Hallo Welt!
        //System.out.println("Translated text: " + translate("zh-TW", "en", url));
        String encodedURL = URLEncoder.encode(url, "UTF-8");

        // 輸出結果
        System.out.println(encodedURL);
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycby-Vi39QjskRs78jAWD8sUZW-gpy8Kg8RviPXup4u1cLGxxdP6i/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}