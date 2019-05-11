package com.rhkj.zhihuixue.activity;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 支付
 * Created by zjx on 2019/5/11.
 */

public class PaymentActivity extends BaseActivity {

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_payment);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("确认订单");
    }
}
