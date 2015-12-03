package com.daosyu.mainview;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by parksh on 2015-11-25.
 */
public class NewsData {
    private int profile_image, news_image;
    private String profile_name;
    private String news_regdate;
    private String news_title;

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public int getNews_image() {
        return news_image;
    }

    public void setNews_image(int news_image) {
        this.news_image = news_image;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }

    public String getNews_regdate() {
        return news_regdate;
    }

    public void setNews_regdate(String news_regdate) {
        this.news_regdate = news_regdate;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }
}
