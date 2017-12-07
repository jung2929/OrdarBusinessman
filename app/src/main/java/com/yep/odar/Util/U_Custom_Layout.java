package com.yep.odar.Util;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;

/**
 * Created by yep on 2017. 9. 30..
 */

public class U_Custom_Layout extends LinearLayoutManager{
    private  boolean isEnsblaVerticalScrolling=false;
    public U_Custom_Layout(Context context){
        super(context);
    }
    public U_Custom_Layout(Context context, int ori, boolean reverse){
        super(context, ori, reverse);
    }
    public U_Custom_Layout(Context context, AttributeSet attrs, int def , int deff){
        super(context, attrs, def,deff);
    }
    public void setEnablesVerticalScrolling(boolean b){
        isEnsblaVerticalScrolling=b;
    }
    @Override
    public boolean canScrollVertically(){
        return isEnsblaVerticalScrolling&&super.canScrollVertically();
    }

}
