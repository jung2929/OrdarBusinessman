package com.yep.odar.Activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Main_Home;
import com.yep.odar.Adapter.A_Main_Home_Viewpager;
import com.yep.odar.Adapter.A_Main_Tip;
import com.yep.odar.Adapter.A_Product_Review;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.Model.M_Main_Home_Viewpager;
import com.yep.odar.Model.M_Main_Tip;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;

import java.util.ArrayList;


/**
 * Created by yep on 2017. 9. 26..
 */

public class Main_Tip extends Fragment {

    protected View view;
    private ViewPager viewpager;
    private A_Main_Home_Viewpager viewpager_adapter;
    private ArrayList<M_Main_Home_Viewpager> viewpager_item;

    private A_Main_Tip adapter;
    private ArrayList<M_Main_Tip> item;
    private RequestManager requestManager;
    private RecyclerView recyclerView;


    @Override
    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.l_main_tip, container, false);

        /*이벤트*/
        viewpager_item = new ArrayList<>();
        viewpager = (ViewPager) view.findViewById(R.id.main_tip_viewpager);
        viewpager_item.add(new M_Main_Home_Viewpager(getContext(), getResources().getDrawable(R.drawable.temp_tip), "idid"));
        viewpager_item.add(new M_Main_Home_Viewpager(getContext(), getResources().getDrawable(R.drawable.temp_tip), "idid"));
        viewpager_item.add(new M_Main_Home_Viewpager(getContext(), getResources().getDrawable(R.drawable.temp_tip), "idid"));
        viewpager_adapter = new A_Main_Home_Viewpager(getContext(), viewpager_item);
        viewpager.setAdapter(viewpager_adapter);
        viewpager.setCurrentItem(0);

//        /*아이템*/
        item = new ArrayList<>();
//        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.l_main_tip, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.main_tip_recycler);
        requestManager = Glide.with(getContext());
        adapter = new A_Main_Tip(item, getContext(), requestManager);
//
//        /*수정*/
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "12","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "121","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "212","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "34","ididid"));
        item.add(new M_Main_Tip(getContext(), "http://pds.joins.com/news/component/htmlphoto_mmdata/201209/17/htm_201209172491030103011.jpg", "꿀팀허니팁팁팁팁", "2012-23-23", "1","ididid"));
        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        recyclerView.setNestedScrollingEnabled(false);
        U_Custom_Layout layoutManager = new U_Custom_Layout(getContext(), U_Custom_Layout.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.addItemDecoration(new Main_Home.GridSpacingItemDecoration(3, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return view;

    }

}






