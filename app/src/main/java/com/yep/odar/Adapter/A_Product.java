package com.yep.odar.Adapter;

import android.content.Context;
import android.media.Image;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.yep.odar.Model.M_Product;
import com.yep.odar.R;

import java.util.ArrayList;

/**
 * Created by yep on 2017. 10. 9..
 */

public class A_Product extends RecyclerView.Adapter<A_Product.ViewHolder> {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<M_Product> listViewItemList;
    private Context context;
    private int type;
    public static final int ITEM_TYPE_BASIC = 1;
    public static final int ITEM_TYPE_BASIC_BTN = 2;
    public static final int ITEM_TYPE_SPIN = 3;
    public static final int ITEM_TYPE_DATE = 4;
    public static final int ITEM_TYPE_TITLE = 5;
    public static final int ITEM_TYPE_MORE = 6;
    private RequestManager requestManager;
    private boolean more = false;
    private int spin_no;


    public A_Product(ArrayList<M_Product> item, Context context, RequestManager requestManager) {
        this.context = context;
        this.listViewItemList = item;
        this.requestManager = requestManager;

    }


    @Override
    public int getItemViewType(int position) {

        if (listViewItemList.get(position).getType() == 1) {
            this.type = 1;
            return ITEM_TYPE_BASIC;
        } else if (listViewItemList.get(position).getType() == 2) {
            this.type = 2;
            return ITEM_TYPE_BASIC_BTN;
        } else if (listViewItemList.get(position).getType() == 3) {
            this.type = 3;
            return ITEM_TYPE_SPIN;
        } else if (listViewItemList.get(position).getType() == 4) {
            this.type = 4;
            return ITEM_TYPE_DATE;
        } else if (listViewItemList.get(position).getType() == 5) {
            this.type = 5;
            return ITEM_TYPE_TITLE;
        } else {
            this.type = 6;
            return ITEM_TYPE_MORE;
        }


    }

    /**
     * 레이아웃을 만들어서 Holer에 저장
     *
     * @param viewGroup
     * @param viewType
     * @return
     */
    @Override
    public A_Product.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view;
        if (viewType == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_basic, viewGroup, false);
            return new A_Product.ViewHolder(view, 1);
        } else if (viewType == 2) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_basic, viewGroup, false);
            return new A_Product.ViewHolder(view, 2);
        } else if (viewType == 3) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_chbox, viewGroup, false);
            return new A_Product.ViewHolder(view, 3);
        } else if (viewType == 4) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_date, viewGroup, false);
            return new A_Product.ViewHolder(view, 4);
        } else if (viewType == 5) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_title, viewGroup, false);
            return new A_Product.ViewHolder(view, 5);
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_more, viewGroup, false);
            return new A_Product.ViewHolder(view, 6);
        }


    }


    @Override
    public void onBindViewHolder(final A_Product.ViewHolder viewHolder, final int position) {
        final int itemtype = getItemViewType(position);
        if (itemtype == ITEM_TYPE_BASIC) {
            viewHolder.product_right_img.setVisibility(View.INVISIBLE);
            viewHolder.product_name.setText(listViewItemList.get(position).getProduct_name());
            viewHolder.product_price.setText(listViewItemList.get(position).getProduct_price());
            viewHolder.product_no.setText(listViewItemList.get(position).getProduct_no());
            requestManager.load(listViewItemList.get(position).getProduct_img()).asBitmap().into(viewHolder.product_img);
        } else if (itemtype == ITEM_TYPE_BASIC_BTN) {
            requestManager.load(listViewItemList.get(position).getProduct_img()).asBitmap().into(viewHolder.product_img);
        } else if (itemtype == ITEM_TYPE_SPIN) {
            viewHolder.product_price.setText(listViewItemList.get(position).getProduct_price());
            viewHolder.product_name.setText(listViewItemList.get(position).getProduct_name());
            requestManager.load(listViewItemList.get(position).getProduct_img()).asBitmap().into(viewHolder.product_img);
            if (spin_no == 0) {
            } else {
                spin_no = Integer.parseInt(listViewItemList.get(position).getProduct_no().toString());
                requestManager.load(listViewItemList.get(position).getProduct_img()).asBitmap().into(viewHolder.product_img);
                viewHolder.product_spinner_m.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        spin_no -= 1;
                        viewHolder.product_spinner_no.setText(Integer.toString(spin_no));
                    }
                });
                viewHolder.product_spinner_p.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        spin_no += 1;
                        viewHolder.product_spinner_no.setText(Integer.toString(spin_no));
                    }
                });
            }
            viewHolder.product_right_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    listViewItemList.remove(position);
