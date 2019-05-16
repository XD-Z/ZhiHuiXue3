package com.rhkj.zhihuixue.activity;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;

/**
 * 服务介绍
 * <p>
 * Created by zjx on 2019/5/7.
 */

public class FuwuIntroduceActivity extends BaseActivity {


    private WebView webView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_fuwu_introduce);
    }

    @Override
    protected void initViews() {
        webView = findViewById(R.id.web);


    }

    @Override
    protected void initData() {
        super.initData();
        tvTitle.setText("服务介绍");

        OkHttpUtils.post()
                .url(Contents.SERVICE)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int state = jsonObject.getInt("state");
                            if (state == 200) {
                                JSONArray data = jsonObject.getJSONArray("data");

                                JSONObject o = (JSONObject) data.get(0);
                                String desc = o.getString("desc");
                                webView.loadUrl(desc);

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });


    }
}
