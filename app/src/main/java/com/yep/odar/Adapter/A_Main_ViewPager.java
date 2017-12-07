package com.yep.odar.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;


import com.yep.odar.Activity.Main_Category;
import com.yep.odar.Activity.Main_Home;
import com.yep.odar.Activity.Main_Mypage;
import com.yep.odar.Activity.Main_Tip;

/**
 * Created by yep on 2017. 9. 26..
 */

public class A_Main_ViewPager extends FragmentStatePagerAdapter {

    /*
	 * 이 클래스의 부모생성자 호출시 인수로 반드시 FragmentManager객체를 넘겨야한다.
	 * 이 객체는 Activity에서만 만들수 있고, 여기서사용중인 Fragment가 v4이기 때문에
	 * Activity중에서도 ActionBarActivity에서 얻어와야한다.
	 */
    private boolean enabled;

    Fragment[] fragments = new Fragment[4];


    public A_Main_ViewPager(FragmentManager fm) {
        super(fm);
        fragments[0] = new Main_Home();
        fragments[1] = new Main_Category();
        fragments[2] = new Main_Tip();
        fragments[3] = new Main_Mypage();
    }


    /*
     * 여러 프레그먼트 중 어떤 프레그먼트를 보여줄지 결정
     */
    public Fragment getItem(int arg0) {
        return fragments[arg0];
    }

    /*
     * 보여질 프레그먼트가 몇개인지 결정
     */
    public int getCount() {
        return fragments.length;
    }

    @Override
    public int getItemPosition(Object object) {
//        if(object instanceof  Main_Category){
//            return POSITION_NONE;
//        }else if(object instanceof  Main_Home){
//            return POSITION_UNCHANGED;
//        }
        return super.getItemPosition(object);

    }
}

