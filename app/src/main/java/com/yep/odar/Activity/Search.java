package com.yep.odar.Activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.*;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.ImageReader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.IntDef;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.*;

import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.R;
import com.yep.odar.Util.U_Dialog;
import com.yep.odar.Util.U_TextWatcher;

import static android.R.attr.fragment;
import static android.R.attr.type;

public class Search extends Base_Avtivity {

    private ViewPager viewpager;
    private TextView search_tab_hot, search_tab_recent;
    private TextView search_tab_hot_line, search_tab_recent_line;
    private int typee =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_SEARCH,"");
        setContentView(R.layout.l_search);
        find_id();
        viewpager.setAdapter(new Search.pagerAdapter(getSupportFragmentManager()));
        viewpager.setCurrentItem(0);


    }

    void find_id() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        search_tab_hot = (TextView) findViewById(R.id.search_tab_hot);
        search_tab_hot_line = (TextView) findViewById(R.id.search_tab_hot_line);
        search_tab_recent = (TextView) findViewById(R.id.search_tab_recent);
        search_tab_recent_line = (TextView) findViewById(R.id.search_tab_recent_line);
        search_tab_hot.setOnClickListener(movePageListener);
        search_tab_hot.setTag(1);
        search_tab_recent.setOnClickListener(movePageListener);
        search_tab_recent.setTag(0);

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                pagerChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    View.OnClickListener movePageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();
            pagerChange(tag);
            viewpager.setCurrentItem(tag);
        }
    };


    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }


        @Override
        public android.support.v4.app.Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Search_Sub frg1 = new Search_Sub();
                    frg1.setParameter(position);
                    return frg1;
                case 1:
                    Search_Sub frg2 = new Search_Sub();
                    frg2.setParameter(position);
                    return frg2;
                default:
                    return null;
            }
        }


        @Override
        public int getCount() {
            return 2;
        }


    }

    private void pagerChange(int position) {
        switch (position) {
            case 1:
                search_tab_hot.setTextColor(getResources().getColor(R.color.color_gray));
                search_tab_hot_line.setBackgroundColor(getResources().getColor(R.color.color_red));
                search_tab_recent.setTextColor(getResources().getColor(R.color.color_light_gray));
                search_tab_recent_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                break;
            case 0:
                search_tab_hot.setTextColor(getResources().getColor(R.color.color_light_gray));
                search_tab_hot_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                search_tab_recent.setTextColor(getResources().getColor(R.color.color_gray));
                search_tab_recent_line.setBackgroundColor(getResources().getColor(R.color.color_red));
                break;

        }
    }
}
//
//