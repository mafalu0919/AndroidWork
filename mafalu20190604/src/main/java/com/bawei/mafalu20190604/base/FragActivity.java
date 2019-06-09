package com.bawei.mafalu20190604.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.mafalu20190604.R;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:8:51
 *@Description:fragment基类
 * */public abstract class FragActivity extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(),container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView();
        initData();
        bindLis();
    }
    public abstract int  bindLayout();
    public abstract void bindView();
    public abstract void initData();
    public abstract void bindLis();
}
