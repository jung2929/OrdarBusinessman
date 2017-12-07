package com.yep.odar.Util;

/**
 * Created by yep on 2017. 9. 26..
 */

import java.io.PrintWriter;
import java.io.StringWriter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class U_Main_ViewPager extends ViewPager {
    private int mCurrentPagePosition = 0;
    private boolean enabled; //스크롤을 막아주는 중요 변수!

    public U_Main_ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }
    public U_Main_ViewPager(Context context) {
        super(context);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        try {
            if (this.enabled) {
                return super.onTouchEvent(event);
            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsStrting = sw.toString();
            Log.e("INFO", exceptionAsStrting);
        }
        return false;
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        try {
//            View child = getChildAt(mCurrentPagePosition);
//            if (child != null) {
//                child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//                int h = child.getMeasuredHeight();
//                heightMeasureSpec = MeasureSpec.makeMeasureSpec(h, MeasureSpec.EXACTLY);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    public void reMeasureCurrentPage(int position) {
        mCurrentPagePosition = position;
        requestLayout();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    public void setPagingEnabled() { //이 메소드를 이용해서 스크롤을 풀어주고
        this.enabled = true;
    }

    public void setPagingDisabled() { //이 메소드를 이용해서 스크롤을 막아줍니다.
        this.enabled = false;
    }

}