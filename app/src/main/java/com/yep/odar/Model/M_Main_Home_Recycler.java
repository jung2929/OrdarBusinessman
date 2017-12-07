package com.yep.odar.Model;

import android.content.Context;

/**
 * Created by yep on 2017. 9. 25..
 */

public class M_Main_Home_Recycler {
    String img, name, price, id;
    Context context;


    public M_Main_Home_Recycler(Context context, String img, String name, String price, String id) {
        this.context = context;
        this.img=img;
        this.name= name;
        this.price=price;
        this.id =id;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

