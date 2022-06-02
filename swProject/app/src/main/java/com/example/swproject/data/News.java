package com.example.swproject.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.ZonedDateTime;

public class News {
    private String url_;
    private String title_;
    private ZonedDateTime time_;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public News(){
        url_ ="";
        title_ = "";
        time_ = ZonedDateTime.now();
    }

    public void SetUrl(String url){ this.url_ = url; }

    public void SetTitle(String title){ this.title_ = title; }

    public void SetTime(ZonedDateTime time) { this.time_ = time; }

    public String GetUrl() { return this.url_; }

    public String GetTitle() { return this.title_; }

    public ZonedDateTime GetTime() { return this.time_; }
}
