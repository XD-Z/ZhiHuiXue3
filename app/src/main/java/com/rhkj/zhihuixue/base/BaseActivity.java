package com.rhkj.zhihuixue.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.utils.MyApplication;

public abstract class BaseActivity extends AppCompatActivity {
    private Toast toast; // 公共的。。。。 Toast
    public static int screenW, screenH; // 全屏 宽高
    public TextView tvTitle;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

        // 添加Activity到堆栈
        MyApplication.getInstance().addActivity(this);

        initLayout();
        initTitle();
        initViews();
        initData();
        addListener();


    }

    private void initTitle() {
        tvTitle = findViewById(R.id.tv_title);
        ImageView ivBack = findViewById(R.id.iv_back);

        if (ivBack != null) {
            ivBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

    }


    /************************** 公共功能封装 ****************************************/

    /**
     * 初始化布局
     */
    protected void initLayout() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorWhile)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                .init();
    }

    /**
     * 初始化组件
     */
    protected void initViews() {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 添加监听
     */
    protected void addListener() {
    }

    /**
     * @param resId 资源ID
     * @Description: 根据资源ID获得字符串并显示在Toast上
     */
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    /**
     * @param msg 要显示的字符串
     * @Description: 显示Toast提示
     */
    public void showToast(String msg) {
        if (toast == null)
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setDuration(Toast.LENGTH_SHORT); // 设置显示时间
        toast.setText(msg); // 设置显示内容
        toast.show();

    }


    /**
     * @param pClass 要启动的Activity 的CLass类
     * @Description: 不传值和URI的显式启动Activity(带动画)
     */
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null, null);
    }

    /**
     * @param pClass 要启动的Activity 的CLass类
     * @param bundle 储存封装值的Bundle
     * @Description: 带封装值但不带URi的显式启动Activity(带动画)
     */
    public void openActivity(Class<?> pClass, Bundle bundle) {
        openActivity(pClass, bundle, null);
    }

    /**
     * @param pClass 要启动的Activity 的CLass类
     * @param bundle 储存封装值的Bundle
     * @param uri
     * @Description: 带封装值且带URi的显式启动Activity(带动画)
     */
    public void openActivity(Class<?> pClass, Bundle bundle, Uri uri) {
        Intent intent = new Intent(this, pClass);
        if (bundle != null)
            intent.putExtras(bundle);
        if (uri != null)
            intent.setData(uri);
        startActivity(intent);

    }

    /**
     * @param action 要启动的Activity 的action
     * @Description: 不传值和URI的隐式启动Activity(带动画)
     */
    public void openActivity(String action) {
        openActivity(action, null, null);
    }

    /**
     * @param action 要启动的Activity 的action
     * @param bundle 储存封装值的Bundle
     * @Description: 带封装值但不带URi的隐式启动Activity(带动画)
     */
    public void openActivity(String action, Bundle bundle) {
        openActivity(action, bundle, null);
    }

    /**
     * @param action 要启动的Activity 的action
     * @param bundle 储存封装值的Bundle
     * @param uri
     * @Description: 带封装值且带URi的隐式启动Activity(带动画)
     */
    public void openActivity(String action, Bundle bundle, Uri uri) {
        Intent intent = new Intent(action);
        if (bundle != null)
            intent.putExtras(bundle);
        if (uri != null)
            intent.setData(uri);
        startActivity(intent);
    }

    /**
     * @Description: 本Activity结束时 带动画退出
     */
    public void myFinish() {
        super.finish();
    }
}
