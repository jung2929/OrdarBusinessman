package com.yep.odar.Util;

import android.app.Dialog;
import android.content.Context;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yep.odar.R;

public class U_Dialog_Radio extends Dialog {

    private Context context;
    private TextView tv_title, tv_exit;
    private TextView radio1_title, radio2_title, radio3_title;
    private ImageView radio1, radio2,radio3;
    private RelativeLayout radio1_back, radio2_back,radio3_back;
    private String title, contents;


    public U_Dialog_Radio(Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.context = context;
//        this.title = title;
//        this.contents = contents;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.c_dialog_radio);

        radio1_back = (RelativeLayout)findViewById(R.id.radio1_back);
        radio2_back = (RelativeLayout)findViewById(R.id.radio2_back);
        radio3_back = (RelativeLayout)findViewById(R.id.radio3_back);
        tv_title =(TextView)findViewById(R.id.dialog_title);
        tv_exit =(TextView)findViewById(R.id.dialog_exit);
        radio1 = (ImageView) findViewById(R.id.radio1);
        radio1_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio1.setBackground(context.getResources().getDrawable(R.drawable.radio_ch));
                radio2.setBackground(context.getResources().getDrawable(R.drawable.radio_unch));
                radio3.setBackground(context.getResources().getDrawable(R.drawable.radio_unch));
            }
        });
        radio2 = (ImageView) findViewById(R.id.radio2);
        radio2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio2.setBackground(context.getResources().getDrawable(R.drawable.radio_ch));
                radio1.setBackground(context.getResources().getDrawable(R.drawable.radio_unch));
                radio3.setBackground(context.getResources().getDrawable(R.drawable.radio_unch));

            }
        });
        radio3 = (ImageView) findViewById(R.id.radio3);
        radio3_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radio3.setBackground(context.getResources().getDrawable(R.drawable.radio_ch));
                radio2.setBackground(context.getResources().getDrawable(R.drawable.radio_unch));
                radio1.setBackground(context.getResources().getDrawable(R.drawable.radio_unch));
            }
        });

        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                U_Dialog_Radio.this.dismiss();
            }
        });

    }


}

