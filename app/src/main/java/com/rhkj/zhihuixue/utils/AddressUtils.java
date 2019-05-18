package com.rhkj.zhihuixue.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by zjx on 2018/10/23.
 */

public class AddressUtils  {

    private String json;

    //一级 城市名
    private ArrayList<String> itemOneList = new ArrayList<>();
    //二级 城市名
    private ArrayList<ArrayList<String>> itemTwoList = new ArrayList<>();
    //三级 城市名
    private ArrayList<ArrayList<ArrayList<String>>> itemthreeList = new ArrayList<>();

    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private Thread thread;

    private boolean isLoaded = false;

    private Context context;

    public AddressUtils(Context context){
        this.context=context;

        json = getJson("city.json");
        handler.sendEmptyMessage(MSG_LOAD_DATA);

    }

    public ArrayList<String> getItemOneList() {
        return itemOneList;
    }

    public ArrayList<ArrayList<String>> getItemTwoList() {
        return itemTwoList;
    }

    public ArrayList<ArrayList<ArrayList<String>>> getItemthreeList() {
        return itemthreeList;
    }


    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;
                case MSG_LOAD_SUCCESS:
                    isLoaded = true;
                    break;
                case MSG_LOAD_FAILED:
                    Toast.makeText(context, "解析数据失败", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }

    };


    public String getJson(String fileName) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            InputStream open = assetManager.open(fileName);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int ch = -1;
            byte[] buffer = new byte[1024 * 4];
            while ((ch = open.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, ch);

            }
            open.close();
            byteArrayOutputStream.close();
            return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    int one = 0;
    int two = 0;
    int three = 0;
    private void initJsonData() {
        //第一级解析
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray sheng = jsonObject.getJSONArray("sheng");
            for (one = 0; one < sheng.length(); one++) {
                JSONObject o = (JSONObject) sheng.get(one);
                //获取城市名
                String region_name = o.getString("region_name");
                JSONArray shi = o.getJSONArray("shi");

                itemOneList.add(region_name);


                //二级城市名字
                final ArrayList<String> twoList = new ArrayList<>();

                //三级城市
                final ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();

                //二级解析
                try {
                    for (two = 0; two < shi.length(); two++) {
                        JSONObject o1 = (JSONObject) shi.get(two);
                        String region_name1 = o1.getString("region_name");


                        JSONArray qu = o1.getJSONArray("qu");

                        twoList.add(region_name1);

                        //三级城市名字  ID
                        final ArrayList<String> strings = new ArrayList<>();
                        final ArrayList<String> idstrings = new ArrayList<>();

                        //三级解析
                        try {
                            if (qu.length() != 0) {
                                for (three = 0; three < qu.length(); three++) {
                                    JSONObject o2 = (JSONObject) qu.get(three);
                                    String region_name2 = o2.getString("region_name");
                                    strings.add(region_name2);
                                }
                            } else {
                                strings.add("");
                            }
                            arrayLists.add(strings);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    //二级
                    itemTwoList.add(twoList);


                    //三级
                    itemthreeList.add(arrayLists);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        handler.sendEmptyMessage(MSG_LOAD_SUCCESS);
    }

}
