package com.yep.odar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Product;
import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.Model.M_Product;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;
import com.yep.odar.Util.U_Dialog;

import java.util.ArrayList;

public class Cart extends Base_Avtivity {
    private A_Product cart_adapter, direct_adapter;
    private ArrayList<M_Product> cart_item,direct_item;
    private RequestManager cart_requestManager,direct_requestManager;


    private RelativeLayout select_all_back;
    private RecyclerView direct_recycler, cart_recycler;
    private ImageView select_all;
    private TextView odar;
    private boolean select = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"장바구니");
        setContentView(R.layout.l_cart);

        find_id();

        direct_item = new ArrayList<>();
        direct_requestManager = Glide.with(this);
        direct_adapter = new A_Product(direct_item, this, direct_requestManager);
        direct_item.add(new M_Product(this, 3,"idid","http://image.homeplus.co.kr/UserFiles/Pressimages/69/320/121428969_0.jpg", "돼지갈비 3KG외 5개품목", "125,130원", "0"));
        direct_item.add(new M_Product(this, 6,"idid","http://cdn.wall-pix.net/albums/general-wallpaper/00034320.jpg","야채야채야채","35,000원","4"));
        U_Custom_Layout layoutManager = new U_Custom_Layout(this, U_Custom_Layout.VERTICAL, false);
        direct_recycler.setLayoutManager(layoutManager);
        direct_recycler.setAdapter(direct_adapter);


        cart_item = new ArrayList<>();
        cart_requestManager = Glide.with(this);
        cart_adapter = new A_Product(cart_item, this, cart_requestManager);
        cart_item.add(new M_Product(this, 3,"idid","http://image.homeplus.co.kr/UserFiles/Pressimages/97/320/120285597_0.jpg", "마늘_500G(봉)", "11,700원", "2"));
        cart_item.add(new M_Product(this, 3,"id","http://images.homeplus.co.kr/goods/main/320/58/98/54/999589854.jpg", " 황토 호박고구마 3kg", "24,900원", "5"));
        U_Custom_Layout layoutManager2 = new U_Custom_Layout(this, U_Custom_Layout.VERTICAL, false);
        cart_recycler.setLayoutManager(layoutManager2);
        cart_recycler.setAdapter(cart_adapter);
    }

    private void find_id() {
        select_all_back = (RelativeLayout) findViewById(R.id.select_all_back);
        direct_recycler = (RecyclerView) findViewById(R.id.direct_recycler);
        cart_recycler = (RecyclerView) findViewById(R.id.cart_recycler);
        select_all = (ImageView) findViewById(R.id.select_all);
        odar = (TextView) findViewById(R.id.odar);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.select_all_back:
                if (select) {
                    select = false;
                    select_all.setBackground(getResources().getDrawable(R.drawable.checkbox_unchecked));
                } else {
                    select = true;
                    select_all.setBackground(getResources().getDrawable(R.drawable.checkbox_checked));
                }
                break;
            case R.id.odar:
                Intent intent = new Intent(Cart.this, Odar.class);
                startActivity(intent);
                break;

        }
    }

}
