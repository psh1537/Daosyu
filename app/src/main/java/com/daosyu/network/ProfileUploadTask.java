package com.daosyu.network;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by parksh on 2015-12-04.
 */
public class ProfileUploadTask extends AsyncTask<String, Void, Void> {
    HttpURLConnection urlConnection;
    URL url;
    String  charset = "utf-8";
    String host = "http://parksh1537.cafe24.com";

    @Override
    protected Void doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
