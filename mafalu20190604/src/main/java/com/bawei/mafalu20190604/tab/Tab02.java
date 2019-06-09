package com.bawei.mafalu20190604.tab;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bawei.mafalu20190604.R;
import com.bawei.mafalu20190604.base.FragActivity;

import static android.app.Activity.RESULT_OK;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:8:50
 *@Description:个人信息
 * */public class Tab02 extends FragActivity {

    private ImageView img;
    private WebView web;

    @Override
    public int bindLayout() {
        return R.layout.tab02;
    }

    @Override
    public void bindView() {
        img = getView().findViewById(R.id.img);
        web = getView().findViewById(R.id.web);

    }

    @Override
    public void initData() {
        web.loadUrl("https://baike.baidu.com/item/%E9%A3%8E%E6%99%AF/645?fr=aladdin");
        web.setWebViewClient(new WebViewClient());

    }

    @Override
    public void bindLis() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10&resultCode==RESULT_OK){
            Uri data1 = data.getData();
            img.setImageURI(data1);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        img.setOnClickListener(null);
    }
}
