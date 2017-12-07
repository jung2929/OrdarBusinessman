package com.yep.odar.Activity;

import android.content.Intent;
import android.provider.ContactsContract;
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
import com.yep.odar.Model.M_Product;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;
import com.yep.odar.Util.U_Dialog;

import java.util.ArrayList;

public class Payment extends Base_Avtivity {
    private A_Product adapter;
    private ArrayList<M_Product> item;
    private RequestManager requestManager;

    private TextView payment;
    private RelativeLayout payment_select_all_back;
    private ImageView payment_select_all;
    private  RecyclerView payment_recycler;
    private boolean select_all=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"정산하기");
        setContentView(R.layout.l_payment);
        find_id();



        item = new ArrayList<>();
        requestManager = Glide.with(this);
        adapter = new A_Product(item, this, requestManager);

        item.add(new M_Product(this, 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(this, 4, "id", "http://image.homeplus.co.kr/UserFiles/Pressimages/69/320/121428969_0.jpg", "돼지갈비 3KG외 4개 상품", "211,700원", "10/27까지","D-7"));
        item.add(new M_Product(this, 6,"12.3.23","12-12-32-32-3-23-232324"));

        item.add(new M_Product(this, 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(this, 4,"id","http://images.homeplus.co.kr/goods/main/320/19/27/78/984192778.jpg","꽈리고추 4kg 외 6개 상품","134,200원", "10/26까지","D-6"));
        item.add(new M_Product(this, 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));

        item.add(new M_Product(this, 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(this, 4,"idid","http://images.homeplus.co.kr/goods/main/320/19/21/91/984192191.jpg","가지 5kg외 7개 상품","142,000원", "10/25까지","D-5"));
        item.add(new M_Product(this, 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));

        U_Custom_Layout layoutManager = new U_Custom_Layout(this, U_Custom_Layout.VERTICAL, false);
        payment_recycler.setLayoutManager(layoutManager);
        payment_recycler.setAdapter(adapter);
    }

    private void find_id(){
        payment =(TextView)findViewById(R.id.payment);
        payment_select_all_back =(RelativeLayout) findViewById(R.id.payment_select_all_back);
//        payment_select_all =(ImageView)findViewById(R.id.payment_select_all);
        payment_recycler =(RecyclerView) findViewById(R.id.payment_recycler);
    }


    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.payment_select_all_back:
//                if(select_all){
//                    select_all=false;
//                    payment_select_all.setBackground(getResources().getDrawable(R.drawable.checkbox_unchecked));
//
//                }else{
//                    select_all=true;
//                    payment_select_all.setBackground(getResources().getDrawable(R.drawable.checkbox_checked));
//                }
//                break;
            case R.id.payment:
                Intent intent = new Intent(Payment.this,Payment_Sub.class);
                startActivity(intent);
                break;

        }

    }


}
