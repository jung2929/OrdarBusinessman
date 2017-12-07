package com.yep.odar.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.Model.M_Product_QnA;
import com.yep.odar.R;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 28..
 */

public class A_Product_QnA extends RecyclerView.Adapter<A_Product_QnA.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<M_Product_QnA> listViewItemList;
    private Context context;
    private RequestManager requestManager;


    public A_Product_QnA(ArrayList<M_Product_QnA> item, Context context, RequestManager requestManager) {
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
    public A_Product_QnA.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.l_product_qna_item, viewGroup, false);
        return new A_Product_QnA.ViewHolder(view, 1);
    }


    @Override
    public void onBindViewHolder(final A_Product_QnA.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);
        viewHolder.q_title.setText(listViewItemList.get(position).getQ_title());
        viewHolder.q_contents.setText(listViewItemList.get(position).getQ_contents());
        viewHolder.q_date.setText(listViewItemList.get(position).getQ_date());
        viewHolder.q_id.setText(listViewItemList.get(position).getQ_id());
        viewHolder.a_title.setText(listViewItemList.get(position).getA_title());
        viewHolder.a_contents.setText(listViewItemList.get(position).getA_contents());
        viewHolder.a_date.setText(listViewItemList.get(position).getA_date());

    }


    @Override
    public int getItemCount() {
        return (null != listViewItemList ? listViewItemList.size() : 0);
    }

    /**
     * 뷰 재활용을 위한 viewHolder`
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView q_title, q_contents, q_date, q_id, a_title, a_contents, a_date;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            q_title = (TextView) itemView.findViewById(R.id.product_qna_q_title);
            q_contents = (TextView) itemView.findViewById(R.id.product_qna_q_contents);
            q_date= (TextView) itemView.findViewById(R.id.product_qna_q_date);
            q_id = (TextView) itemView.findViewById(R.id.product_qna_q_id);
            a_title = (TextView) itemView.findViewById(R.id.product_qna_a_title);
            a_contents = (TextView) itemView.findViewById(R.id.product_qna_a_contents);
            a_date = (TextView) itemView.findViewById(R.id.product_qna_a_date);
        }

    }


}

