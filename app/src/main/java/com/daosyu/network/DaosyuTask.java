package com.daosyu.network;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import daosyu.com.snslogin.MemberActivity;

/**
 * Created by parksh on 2015-12-08.
 */
public class DaosyuTask extends AsyncTask<String, Void, Object>{
    URL url;
    String host = "http://70.12.109.73:9090";
    String TAG = this.getClass().getName();
    HttpURLConnection con;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(String... params) {
        StringBuffer sb = new StringBuffer();

        try {
            url = new URL(host + params[0]);
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form/urlencoded");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            writer.append(params[1]);
            writer.flush();
            writer.close();

            int resonseCode = 0;
            con.getResponseCode(); //요청이 시작된다..

            if(resonseCode == HttpURLConnection.HTTP_OK){
                BufferedReader buffr = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String data = null;

                while (true){
                    data = buffr.readLine();
                    if(data == null)break;
                    sb.append(data);
                }

                buffr.close();
                con.disconnect();

                JSONObject jsonObject = new JSONObject();
                String resultData = jsonObject.getString("resultData");

                Log.d(TAG, resultData);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object obj) {
        //회원가입 처리하기...
        super.onPostExecute(obj);

        try {
            JSONObject jsonObject = new JSONObject((String)obj);
            String requestCode = jsonObject.getString("requestCode");

            switch (requestCode){
                case "insert":
                    break;

                case "selectAll":
                    break;

                case "select":
                    break;

                case "update":
                    break;

                case "delete":
                    break;

                case "loginCheck":
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    //뷰 처리 메소드 정의
    public void insertView(Object obj){

    }

    public void selectAllView(Object obj){

    }

    public void selectView(Object obj){

    }

    public void updateView(Object obj){

    }

    public void deleteView(Object obj){

    }

    public void loginCheckView(Object obj){

    }
}
