package com.yep.odar.Adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yep.odar.Model.M_Main_Home_Recycler;
import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.R;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 28..
 */

public class A_Product_Review extends RecyclerView.Adapter<A_Product_Review.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<M_Prodect_Review> listViewItemList;
    private Context context;
    private RequestManager requestManager;


    public A_Product_Review(ArrayList<M_Prodect_Review> item, Context context, RequestManager requestManager) {
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
    public A_Product_Review.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.l_product_review_item, viewGroup, false);
        return new A_Product_Review.ViewHolder(view, 1);
    }


    @Override
    public void onBindViewHolder(final A_Product_Review.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);
        requestManager.load(listViewItemList.get(position).getImg()).asBitmap().into(viewHolder.product_review_img);
        viewHolder.product_review_title.setText(listViewItemList.get(position).getTitle());
        viewHolder.product_review_id.setText(listViewItemList.get(position).getId());
        viewHolder.product_review_date.setText(listViewItemList.get(position).getDate());
        viewHolder.product_review_contents.setText(listViewItemList.get(position).getContents());

    }


    @Override
    public int getItemCount() {
        return (null != listViewItemList ? listViewItemList.size() : 0);
    }

    /**
     * 뷰 재활용을 위한 viewHolder`
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView product_review_img;
        private TextView product_review_title, product_review_date, product_review_id, product_review_contents;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            product_review_img = (ImageView) itemView.findViewById(R.id.product_review_img);
            product_review_title = (TextView) itemView.findViewById(R.id.product_review_title);
            product_review_id = (TextView) itemView.findViewById(R.id.product_review_id);
            product_review_date= (TextView) itemView.findViewById(R.id.product_review_date);
            product_review_contents = (TextView) itemView.findViewById(R.id.product_review_contents);
        }

    }


}

