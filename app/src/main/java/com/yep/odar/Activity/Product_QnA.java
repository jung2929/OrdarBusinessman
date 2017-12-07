package com.yep.odar.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yep.odar.Adapter.A_Product_QnA;
import com.yep.odar.Adapter.A_Product_Review;
import com.yep.odar.Model.M_Prodect_Review;
import com.yep.odar.Model.M_Product_QnA;
import com.yep.odar.R;
import com.yep.odar.Util.U_Custom_Layout;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 9. 27..
 */

public class Product_QnA extends Fragment {
    private A_Product_QnA adapter;
    private ArrayList<M_Product_QnA> item;
    private RequestManager requestManager;
    private RecyclerView recyclerView;

    public Product_QnA() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        item = new ArrayList<>();
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.l_product_qna, container, false);
        recyclerView = (RecyclerView)layout.findViewById(R.id.product_qna_recycler);
        requestManager = Glide.with(Product_QnA.this);
        adapter = new A_Product_QnA(item, getContext(), requestManager);

        /* */
        item.add(new M_Product_QnA(getContext(), "이건뭔가요?", "가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루","12.12.12", "youndfnl234","이건뭔가요?", "가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루","12.12.12"));
        item.add(new M_Product_QnA(getContext(), "이건뭔가요?", "가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루","12.12.12", "youndfnl234","이건뭔가요?", "가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루가나다라마바사아자차카타ㅠㅏ하꾸루","12.12.12"));
       /* */

        adapter = new A_Product_QnA(item, getContext(), requestManager);
        U_Custom_Layout layoutManager = new U_Custom_Layout(getContext(), U_Custom_Layout.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return layout;
    }
}
