package com.yep.odar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.R;

public class Complete extends Base_Avtivity {
    private String type;
    private Intent  intent;
    private TextView t1,t2,t3,t4,t5,t6,t7,t8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_complete);
        t1=(TextView)findViewById(R.id.title1);
        t2=(TextView)findViewById(R.id.title2);
        t3=(TextView)findViewById(R.id.title3);
        t4=(TextView)findViewById(R.id.title4);
        t5=(TextView)findViewById(R.id.title5);
        t6=(TextView)findViewById(R.id.title6);
        t7=(TextView)findViewById(R.id.title7);
        t8=(TextView)findViewById(R.id.title8);
        intent = getIntent();
        type = intent.getStringExtra("type");
        if(type.equals("odar")){
            super.setActionBar(CUSTOM_ACTION_BAR_EXIT, "주문요청완료");
            t3.setText("돼지갈비 3KG외 5개품목");
            t4.setText("예상 오다가 : 173,070원");
            t6.setText("서울시 강남구 테헤란로 342-44");

        }else {
            super.setActionBar(CUSTOM_ACTION_BAR_EXIT, "정산완료");
            t3.setText("돼지갈비 3KG … 외 3개의 상품");
            t4.setText("예상 오다가 : 173,070원");
            t6.setText("무통장입금");
            t7.setText("신한은행 831-212-14829 (주)오다");
            t1.setText("정산이 완료되었습니다!");
            t8.setText("오다를 이용해주셔서 감사합니다\n" +
                    "더 저렴하고 품질 좋은 식자재를 위해 노력하겠습니다");
        }

//        intent = getIntent(); // payment,odar
//        type = intent.getStringExtra("type");

    }
}
