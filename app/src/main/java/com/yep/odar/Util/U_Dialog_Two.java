package com.yep.odar.Util;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.yep.odar.Activity.Cart;
import com.yep.odar.R;

/**
 * Created by yep on 2017. 10. 14..
 */

public class U_Dialog_Two extends Dialog {

    private Context context;
    private TextView tv_title, tv_contents, tv_exit;
    private String title, contents;
    private TextView cancel, submit;


    public U_Dialog_Two(Context context, String title, String contents) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.context = context;
        this.title = title;
        this.contents = contents;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        setContentView(R.layout.c_dialog_two);

        tv_title =(TextView)findViewById(R.id.dialog_title);
        tv_contents = (TextView)findViewById(R.id.dialog_contents);
        cancel = (TextView)findViewById(R.id.exit);
        submit = (TextView)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setTextColor(getContext().getResources().getColor(R.color.color_white));
                submit.setBackground(getContext().getResources().getDrawable(R.color.color_main));
                Intent intent = new Intent(context, Cart.class);
                context.startActivity(intent);
            }
        });
//        tv_exit =(TextView)findViewById(R.id.dialog_exit);

        tv_title.setText("바로주문에 상품이 담겼습니다");
        tv_contents.setText("주문요청 하러 가시겠습니까?");

    }


}

