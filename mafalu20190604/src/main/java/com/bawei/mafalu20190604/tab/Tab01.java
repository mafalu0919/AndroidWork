package com.bawei.mafalu20190604.tab;

import android.widget.ScrollView;
import android.widget.Toast;

import com.bawei.mafalu20190604.MyGradView;
import com.bawei.mafalu20190604.R;
import com.bawei.mafalu20190604.adapter.LisAdapter;
import com.bawei.mafalu20190604.base.FragActivity;
import com.bawei.mafalu20190604.bean.BeanT;
import com.bawei.mafalu20190604.util.HttpUtil;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:8:50
 *@Description:展示数据
 * */public class Tab01 extends FragActivity {

    private PullToRefreshScrollView pull;
    private MyGradView mgv;
    private HttpUtil util;
    private String str = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=3&page=";
    private int page = 1;
    private ArrayList<BeanT> list = new ArrayList<>();
    private LisAdapter adapter;

    @Override
    public int bindLayout() {
        return R.layout.tab01;
    }

    @Override
    public void bindView() {
        pull = getView().findViewById(R.id.pull);
        mgv = getView().findViewById(R.id.mgv);

    }

    @Override
    public void initData() {
        util = HttpUtil.getInstance();
        //上下拉模式
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        //适配器
        adapter = new LisAdapter(list, getActivity());
        mgv.setAdapter(adapter);
        /* 请求数据*/
        getData();

    }


    @Override
    public void bindLis() {
        //上下拉刷新加载
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page = 1;
                getData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                page++;
                getData();
            }
        });

    }

    private void getData() {
        if (util.isWork(getActivity())) {
            Toast.makeText(getActivity(), "正在加载数据。。。。。", Toast.LENGTH_SHORT).show();
            util.getAsyncStr(str + page, new HttpUtil.CallBackStr() {
                @Override
                public void getStr(String s) {
                    if(page==1){
                        list.clear();
                    }
                    try {
                        JSONObject object = new JSONObject(s);
                        JSONArray result = object.getJSONArray("result");
                        for (int i = 0; i < result.length(); i++) {
                            JSONObject jsonObject = (JSONObject) result.get(i);
                            String id = jsonObject.getString("id");
                            String imageUrl = jsonObject.getString("imageUrl");
                            String summary = jsonObject.getString("summary");
                            list.add(new BeanT(id, imageUrl, summary));
                        }
                        adapter.notifyDataSetChanged();
                        pull.onRefreshComplete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(), "请开启网络。。。。。", Toast.LENGTH_SHORT).show();
        }
    }

}
