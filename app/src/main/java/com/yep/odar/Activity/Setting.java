package com.yep.odar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.R;

public class Setting extends Base_Avtivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(CUSTOM_ACTION_BAR_BACK,"설정");
        setContentView(R.layout.l_setting);
    }
}
