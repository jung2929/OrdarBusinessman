package com.yep.odar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.yep.odar.Model.M_Main_Home_Viewpager;
import com.yep.odar.R;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 26..
 */

public class A_Main_Home_Viewpager extends PagerAdapter {

    private Context mContext;
    private ArrayList<M_Main_Home_Viewpager> items;
    private int no;

    public A_Main_Home_Viewpager(Context mContext, ArrayList<M_Main_Home_Viewpager> items) {
        this.mContext = mContext;
        this.items = items;
        this.no = items.size();
    }

    @Override
    public int getCount() {
        return no;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.l_main_home_viewpager, container, false);
        ImageView iv = (ImageView) itemView.findViewById(R.id.main_home_viewpager_img);
//        iv.setBackground(items.get(position).getTemp_img());
        Glide.with(mContext)
                .load("")
                .placeholder(items.get(position).getTemp_img())
                .into(iv);
//        iv.setBackgroundResource();
//        Glide.with(mContext).load().asBitmap().into(iv);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}