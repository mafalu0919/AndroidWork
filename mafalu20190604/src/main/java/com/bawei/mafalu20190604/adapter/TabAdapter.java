package com.bawei.mafalu20190604.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:8:55
 *@Description:tablayout的适配器
 * */public class TabAdapter extends FragmentPagerAdapter {
    private ArrayList<String> tlist;
    private ArrayList<Fragment> flist;

    public TabAdapter(FragmentManager fm, ArrayList<String> tlist, ArrayList<Fragment> flist) {
        super(fm);
        this.tlist = tlist;
        this.flist = flist;
    }

    @Override
    public Fragment getItem(int i) {
        return flist.get(i);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tlist.get(position);
    }
}
