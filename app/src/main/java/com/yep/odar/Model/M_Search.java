package com.yep.odar.Model;

import android.content.Context;

/**
 * Created by yep on 2017. 9. 28..
 */

public class M_Search {


    String no, contents, del;
    Context context;
    int type;

    public M_Search(Context context, String no, String contents, int type) {
        this.context = context;
        this.contents = contents;
        this.no = no;
        this.type =type;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}