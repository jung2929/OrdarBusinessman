package com.yep.odar.Activity;

import com.yep.odar.Adapter.A_Main_ViewPager;
import com.yep.odar.Base.Base_Avtivity;

/**
 * Created by yep on 2017. 9. 26..
 */
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

import com.yep.odar.R;
import com.yep.odar.Util.U_Main_ViewPager;

public class Main_Base extends Base_Avtivity {
    private ActionBar actionbar;
    private U_Main_ViewPager viewpager;
    private RelativeLayout home_tab, category_tab, tip_tab, mypage_tab;
    private boolean mIsEnabled;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private InputMethodManager imm;


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR,"오다");
        setContentView(R.layout.l_main_base);


        Findid();


        /* 뷰 페이저 */
        viewpager = (U_Main_ViewPager) findViewById(R.id.main_pager);
        final A_Main_ViewPager viewpagerAdapter = new A_Main_ViewPager(getSupportFragmentManager());

        viewpager.setAdapter(viewpagerAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                } else if (position == 1) {
                    viewpagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        viewpager.setPagingDisabled();
        viewpager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        viewpager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                viewpager.getParent().requestDisallowInterceptTouchEvent(true);
            }
        });
    }

    void Findid() {
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        home_tab = (RelativeLayout) findViewById(R.id.main_base_home_tab);
        home_tab.setOnClickListener(btnListener);
        category_tab = (RelativeLayout) findViewById(R.id.main_base_category_tab);
        category_tab.setOnClickListener(btnListener);
        tip_tab = (RelativeLayout) findViewById(R.id.main_base_tip_tab);
        tip_tab.setOnClickListener(btnListener);
        mypage_tab = (RelativeLayout) findViewById(R.id.main_base_mypage_tab);
        mypage_tab.setOnClickListener(btnListener);

    }

    private void setCurrentInflateItem(int type) {
        if (type == 0) {
            viewpager.setCurrentItem(0);
        } else if (type == 1) {
            viewpager.setCurrentItem(1);
        } else if (type == 2) {
            viewpager.setCurrentItem(2);
        } else {
            viewpager.setCurrentItem(3);
        }
    }


    View.OnClickListener btnListener = new View.OnClickListener() {
        public void onClick(View v) {
            ImageView[] icon = new ImageView[4];
            TextView[] title = new TextView[4];
            icon[0] = (ImageView) findViewById(R.id.main_base_home_tab_icon);
            icon[1] = (ImageView) findViewById(R.id.main_base_category_tab_icon);
            icon[2] = (ImageView) findViewById(R.id.main_base_tip_tab_icon);
            icon[3] = (ImageView) findViewById(R.id.main_base_mypage_tab_icon);
            title[0] = (TextView) findViewById(R.id.main_base_home_tab_title);
            title[1] = (TextView) findViewById(R.id.main_base_category_tab_title);
            title[2] = (TextView) findViewById(R.id.main_base_tip_tab_title);
            title[3] = (TextView) findViewById(R.id.main_base_mypage_tab_title);
            Intent intent;

            switch (v.getId()) {
                case R.id.main_base_home_tab:
//                    Main_Base.super.setActionBar(CUSTOM_ACTION_BAR);
                    icon[0].setBackgroundResource(R.drawable.home_ch);
                    icon[1].setBackgroundResource(R.drawable.category_unch);
                    icon[2].setBackgroundResource(R.drawable.tip_unch);
                    icon[3].setBackgroundResource(R.drawable.mypage_unch);
                    title[0].setTextColor(getResources().getColor(R.color.color_main));
                    title[1].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[2].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[3].setTextColor(getResources().getColor(R.color.color_light_gray));
                    setCurrentInflateItem(0);
                    break;
                case R.id.main_base_category_tab:
                    icon[0].setBackgroundResource(R.drawable.home_unch);
                    icon[1].setBackgroundResource(R.drawable.category_ch);
                    icon[2].setBackgroundResource(R.drawable.tip_unch);
                    icon[3].setBackgroundResource(R.drawable.mypage_unch);
                    title[0].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[1].setTextColor(getResources().getColor(R.color.color_main));
                    title[2].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[3].setTextColor(getResources().getColor(R.color.color_light_gray));
                    setCurrentInflateItem(1);
                    break;
                case R.id.main_base_tip_tab:
//                    Main_Base.super.setActionBar(NO_ACTION_BAR);
//                    Main_Base.super.setActionBarSearch(true);
                    icon[0].setBackgroundResource(R.drawable.home_unch);
                    icon[1].setBackgroundResource(R.drawable.category_unch);
                    icon[2].setBackgroundResource(R.drawable.tip_ch);
                    icon[3].setBackgroundResource(R.drawable.mypage_unch);
                    title[0].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[1].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[2].setTextColor(getResources().getColor(R.color.color_main));
                    title[3].setTextColor(getResources().getColor(R.color.color_light_gray));
                    setCurrentInflateItem(2);
                    break;
                case R.id.main_base_mypage_tab:
                    icon[0].setBackgroundResource(R.drawable.home_unch);
                    icon[1].setBackgroundResource(R.drawable.category_unch);
                    icon[2].setBackgroundResource(R.drawable.tip_unch);
                    icon[3].setBackgroundResource(R.drawable.mypage_ch);
                    title[0].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[1].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[2].setTextColor(getResources().getColor(R.color.color_light_gray));
                    title[3].setTextColor(getResources().getColor(R.color.color_main));
                    setCurrentInflateItem(3);
                    break;

            }
        }
    };


}
