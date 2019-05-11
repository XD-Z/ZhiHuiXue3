package com.rhkj.zhihuixue.activity;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 *   订单详情/
 * Created by zjx on 2019/5/8.
 */

public class OrderCancelActivity extends BaseActivity {
    @Override
    protected void initLayout() {
        setContentView(R.layout.ac_order_cancel);
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorAppTheme)
                .statusBarDarkFont(true)
                .fitsSystemWindows(true)
                .init();
    }
}
