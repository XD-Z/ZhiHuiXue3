package com.rhkj.zhihuixue.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.MessagedetailsActivity;
import com.rhkj.zhihuixue.adapter.MessageAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.utils.SimpleDividerItemDecoration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 消息通知
 */
public class MessageActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.message_re)
    RecyclerView messageRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

    }

    @Override
    protected void initViews() {
        super.initViews();
        tvTitle.setText("消息管理");
        messageRe.setLayoutManager(new LinearLayoutManager(this));
        messageRe.addItemDecoration(new SimpleDividerItemDecoration(this, 1));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("");
        strings.add("");
        strings.add("");
        strings.add("");
        MessageAdapter messageAdapter = new MessageAdapter(strings);
        messageRe.setAdapter(messageAdapter);

        messageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(MessageActivity.this, MessagedetailsActivity.class));
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    protected void addListener() {
        super.addListener();
    }
}
