package com.yep.odar.Util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.yep.odar.R;

public class U_Dialog extends Dialog {

    private Context context;
    private TextView tv_title, tv_contents, tv_exit;
    private String title, contents;


    public U_Dialog(Context context, String title, String contents) {
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
        setContentView(R.layout.c_dialog);

        tv_title =(TextView)findViewById(R.id.dialog_title);
        tv_contents = (TextView)findViewById(R.id.dialog_contents);
        tv_exit =(TextView)findViewById(R.id.dialog_exit);

        tv_title.setText(title);
        tv_contents.setText(contents);
        tv_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                U_Dialog.this.dismiss();
            }
        });

    }


}

