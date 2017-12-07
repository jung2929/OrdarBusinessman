package com.yep.odar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.R;

public class Tip_Detail extends Base_Avtivity {
    private ImageView tip_back, tip_heart;
    private TextView tip_contents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(NO_ACTION_BAR,"");
        setContentView(R.layout.l_tip_detail);

        tip_back = (ImageView)findViewById(R.id.tip_back);
        tip_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tip_heart = (ImageView)findViewById(R.id.tip_like);
        tip_contents = (TextView)findViewById(R.id.tip_contents);
        tip_contents.setText("저희 집은 한식을 운영합니다~ \n" +
                "된장찌개가 유명한데 더 맛좋고 영양좋은 된장찌개를\n" +
                "위해서 두부를 얼려서 사용하는데요..\n" +
                "\n" +
                "얼린 두부의 효능을 아시는 분이 많으실지 모르겠네요 ^^;\n" +
                "예전에 티비에서 두부를 얼리면 영양이 배가 되고\n" +
                "단단한 질감이 맛을 풍부하게 한다고 봐서\n" +
                "그 후로 얼린 두부를 쓰고 있는데 아주 맛이 좋고\n" +
                "손님들도 신기해서 두부에 대해서 물어봅니다\n" +
                "\n" +
                "처음 드시면 이질감이 느껴질 수도 있으니 한번 집에서\n" +
                "이리저리 실험해보시구 메뉴에 반영해보세요~~\n" +
                "방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +"방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" + "방법은 별로 안어려워요 저희 집은 두부를 락앤락통에\n" +
                "\n" +
                "\n");
    }
}
