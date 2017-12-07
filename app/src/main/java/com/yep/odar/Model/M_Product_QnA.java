package com.yep.odar.Model;

import android.content.Context;

/**
 * Created by yep on 2017. 9. 28..
 */

public class M_Product_QnA {

    String q_title, q_contents, q_date, q_id;
    String a_title, a_contents, a_date;
    Context context;


    public M_Product_QnA(Context context, String q_title, String q_contents, String q_date, String q_id, String a_title, String a_contents, String a_date) {
        this.context = context;
        this.q_title = q_title;
        this.q_contents = q_contents;
        this.q_date = q_date;
        this.q_id = q_id;
        this.a_title = a_title;
        this.a_contents = a_contents;
        this.a_date = a_date;

    }

    public String getQ_title() {
        return q_title;
    }

    public void setQ_title(String q_title) {
        this.q_title = q_title;
    }

    public String getQ_contents() {
        return q_contents;
    }

    public void setQ_contents(String q_contents) {
        this.q_contents = q_contents;
    }

    public String getQ_date() {
        return q_date;
    }

    public void setQ_date(String q_date) {
        this.q_date = q_date;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getA_title() {
        return a_title;
    }

    public void setA_title(String a_title) {
        this.a_title = a_title;
    }

    public String getA_contents() {
        return a_contents;
    }

    public void setA_contents(String a_contents) {
        this.a_contents = a_contents;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}