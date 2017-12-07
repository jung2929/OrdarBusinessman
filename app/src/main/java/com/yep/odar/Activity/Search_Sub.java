package com.yep.odar.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Product_QnA;
import com.yep.odar.Adapter.A_Product_Review;
import com.yep.odar.Adapter.A_Search;
import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.Model.M_Product_QnA;
import com.yep.odar.Model.M_Search;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;

import java.util.ArrayList;



/**
 * Created by yep on 2017. 9. 28..
 */

public class Search_Sub extends Fragment {
    private A_Search adapter;
    private ArrayList<M_Search> item;
    private RequestManager requestManager;
    private RecyclerView recyclerView;
    private int type = 110;
    Context mContext;


    public Search_Sub() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setParameter(int parameter) {
        this.type = parameter;
        Log.i("typee",""+type);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        item = new ArrayList<>();
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.l_search_sub, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.search_recycler);
        requestManager = Glide.with(getContext());
        adapter = new A_Search(item, getContext(), requestManager);

        /* */
        if(type==1){
            item.add(new M_Search(getContext(), "1", "감자", 2));
            item.add(new M_Search(getContext(), "2", "고구마", 2));
            item.add(new M_Search(getContext(), "3", "브로콜리", 2));
            item.add(new M_Search(getContext(), "4", "사과", 2));
            item.add(new M_Search(getContext(), "5", "사과", 2));
            item.add(new M_Search(getContext(), "6", "사과", 2));
            item.add(new M_Search(getContext(), "7", "사과", 2));
            item.add(new M_Search(getContext(), "8", "사과", 2));
        }else {
            item.add(new M_Search(getContext(), "브로콜리", "감자", 1));
            item.add(new M_Search(getContext(), "브로콜리", "고구마", 1));
            item.add(new M_Search(getContext(), "브로콜리", "사과", 1));
            item.add(new M_Search(getContext(), "브로콜리", "고구마", 1));
            item.add(new M_Search(getContext(), "브로콜리5", "사과", 1));
            item.add(new M_Search(getContext(), "브로콜리","사과",1));
            item.add(new M_Search(getContext(), "브로콜리", "사과", 1));
            item.add(new M_Search(getContext(), "8브로콜리", "사과", 1));
        }

        /* */


        Log.e("item", "" + item.get(1).getContents());
        adapter = new A_Search(item, getContext(), requestManager);
        U_Custom_Layout layoutManager = new U_Custom_Layout(getContext(), U_Custom_Layout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        Log.e("item", "sad" + layoutManager);
        recyclerView.setAdapter(adapter);


        return layout;
    }
}

