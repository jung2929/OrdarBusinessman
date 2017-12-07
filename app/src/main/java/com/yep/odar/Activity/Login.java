package com.yep.odar.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yep.odar.Base.Base_Avtivity;
import com.yep.odar.R;
import com.yep.odar.Util.U_Dialog;
import com.yep.odar.Util.U_TextWatcher;

public class Login extends Base_Avtivity {
    private EditText loginId, loginPw;
    private TextView loginIdCh, loginPwCh;
    private ImageView loginDeleteId, loginDeletePw;
    private RelativeLayout loginAuto;
    private ImageView loginAutoIv;
    private TextView loginAutoTv;
    private LinearLayout loginBack;
    private TextView login, loginToJoin;

    private Intent intent;
    private boolean login_auto = false;
    private U_Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setActionBar(NO_ACTION_BAR,"");
        setContentView(R.layout.l_login);
        find_id();
        loginId.addTextChangedListener(new U_TextWatcher(loginId, loginDeleteId, loginIdCh, getResources().getString(R.string.login_id)));
        loginPw.addTextChangedListener(new U_TextWatcher(loginPw, loginDeletePw, loginPwCh, getResources().getString(R.string.login_pw)));

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                hide_keyboard();
                loginId.clearFocus();
                loginPw.clearFocus();
                break;
            case R.id.login_id:
                loginIdCh.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_pw:
                loginPwCh.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_delete_id:
                loginId.setText("");
                loginId.setHint(getResources().getString(R.string.login_id));
                loginDeleteId.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_delete_pw:
                loginPw.setText("");
                loginPw.setHint(getResources().getString(R.string.login_pw));
                loginDeletePw.setVisibility(View.INVISIBLE);
                break;
            case R.id.login_auto:
                if (login_auto == false) {
                    login_auto = true;
                    loginAutoIv.setBackground(getResources().getDrawable(R.drawable.login_checked));
                    loginAutoTv.setTextColor(getResources().getColor(R.color.color_main));
                } else {
                    login_auto = false;
                    loginAutoIv.setBackground(getResources().getDrawable(R.drawable.login_unchecked));
                    loginAutoTv.setTextColor(getResources().getColor(R.color.color_text_light));
                }

                break;
            case R.id.login:
                //@@@login@@@
                //id:aaa
                //pw:12345
                if (loginId.getText().toString().equals(id) && loginPw.getText().toString().equals("12345")) {
                    intent = new Intent(Login.this, Main_Base.class);
                    startActivity(intent);
                    finish();
                } else if (loginId.getText().toString().equals("") || loginPw.getText().toString().equals("")) {
                    if (!loginId.getText().toString().equals("")) {
                        loginPwCh.setVisibility(View.VISIBLE);
                    } else if (!loginPw.getText().toString().equals("")) {
                        loginIdCh.setVisibility(View.VISIBLE);
                    } else {
                        loginIdCh.setVisibility(View.VISIBLE);
                        loginPwCh.setVisibility(View.VISIBLE);
                    }
                } else {
                    dialog = new U_Dialog(Login.this, getResources().getString(R.string.login_dialog_title), getResources().getString(R.string.login_dialog_contents));
                    dialog.show();
                }
                break;
            case R.id.login_to_join:
                intent = new Intent(Login.this, Join.class);
                startActivity(intent);
                break;
        }

    }


    void hide_keyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(loginId.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(loginPw.getWindowToken(), 0);
    }

    void find_id() {
        loginId = (EditText)findViewById(R.id.login_id);
        loginPw = (EditText)findViewById(R.id.login_pw);
        loginIdCh = (TextView)findViewById(R.id.login_id_ch);
        loginPwCh = (TextView)findViewById(R.id.login_pw_ch);
        loginDeleteId =(ImageView)findViewById(R.id.login_delete_id);
        loginDeletePw =(ImageView)findViewById(R.id.login_delete_pw);
        loginAuto= (RelativeLayout)findViewById(R.id.login_auto);
        loginAutoIv  = (ImageView)findViewById(R.id.login_auto_iv);
        loginAutoTv  = (TextView)findViewById(R.id.login_auto_tv);
        loginBack = (LinearLayout)findViewById(R.id.login_back);
        login =(TextView)findViewById(R.id.login);
        loginToJoin =(TextView)findViewById(R.id.login_to_join);
    }

}
