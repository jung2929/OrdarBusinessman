package com.yep.odar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Main_Home_Viewpager;
import com.yep.odar.Adapter.A_Main_Tip;
import com.yep.odar.Adapter.A_Product;
import com.yep.odar.Model.M_Main_Home_Viewpager;
import com.yep.odar.Model.M_Main_Tip;
import com.yep.odar.Model.M_Product;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;
import com.yep.odar.Util.U_Dialog_Radio;

import java.util.ArrayList;


/**
 * Created by yep on 2017. 9. 26..
 */

public class Main_Mypage extends Fragment {

    private A_Product adapter;
    private ArrayList<M_Product> item;
    private RequestManager requestManager;

    private RelativeLayout cup,pay,chart;
    private TextView cup_badge, pay_badge,chart_badge;
    private  RelativeLayout spinner;
    private RecyclerView recyclerView;
    private U_Dialog_Radio dialog_radio;

    protected View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.l_main_mypage, container, false);

        cup = (RelativeLayout)view.findViewById(R.id.cup);
        pay = (RelativeLayout)view.findViewById(R.id.pay);
        chart = (RelativeLayout)view.findViewById(R.id.chart);
        cup_badge = (TextView)view.findViewById(R.id.cup_badge);
        pay_badge = (TextView)view.findViewById(R.id.pay_badge);
        chart_badge = (TextView)view.findViewById(R.id.chart_badge);

        spinner = (RelativeLayout)view.findViewById(R.id.spinner);
        recyclerView = (RecyclerView)view.findViewById(R.id.product_recycler);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_radio = new U_Dialog_Radio(getContext());
                dialog_radio.show();
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pay_badge.setVisibility(View.INVISIBLE);
                pay_badge.setText("");
                Intent intent = new Intent(getContext(),Payment.class);
                startActivity(intent);
            }
        });

        item = new ArrayList<>();
        requestManager = Glide.with(getContext());
        adapter = new A_Product(item, getContext(), requestManager);
        item.add(new M_Product(getContext(), 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(getContext(), 4,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(getContext(), 4,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(getContext(), 4,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(getContext(), 4,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(getContext(), 4,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 5,"12.3.23","12-12-32-32-3-23-232324"));
        item.add(new M_Product(getContext(), 4,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        item.add(new M_Product(getContext(), 6,"idid","http://www.miju24.com/files/attach/images/130162/956/456/150112ba34b96031d24260e8c11eca7b.jpg","야채야채야채","35,000원","4개"));
        U_Custom_Layout layoutManager = new U_Custom_Layout(getContext(), U_Custom_Layout.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;

    }

}






