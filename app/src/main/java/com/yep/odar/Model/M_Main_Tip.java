package com.yep.odar.Model;

import android.content.Context;

/**
 * Created by yep on 2017. 9. 28..
 */

public class M_Main_Tip {


    String img, title, date, like, id;
    Context context;


    public M_Main_Tip(Context context, String img, String title, String date, String like, String id) {
        this.context = context;
        this.img = img;
        this.date = date;
        this.title = title;
        this.like = like;
        this.id = id;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}