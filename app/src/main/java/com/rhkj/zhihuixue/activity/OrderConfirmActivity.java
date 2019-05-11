package com.rhkj.zhihuixue.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;

/**
 * 确认订单
 * Created by zjx on 2019/5/11.
 */

public class OrderConfirmActivity extends BaseActivity implements View.OnClickListener {

    private Button btnSubmission;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_order_confirm);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("确认订单");
        btnSubmission = findViewById(R.id.btn_submission);

        initListenet();

    }

    private void initListenet() {
        btnSubmission.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submission:
                startActivity(new Intent(this,PaymentActivity.class));
                break;
        }

    }
}
