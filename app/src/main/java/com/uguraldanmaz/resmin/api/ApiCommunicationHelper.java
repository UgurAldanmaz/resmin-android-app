package com.uguraldanmaz.resmin.api;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ugur Aldanmaz on 10.01.2016 14:25.
 */
public class ApiCommunicationHelper {

    private static final String API_ADDRESS = "https://staging.resm.in/v2/";

    public static JSONObject get(String address) {
        try {
            URL url = new URL(API_ADDRESS + address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp = reader.readLine()) != null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());
            return data;
        } catch (Exception e) {
            return null;
        }
    }
}
