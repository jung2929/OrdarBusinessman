package com.yep.odar.Model;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by yep on 2017. 9. 26..
 */

public class M_Main_Home_Viewpager {

    String img, id;
    Drawable temp_img;
    Context context;


//    public M_Main_Home_Viewpager(Context context, String img, String id) {
//        this.context = context;
//        this.img = img;
//        this.id = id;
//    }

        public M_Main_Home_Viewpager(Context context, Drawable img, String id) {
        this.context = context;
        this.temp_img = img;
        this.id = id;
    }
    public String getImg() {
        return img;
    }
    public Drawable getTemp_img() {
        return temp_img;
    }

    public void setTemp_img(Drawable temp_img) {
        this.temp_img = temp_img;
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

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}