package com.rhkj.zhihuixue.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.Toast;

public abstract class BaseActivity extends FragmentActivity {
    private Toast toast; // 公共的。。。。 Toast
    public static int screenW, screenH; // 全屏 宽高

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initLayout();
        initViews();
        initData();
        addListener();
    }

    /************************** 公共功能封装 ****************************************/

    /** 初始化布局 */
    protected void initLayout() {
    }

    /** 初始化组件 */
    protected void initViews() {
    }

    /** 初始化数据 */
    protected void initData() {
    }

    /** 添加监听 */
    protected void addListener() {
    }

    /**
     *
     * @Description: 根据资源ID获得字符串并显示在Toast上
     * @param resId
     *            资源ID
     */
    public void showToast(int resId) {
        showToast(getString(resId));
    }

    /**
     *
     * @Description: 显示Toast提示
     * @param msg
     *            要显示的字符串
     */
    public void showToast(String msg) {
        if (toast == null)
            toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setDuration(Toast.LENGTH_SHORT); // 设置显示时间
        toast.setText(msg); // 设置显示内容
        toast.show();

    }

    /**
     * @Description: 不传值和URI的显式启动Activity(带动画)
     * @param pClass
     *            要启动的Activity 的CLass类
     */
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null, null);
    }

    /**
     * @Description: 带封装值但不带URi的显式启动Activity(带动画)
     * @param pClass
     *            要启动的Activity 的CLass类
     * @param bundle
     *            储存封装值的Bundle
     */
    public void openActivity(Class<?> pClass, Bundle bundle) {
        openActivity(pClass, bundle, null);
    }

    /**
     * @Description: 带封装值且带URi的显式启动Activity(带动画)
     * @param pClass
     *            要启动的Activity 的CLass类
     * @param bundle
     *            储存封装值的Bundle
     * @param uri
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
     * @Description: 不传值和URI的隐式启动Activity(带动画)
     * @param action
     *            要启动的Activity 的action
     */
    public void openActivity(String action) {
        openActivity(action, null, null);
    }

    /**
     * @Description: 带封装值但不带URi的隐式启动Activity(带动画)
     * @param action
     *            要启动的Activity 的action
     * @param bundle
     *            储存封装值的Bundle
     */
    public void openActivity(String action, Bundle bundle) {
        openActivity(action, bundle, null);
    }

    /**
     * @Description: 带封装值且带URi的隐式启动Activity(带动画)
     * @param action
     *            要启动的Activity 的action
     * @param bundle
     *            储存封装值的Bundle
     * @param uri
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
     *
     * @Description: 本Activity结束时 带动画退出
     */
    public void myFinish() {
        super.finish();
    }
}
