package com.yep.odar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class Payment_Sub extends Base_Avtivity {
    private A_Product adapter;
    private ArrayList<M_Product> item;
    private RequestManager requestManager;

    private RecyclerView payment_recycler;
    private LinearLayout credit_back, deposit_back, phone_back;
    private ImageView credit, deposit, phone;
    private TextView payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK, "정산하기");
        setContentView(R.layout.l_payment_sub);

        find_id();

        item = new ArrayList<>();
        requestManager = Glide.with(this);
        adapter = new A_Product(item, this, requestManager);

        item.add(new M_Product(this, 1, "id", "http://image.homeplus.co.kr/UserFiles/Pressimages/69/320/121428969_0.jpg", "돼지갈비 3KG", "41,700원", "3개"));
        item.add(new M_Product(this, 1, "id", "http://images.homeplus.co.kr/goods/main/320/19/27/78/984192778.jpg", " 꽈리고추 4kg", "34,200원", "1개"));
        item.add(new M_Product(this, 1, "id", "http://image.homeplus.co.kr/UserFiles/Goods/320/127502578_0.jpg", "한알_안심대란30입", "3,980", "10개"));
        item.add(new M_Product(this, 1, "id", "http://images.homeplus.co.kr/goods/main/320/19/22/27/984192227.jpg", "식자재용 대파 4kg", "12,600원", "4개"));
        item.add(new M_Product(this, 1, "id", "http://images.homeplus.co.kr/goods/main/320/19/22/90/984192290.jpg", "배추(3입/망)", "23,370원", "1개"));
        item.add(new M_Product(this, 1, "id", "http://images.homeplus.co.kr/goods/main/320/19/21/91/984192191.jpg", "가지 5kg", "20,620원", "1개"));
        U_Custom_Layout layoutManager = new U_Custom_Layout(this, U_Custom_Layout.VERTICAL, false);
        payment_recycler.setLayoutManager(layoutManager);
        payment_recycler.setAdapter(adapter);
    }

    private void find_id() {
        payment_recycler = (RecyclerView) findViewById(R.id.payment_recycler);
        credit_back = (LinearLayout) findViewById(R.id.payment_credit);
        deposit_back = (LinearLayout) findViewById(R.id.payment_deposit);
        phone_back = (LinearLayout) findViewById(R.id.payment_phone);
        credit = (ImageView) findViewById(R.id.payment_credit_radio);
        deposit = (ImageView) findViewById(R.id.payment_deposit_radio);
        phone = (ImageView) findViewById(R.id.payment_phone_radio);
        payment = (TextView) findViewById(R.id.payment);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.payment:
                Intent intent = new Intent(Payment_Sub.this, Complete.class);
                intent.putExtra("type", "payment");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.payment_credit:
                credit.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                deposit.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                phone.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;
            case R.id.payment_deposit:
                deposit.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                credit.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                phone.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;
            case R.id.payment_phone:
                phone.setBackground(getResources().getDrawable(R.drawable.radio_ch));
                deposit.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                credit.setBackground(getResources().getDrawable(R.drawable.radio_unch));
                break;

        }
    }

}
