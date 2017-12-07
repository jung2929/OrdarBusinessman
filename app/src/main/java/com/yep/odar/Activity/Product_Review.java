package com.yep.odar.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Main_Home_Viewpager;
import com.yep.odar.Adapter.A_Product_Review;
import com.yep.odar.Model.M_Main_Home_Viewpager;
import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 27..
 */

public class Product_Review extends Fragment {
    private A_Product_Review adapter;
    private ArrayList<M_Prodect_Review> item;
    private RequestManager requestManager;
    private RecyclerView recyclerView;

    public Product_Review() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        item = new ArrayList<>();
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.l_product_review, container, false);
        recyclerView = (RecyclerView)layout.findViewById(R.id.product_review_recycler);
        requestManager = Glide.with(Product_Review.this);
        adapter = new A_Product_Review(item, getContext(), requestManager);

        /* */
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        item.add(new M_Prodect_Review(getContext(), "http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));

//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
//        item.add(new M_Prodect_Review(getContext(), "제목입니다", "아이디","121212", "꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸꾸루꾸루꾸루꾸루꾸"));
        /* */

        adapter = new A_Product_Review(item, getContext(), requestManager);
        U_Custom_Layout layoutManager = new U_Custom_Layout(getContext(), U_Custom_Layout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return layout;
    }
}
