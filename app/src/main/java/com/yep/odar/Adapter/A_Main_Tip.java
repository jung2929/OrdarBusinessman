package com.yep.odar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yep.odar.Activity.Tip_Detail;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.Model.M_Main_Tip;
import com.yep.odar.R;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 28..
 */

public class A_Main_Tip extends RecyclerView.Adapter<A_Main_Tip.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<M_Main_Tip> listViewItemList;
    private Context context;
    private RequestManager requestManager;


    public A_Main_Tip(ArrayList<M_Main_Tip> item, Context context, RequestManager requestManager) {
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
    public A_Main_Tip.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.l_main_tip_item, viewGroup, false);
        return new A_Main_Tip.ViewHolder(view, 1);
    }


    @Override
    public void onBindViewHolder(final A_Main_Tip.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);
        requestManager.load(listViewItemList.get(position).getImg()).asBitmap().into(viewHolder.main_tip_item_img);
        viewHolder.main_tip_item_title.setText(listViewItemList.get(position).getTitle());
        viewHolder.main_tip_item_date.setText(listViewItemList.get(position).getDate());
        viewHolder.main_tip_item_like.setText(listViewItemList.get(position).getLike());
        viewHolder.tip_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Tip_Detail.class);
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
        private ImageView main_tip_item_img;
        private TextView main_tip_item_title, main_tip_item_date, main_tip_item_like;
        private RelativeLayout tip_item;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            main_tip_item_img = (ImageView) itemView.findViewById(R.id.main_tip_item_img);
            main_tip_item_title =(TextView)itemView.findViewById(R.id.main_tip_item_title);
            main_tip_item_date =(TextView)itemView.findViewById(R.id.main_tip_item_date);
            main_tip_item_like =(TextView)itemView.findViewById(R.id.main_tip_item_like);
            tip_item =(RelativeLayout)itemView.findViewById(R.id.tip_item);
        }

    }


}