//                    listViewItemList.remove(position+1);
                    notifyDataSetChanged();
                }
            });
        } else if (itemtype == ITEM_TYPE_DATE) {
            requestManager.load(listViewItemList.get(position).getProduct_img()).asBitmap().into(viewHolder.product_img);
           viewHolder.product_date.setText(listViewItemList.get(position).getProduct_date());
            viewHolder.product_price.setText(listViewItemList.get(position).getProduct_price());
            viewHolder.product_name.setText(listViewItemList.get(position).getProduct_name());
            requestManager.load(listViewItemList.get(position).getProduct_img()).asBitmap().into(viewHolder.product_img);
           viewHolder.product_status.setText(listViewItemList.get(position).getProduct_status());
        } else if (itemtype == ITEM_TYPE_TITLE) {
        } else if (itemtype == ITEM_TYPE_MORE) {
            viewHolder.product_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (more) {
                        more = false;
                        viewHolder.product_more_icon.setBackground(context.getResources().getDrawable(R.drawable.more_up));
                    } else {
                        more = true;
                        viewHolder.product_more_icon.setBackground(context.getResources().getDrawable(R.drawable.more));

                    }
                }
            });
//            requestManager.load(listViewItemList.get(position).getImg()[0]).asBitmap().into(viewHolder.iv_1);
//            requestManager.load(listViewItemList.get(position).getImg()[1]).asBitmap().into(viewHolder.iv_2);
//            requestManager.load(listViewItemList.get(position).getImg()[2]).asBitmap().into(viewHolder.iv_3);

        }


    }


    @Override
    public int getItemCount() {
        return (null != listViewItemList ? listViewItemList.size() : 0);
    }

    /**
     * 뷰 재활용을 위한 viewHolder`
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView product_img;
        protected TextView product_name, product_price, product_no;

        protected ImageView product_right_img, product_ch;
        protected TextView product_spinner_m, product_spinner_no, product_spinner_p;
        protected TextView product_title_date, product_title_no;
        protected LinearLayout product_more;
        protected TextView product_status, product_date;
        protected  ImageView product_more_icon;

        public ViewHolder(View itemView, int type) {
            super(itemView);
            product_img = (ImageView) itemView.findViewById(R.id.product_img);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            product_price = (TextView) itemView.findViewById(R.id.product_price);
            product_no = (TextView) itemView.findViewById(R.id.product_no);

            //basic
            if (type == ITEM_TYPE_BASIC) {
                product_right_img = (ImageView) itemView.findViewById(R.id.product_right_btn);
            } else if (type == ITEM_TYPE_BASIC_BTN) {
            } else if (type == ITEM_TYPE_SPIN) {
//                prospa
                product_spinner_m = (TextView) itemView.findViewById(R.id.product_spinner_m);
                product_spinner_no = (TextView) itemView.findViewById(R.id.product_spinner_no);
                product_spinner_p = (TextView) itemView.findViewById(R.id.product_spinner_p);
                product_no.setVisibility(View.INVISIBLE);
                product_right_img = (ImageView) itemView.findViewById(R.id.product_right_btn);
            } else if (type == ITEM_TYPE_DATE) {
                product_date=(TextView)itemView.findViewById(R.id.product_date);
                product_status=(TextView)itemView.findViewById(R.id.product_status);
            } else if (type == ITEM_TYPE_TITLE) {
            } else if (type == ITEM_TYPE_MORE) {
                product_more = (LinearLayout) itemView.findViewById(R.id.product_more);
                product_more_icon = (ImageView) itemView.findViewById(R.id.product_more_icon);
            }
//
        }

    }


}

