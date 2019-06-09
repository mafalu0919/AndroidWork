package com.bawei.mafalu20190604.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *@Auther:mfl
 *@Date: 2019/6/4
 *@Time:9:01
 *@Description:网络请求工具类
 * */public class HttpUtil {
     private static HttpUtil util=new HttpUtil();
    private HttpURLConnection connection;
    private Bitmap bitmap;

    private HttpUtil() {
    }
    public static HttpUtil getInstance(){
        return util;
    }
   /* 判断网络*/
    public boolean isWork(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info!=null){
            return true;
        }else {
            return false;
        }
    }
    //网络请求
    public String getString(String strUrl){
        try {
            URL url=new URL(strUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            if(connection.getResponseCode()==200){
                InputStream stream = connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer=new StringBuffer();
                String str="";
                while ((str=reader.readLine())!=null){
                    buffer.append(str);
                }
                reader.close();
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //字符串接口
    public interface CallBackStr{
        void getStr(String s);
    }
    //AsyncTask异步请求
    public void getAsyncStr(String str, final CallBackStr backStr){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getString(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                backStr.getStr(s);
            }
        }.execute(str);
    }
    //==========================================================================
    //网络请求
    public Bitmap getBit(String strUrl){
        try {
            URL url=new URL(strUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            if(connection.getResponseCode()==200){
                InputStream stream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(stream);

                return bitmap;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //图片接口
    public interface CallBackBit{
        void getBit(Bitmap bitmap);
    }
    //AsyncTask异步请求
    public void getAsyncBit(String str, final CallBackBit backBit){
        new AsyncTask<String, Integer, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... strings) {
                return getBit(strings[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                backBit.getBit(bitmap);
            }
        }.execute(str);
    }
}
