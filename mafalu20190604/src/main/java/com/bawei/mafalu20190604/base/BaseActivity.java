package com.bawei.mafalu20190604.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:8:43
 *@Description:Activity基类
 * */public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        bindView();
        initData();
        bindLis();
    }
    public abstract int  bindLayout();
    public abstract void bindView();
    public abstract void initData();
    public abstract void bindLis();

}
