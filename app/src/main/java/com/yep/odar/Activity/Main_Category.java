package com.yep.odar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yep.odar.Adapter.A_Main_Home_Viewpager;
import com.yep.odar.Model.M_Main_Home_Viewpager;
import com.yep.odar.R;

import java.util.ArrayList;


/**
 * Created by yep on 2017. 9. 26..
 */

public class Main_Category extends Fragment {

    //implements ViewPager.OnPageChangeListener
    protected View view;
    private RelativeLayout category_1, category_2, category_3, category_4, category_5, category_6, category_7, category_8, category_9;
    Intent intent;

    @Override
    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.l_main_category, container, false);
        //# sub 디자인 나오면 수정
//        intent = new Intent(getContext(),Cateroty_Sub.class);
        intent = new Intent(getContext(), Product.class);
        find_id();
        return view;
    }

    void find_id() {
        category_1 = (RelativeLayout) view.findViewById(R.id.main_category_1);
        category_2 = (RelativeLayout) view.findViewById(R.id.main_category_2);
        category_3 = (RelativeLayout) view.findViewById(R.id.main_category_3);
        category_4 = (RelativeLayout) view.findViewById(R.id.main_category_4);
        category_5 = (RelativeLayout) view.findViewById(R.id.main_category_5);
        category_6 = (RelativeLayout) view.findViewById(R.id.main_category_6);
        category_7 = (RelativeLayout) view.findViewById(R.id.main_category_7);
        category_8 = (RelativeLayout) view.findViewById(R.id.main_category_8);
        category_9 = (RelativeLayout) view.findViewById(R.id.main_category_9);

        category_1.setOnClickListener(btn_listener);
        category_2.setOnClickListener(btn_listener);
        category_3.setOnClickListener(btn_listener);
        category_4.setOnClickListener(btn_listener);
        category_5.setOnClickListener(btn_listener);
        category_6.setOnClickListener(btn_listener);
        category_7.setOnClickListener(btn_listener);
        category_8.setOnClickListener(btn_listener);
        category_9.setOnClickListener(btn_listener);
    }


    View.OnClickListener btn_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.main_category_1:
                    intent.putExtra("category_id", "001");
                    break;
                case R.id.main_category_2:
                    intent.putExtra("category_id", "002");
                    break;
                case R.id.main_category_3:
                    intent.putExtra("category_id", "003");
                    break;
                case R.id.main_category_4:
                    intent.putExtra("category_id", "004");
                    break;
                case R.id.main_category_5:
                    intent.putExtra("category_id", "005");
                    break;
                case R.id.main_category_6:
                    intent.putExtra("category_id", "006");
                    break;
                case R.id.main_category_7:
                    intent.putExtra("category_id", "007");
                    break;
                case R.id.main_category_8:
                    intent.putExtra("category_id", "008");
                    break;
                case R.id.main_category_9:
                    intent.putExtra("category_id", "009");
                    break;
            }
            startActivity(intent);
        }
    };

}
