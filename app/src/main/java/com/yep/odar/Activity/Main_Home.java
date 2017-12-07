package com.yep.odar.Activity;

import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Main_Home;
import com.yep.odar.Adapter.A_Main_Home_Viewpager;
import com.yep.odar.Adapter.A_Product_QnA;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.Model.M_Main_Home_Viewpager;
import com.yep.odar.Model.M_Product_QnA;
import com.yep.odar.R;
import com.yep.odar.Util.U_Dialog_Two;

import org.json.JSONArray;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 26..
 */

public class Main_Home extends Fragment {

    protected View view;
    private ViewPager main_home_viewpager;
    private A_Main_Home_Viewpager main_home_viewpager_adapter;
    private ArrayList<M_Main_Home_Viewpager> main_home_viewpager_item;

    private A_Main_Home adapter;
    private ArrayList<M_Main_Home_Recycler> item;
    private RequestManager requestManager;
    private RecyclerView recyclerView;

    private TextView direct;
    private CheckBox ch_all;
    private TextView direct_odar;
    private  U_Dialog_Two dialog;

    @Override
    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.l_main_home, container, false);
        direct = (TextView) view.findViewById(R.id.fab);
        ch_all = (CheckBox) view.findViewById(R.id.select_all);
        ch_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch_all.isChecked()) {
                } else {

                }
            }
        });
        direct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new U_Dialog_Two(getContext(), "","");
                dialog.show();
            }
        });

        /*이벤트*/
        main_home_viewpager_item = new ArrayList<>();
        main_home_viewpager = (ViewPager) view.findViewById(R.id.main_home_viewpager);
        main_home_viewpager_item.add(new M_Main_Home_Viewpager(getContext(), getResources().getDrawable(R.drawable.temp_main), "idid"));
        main_home_viewpager_item.add(new M_Main_Home_Viewpager(getContext(), getResources().getDrawable(R.drawable.temp_main), "idid"));
        main_home_viewpager_item.add(new M_Main_Home_Viewpager(getContext(), getResources().getDrawable(R.drawable.temp_main), "idid"));
        main_home_viewpager_adapter = new A_Main_Home_Viewpager(getContext(), main_home_viewpager_item);
        main_home_viewpager.setAdapter(main_home_viewpager_adapter);
        main_home_viewpager.setCurrentItem(0);

        /*아이템*/
        item = new ArrayList<>();
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.l_main_home_item, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.main_home_recycler);
        requestManager = Glide.with(getContext());
        adapter = new A_Main_Home(item, getContext(), requestManager);

        /*수정*/
        item.add(new M_Main_Home_Recycler(getContext(), "http://image.homeplus.co.kr/UserFiles/Pressimages/69/320/121428969_0.jpg", "돼지갈비 3KG", "41,700원", "idid"));
        item.add(new M_Main_Home_Recycler(getContext(), "http://images.homeplus.co.kr/goods/main/320/19/27/78/984192778.jpg", " 꽈리고추 4kg", "34,200원", "idid"));
        item.add(new M_Main_Home_Recycler(getContext(), "http://image.homeplus.co.kr/UserFiles/Goods/320/127502578_0.jpg", "한알_안심대란30입", "3,980", "idid"));
        item.add(new M_Main_Home_Recycler(getContext(), "http://images.homeplus.co.kr/goods/main/320/19/22/27/984192227.jpg", "식자재용 대파 4kg", "12,600원", "idid"));
        item.add(new M_Main_Home_Recycler(getContext(), "http://images.homeplus.co.kr/goods/main/320/19/22/90/984192290.jpg", "배추(3입/망)", "23,370원", "idid"));
        item.add(new M_Main_Home_Recycler(getContext(), "http://images.homeplus.co.kr/goods/main/320/19/21/91/984192191.jpg", "가지 5kg", "20,620원", "idid"));

        recyclerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        recyclerView.setNestedScrollingEnabled(false);
        //LinearLayoutManager layout = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;

    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}






