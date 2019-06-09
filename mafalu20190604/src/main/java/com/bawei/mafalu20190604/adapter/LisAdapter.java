package com.bawei.mafalu20190604.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.mafalu20190604.R;
import com.bawei.mafalu20190604.bean.BeanT;
import com.bawei.mafalu20190604.util.HttpUtil;

import java.util.ArrayList;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:9:30
 *@Description:listview适配器
 * */public class LisAdapter  extends BaseAdapter {
    private ArrayList<BeanT> list;
    private Context context;

    public LisAdapter(ArrayList<BeanT> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holder=new ViewHolder();
            holder.img=convertView.findViewById(R.id.img);
            holder.tv=convertView.findViewById(R.id.tv);
            holder.tv1=convertView.findViewById(R.id.tv1);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getSummary());
        holder.tv1.setText(list.get(position).getId());
        HttpUtil util = HttpUtil.getInstance();
        final ViewHolder finalHolder = holder;
        util.getAsyncBit(list.get(position).getImageUrl(), new HttpUtil.CallBackBit() {
            @Override
            public void getBit(Bitmap bitmap) {
                finalHolder.img.setImageBitmap(bitmap);
            }
        });
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView tv;
        TextView tv1;
    }
}
