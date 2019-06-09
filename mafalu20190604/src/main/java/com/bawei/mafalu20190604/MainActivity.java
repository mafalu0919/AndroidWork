package com.bawei.mafalu20190604;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bawei.mafalu20190604.adapter.TabAdapter;
import com.bawei.mafalu20190604.base.BaseActivity;
import com.bawei.mafalu20190604.tab.Tab01;
import com.bawei.mafalu20190604.tab.Tab02;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    private ViewPager prag;
    private TabLayout tab;
    private ArrayList<String> tlist;
    private ArrayList<Fragment> flist;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindView() {
        prag = findViewById(R.id.prag);
        tab = findViewById(R.id.tab);

    }

    @Override
    public void initData() {
        tlist = new ArrayList<>();
        tlist.add("首页");
        tlist.add("我的");
        flist = new ArrayList<>();
        flist.add(new Tab01());
        flist.add(new Tab02());
        TabAdapter adapter=new TabAdapter(getSupportFragmentManager(),tlist,flist);
        prag.setAdapter(adapter);
        tab.setupWithViewPager(prag);

    }

    @Override
    public void bindLis() {

    }
}
