package com.yep.odar.Model;

import android.content.Context;

/**
 * Created by yep on 2017. 10. 8..
 */

public class M_Product {

    int type;

    Context context;
    String product_id, product_img, product_name, product_price, product_no;
    String odar_no, odar_date, title;

    String product_date, product_status;

    public M_Product(Context context, int type, String id, String img, String name, String price, String no) {
        this.context = context;
        this.type = type;
        this.product_id = id;
        this.product_img = img;
        this.product_name = name;
        this.product_price = price;
        this.product_no = no;

    }public M_Product(Context context, int type, String id, String img, String name, String price, String no, String odar_no, String date, String title) {
        this.context = context;
        this.type = type;
        this.product_id = id;
        this.product_img = img;
        this.product_name = name;
        this.product_price = price;
        this.product_no = no;
        this.odar_no = odar_no;
        this.odar_date = date;
        this.title = title;

    }
    public M_Product(Context context, int type, String date,String odar_no) {
        this.context = context;
        this.type = type;
        this.odar_no = odar_no;
        this.odar_date = date;
    }
    public M_Product(Context context, int type, String id, String img, String name, String price, String date, String status) {
        this.context = context;
        this.type = type;
        this.product_id = id;
        this.product_img = img;
        this.product_name = name;
        this.product_price = price;
        this.product_status = status;
        this.product_date = date;

    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_no() {
        return product_no;
    }

    public void setProduct_no(String product_no) {
        this.product_no = product_no;
    }

    public String getOdar_no() {
        return odar_no;
    }

    public void setOdar_no(String odar_no) {
        this.odar_no = odar_no;
    }

    public String getOdar_date() {
        return odar_date;
    }

    public void setOdar_date(String odar_date) {
        this.odar_date = odar_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
