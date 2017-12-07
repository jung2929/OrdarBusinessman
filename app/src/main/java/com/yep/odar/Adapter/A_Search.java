package com.yep.odar.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yep.odar.Model.M_Search;
import com.yep.odar.R;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 28..
 */

public class A_Search extends RecyclerView.Adapter<A_Search.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<M_Search> listViewItemList;
    private Context context;
    private RequestManager requestManager;
    private int type = 0;


    public A_Search(ArrayList<M_Search> item, Context context, RequestManager requestManager) {
        this.context = context;
        this.listViewItemList = item;
        this.requestManager = requestManager;

    }


    @Override
    public int getItemViewType(int position) {
        if (listViewItemList.get(position).getType() == 1) {
            this.type = 1;
            return 1;
        } else
            this.type = 2;
        return 2;
    }

    /**
     * 레이아웃을 만들어서 Holer에 저장
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public A_Search.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.l_search_sub_item, viewGroup, false);
        return new A_Search.ViewHolder(view, 1);
    }


    @Override
    public void onBindViewHolder(final A_Search.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);
//recent

        if (itemtype == 1) {
            viewHolder.del.setVisibility(View.VISIBLE);
            viewHolder.contents.setVisibility(View.INVISIBLE);
            viewHolder.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listViewItemList.remove(position);
                    notifyDataSetChanged();
                }
            });
//hot
        } else {
            viewHolder.del.setVisibility(View.INVISIBLE);
            viewHolder.no.setVisibility(View.VISIBLE);
            viewHolder.no.setText(listViewItemList.get(position).getNo());
            viewHolder.contents.setText(listViewItemList.get(position).getContents());
        }
        viewHolder.no.setText(listViewItemList.get(position).getNo());


    }


    @Override
    public int getItemCount() {
        return (null != listViewItemList ? listViewItemList.size() : 0);
    }

    /**
     * 뷰 재활용을 위한 viewHolder`
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contents, no;
        private ImageView del;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            del = (ImageView) itemView.findViewById(R.id.search_delete);
            contents = (TextView) itemView.findViewById(R.id.search_contents);
            no = (TextView) itemView.findViewById(R.id.search_no);
        }

    }


}

