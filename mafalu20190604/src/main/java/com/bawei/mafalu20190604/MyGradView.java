package com.bawei.mafalu20190604;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:9:17
 *@Description:
 * */public class MyGradView extends GridView {
    public MyGradView(Context context) {
        super(context);
    }

    public MyGradView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGradView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
