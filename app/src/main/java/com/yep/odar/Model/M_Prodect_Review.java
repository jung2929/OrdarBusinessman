package com.yep.odar.Model;

import android.content.Context;

/**
 * Created by yep on 2017. 9. 28..
 */

public class M_Prodect_Review {

    String img, id, date, contents, title;
    Context context;


    public M_Prodect_Review(Context context, String img, String title, String id, String date, String contents) {
        this.context = context;
        this.img = img;
        this.date = date;
        this.title = title;
        this.contents = contents;
        this.id = id;

    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}