package com.yep.odar.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Product;
import com.yep.odar.Adapter.A_Search;
import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.Model.M_Product;
import com.yep.odar.Model.M_Search;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;
import com.yep.odar.Util.U_Dialog;

import java.util.ArrayList;

import static android.R.attr.type;
import static java.security.AccessController.getContext;

public class Odar extends Base_Avtivity {
    private A_Product adapter;
    private ArrayList<M_Product> item;
    private RequestManager requestManager;

    private EditText et_name, et_adr1, et_adr2, et_phone, et_memo;
    private TextView tv_adr, tv_odar;
    private ImageView am, am2, pm, pm2;
    private RelativeLayout cart_main;
    private RecyclerView recycler;
    private U_Dialog dialog;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"주문요청");
        setContentView(R.layout.l_odar);
        find_id();


        item = new ArrayList<>();
        requestManager = Glide.with(this);
        adapter = new A_Product(item, this, requestManager);
        item.add(new M_Product(this, 1,"idid", "http://image.homeplus.co.kr/UserFiles/Pressimages/69/320/121428969_0.jpg", "돼지갈비 3KG", "41,700원", "3개"));
        item.add(new M_Product(this, 1,"idid", "http://images.homeplus.co.kr/goods/main/320/19/27/78/984192778.jpg", " 꽈리고추 4kg", "34,200원", "2개"));
        item.add(new M_Product(this, 1,"idid", "http://image.homeplus.co.kr/UserFiles/Goods/320/127502578_0.jpg", "한알_안심대란30입", "3,980원", "3개"));
        item.add(new M_Product(this, 1,"idid", "http://images.homeplus.co.kr/goods/main/320/19/22/27/984192227.jpg", "식자재용 대파 4kg", "12,600원", "3개"));
        item.add(new M_Product(this, 1,"idid", "http://images.homeplus.co.kr/goods/main/320/19/22/90/984192290.jpg", "배추(3입/망)", "23,370원", "3개"));
        item.add(new M_Product(this, 1,"idid","http://images.homeplus.co.kr/goods/main/320/19/21/91/984192191.jpg", "가지 5kg", "20,620원", "3개"));

        item.add(new M_Product(this, 1,"idid","http://image.homeplus.co.kr/UserFiles/Pressimages/97/320/120285597_0.jpg", "마늘_500G(봉)", "11,700원", "2개"));
        item.add(new M_Product(this, 1,"id","http://images.homeplus.co.kr/goods/main/320/58/98/54/999589854.jpg", " 황토 호박고구마 3kg", "24,900원", "5개"));
        U_Custom_Layout layoutManager = new U_Custom_Layout(this, U_Custom_Layout.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cart_main:
                hide_keyboard();
                et_name.clearFocus();
                et_adr1.clearFocus();
                et_adr2.clearFocus();
                et_phone.clearFocus();
                et_memo.clearFocus();
                break;
            case R.id.cart_post:

                break;
            case R.id.am:
                am.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                am2.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                pm.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                pm2.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;
            case R.id.am2:
                am2.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                am.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                pm.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                pm2.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;
            case R.id.pm:
                pm.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                am2.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                am.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                pm2.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;
            case R.id.pm2:
                pm2.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                am2.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                pm.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                am.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;
            case R.id.cart_next:
                if (et_name.getText().equals("") || et_adr1.getText().equals("") || et_adr2.getText().equals("") || et_adr2.getText().equals("") || et_phone.getText().equals("") || et_memo.getText().equals("")) {
                    dialog = new U_Dialog(Odar.this, "입력란 체크!", getResources().getString(R.string.login_dialog_contents));
                    dialog.show();
                } else {
                    intent = new Intent(Odar.this, Complete.class);
                    intent.putExtra("type", "odar");
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                break;
        }
    }

    void hide_keyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_name.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(et_adr1.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(et_adr2.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(et_phone.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(et_memo.getWindowToken(), 0);
    }

    void find_id() {
        et_name = (EditText) findViewById(R.id.cart_name);
        et_adr1 = (EditText) findViewById(R.id.cart_adr);
        et_adr2 = (EditText) findViewById(R.id.cart_adr2);
        et_phone = (EditText) findViewById(R.id.cart_memo);
        et_memo = (EditText) findViewById(R.id.cart_phone);
        tv_adr = (TextView) findViewById(R.id.cart_post);
        tv_odar = (TextView) findViewById(R.id.cart_next);
        cart_main = (RelativeLayout) findViewById(R.id.cart_main);
        recycler = (RecyclerView) findViewById(R.id.cart_recycler);
        am = (ImageView) findViewById(R.id.am);
        am2 = (ImageView) findViewById(R.id.am2);
        pm = (ImageView) findViewById(R.id.pm);
        pm2 = (ImageView) findViewById(R.id.pm2);

        //
        et_name.setText("김가네 선릉점");
        et_adr1.setText("서울시 강남구  ");
        et_adr2.setText("테헤란로 342-44");
        et_phone.setText("010-2534-6912");
        et_memo.setText("운반에 주의해주세요");
    }
}
