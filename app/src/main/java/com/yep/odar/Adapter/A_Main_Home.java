package com.yep.odar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yep.odar.Activity.Product;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.R;
//import com.yep.odar.databinding.LMainHomeItemBinding;


import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 25..
 */

public class A_Main_Home extends RecyclerView.Adapter<A_Main_Home.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<M_Main_Home_Recycler> listViewItemList;
    private Context context;
    private RequestManager requestManager;


    public A_Main_Home(ArrayList<M_Main_Home_Recycler> item, Context context, RequestManager requestManager) {
        this.context = context;
        this.listViewItemList = item;
        this.requestManager = requestManager;

    }


    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    /**
     * 레이아웃을 만들어서 Holer에 저장
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public A_Main_Home.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.l_main_home_item, viewGroup, false);
        return new A_Main_Home.ViewHolder(view, 1);
    }


    @Override
    public void onBindViewHolder(final A_Main_Home.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);
        requestManager.load(listViewItemList.get(position).getImg()).asBitmap().into(viewHolder.main_home_item_img);
        viewHolder.main_home_item_price.setText(listViewItemList.get(position).getPrice());
        viewHolder.main_home_item_name.setText(listViewItemList.get(position).getName());
        viewHolder.main_home_item_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, Product.class);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return (null != listViewItemList ? listViewItemList.size() : 0);
    }

    /**
     * 뷰 재활용을 위한 viewHolder`
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView main_home_item_img;
        private TextView main_home_item_price, main_home_item_name;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            main_home_item_img = (ImageView) itemView.findViewById(R.id.main_home_item_img);
            main_home_item_name =(TextView)itemView.findViewById(R.id.main_home_item_name);
            main_home_item_price =(TextView)itemView.findViewById(R.id.main_home_item_price);
        }

    }


}

