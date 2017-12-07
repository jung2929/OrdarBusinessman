package com.yep.odar.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Product;
import com.yep.odar.Adapter.A_Search;
import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.Model.M_Product;
import com.yep.odar.Model.M_Search;
import com.yep.odar.R;
import com.yep.odar.Util.U_Dialog;
import com.yep.odar.Util.U_Main_ViewPager;
import com.yep.odar.Util.U_TextWatcher;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 27..
 */

public class Product extends Base_Avtivity {
    private A_Product adapter;
    private ArrayList<M_Product> item;
    private RequestManager requestManager;

    private ViewPager product_viewpager;
    private TextView product_tab_detail, product_tab_review, product_tab_qna;
    private TextView product_tab_detail_line, product_tab_review_line, product_tab_qna_line;
    private LinearLayout product_btn;
    private TextView product_cart, product_direct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"상품정보");
        setContentView(R.layout.l_product);
        find_id();
        product_viewpager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        product_viewpager.setCurrentItem(0);
        Log.i("vp", "" + product_viewpager.getMeasuredHeight());


    }

    void find_id() {
        product_viewpager = (ViewPager) findViewById(R.id.product_viewpager);
        product_tab_detail = (TextView) findViewById(R.id.product_tab_detail);
        product_tab_review = (TextView) findViewById(R.id.product_tab_review);
        product_tab_qna = (TextView) findViewById(R.id.product_tab_qna);
        product_tab_detail_line = (TextView) findViewById(R.id.product_tab_line_detail);
        product_tab_review_line = (TextView) findViewById(R.id.product_tab_line_reciew);
        product_tab_qna_line = (TextView) findViewById(R.id.product_tab_line_qna);
        product_tab_detail.setOnClickListener(movePageListener);
        product_tab_detail.setTag(0);
        product_tab_review.setOnClickListener(movePageListener);
        product_tab_review.setTag(1);
        product_tab_qna.setOnClickListener(movePageListener);
        product_tab_qna.setTag(2);
        product_viewpager.getMeasuredHeight();
        Log.i("vp", "" + product_viewpager.getMeasuredHeight());
        product_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        product_btn = (LinearLayout) findViewById(R.id.product_btn);
        product_cart = (TextView) findViewById(R.id.product_cart);
        product_direct = (TextView) findViewById(R.id.product_direct);
    }

    View.OnClickListener movePageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag = (int) v.getTag();
            pagerChange(tag);
            product_viewpager.setCurrentItem(tag);
            Log.e("h","hh: "+product_viewpager.getMeasuredHeight());
//            product_viewpager.getMeasuredHeight();
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
                    return new Product_Detail();
                case 1:
                    return new Product_Review();
                case 2:
                    return new Product_QnA();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }


    }


    private void pagerChange(int position) {
        switch (position) {
            case 0:
//                product_btn.setVisibility(View.VISIBLE);
                product_tab_detail.setTextColor(getResources().getColor(R.color.color_gray));
                product_tab_detail_line.setBackgroundColor(getResources().getColor(R.color.color_red));
                product_tab_review.setTextColor(getResources().getColor(R.color.color_light_gray));
                product_tab_review_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                product_tab_qna.setTextColor(getResources().getColor(R.color.color_light_gray));
                product_tab_qna_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                break;
            case 1:
//                product_btn.setVisibility(View.GONE);
                product_tab_detail.setTextColor(getResources().getColor(R.color.color_light_gray));
                product_tab_detail_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                product_tab_review.setTextColor(getResources().getColor(R.color.color_gray));
                product_tab_review_line.setBackgroundColor(getResources().getColor(R.color.color_red));
                product_tab_qna.setTextColor(getResources().getColor(R.color.color_light_gray));
                product_tab_qna_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                break;
            case 2:
//                product_btn.setVisibility(View.GONE);
                product_tab_detail.setTextColor(getResources().getColor(R.color.color_light_gray));
                product_tab_detail_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                product_tab_review.setTextColor(getResources().getColor(R.color.color_light_gray));
                product_tab_review_line.setBackgroundColor(getResources().getColor(R.color.color_white));
                product_tab_qna.setTextColor(getResources().getColor(R.color.color_gray));
                product_tab_qna_line.setBackgroundColor(getResources().getColor(R.color.color_red));
                break;

        }
    }


}

