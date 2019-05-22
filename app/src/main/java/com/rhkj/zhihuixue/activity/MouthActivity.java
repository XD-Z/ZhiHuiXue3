package com.rhkj.zhihuixue.activity;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.AdaptScreenUtils;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.MouthOneAdapter;
import com.rhkj.zhihuixue.adapter.MouthThreeAdapter;
import com.rhkj.zhihuixue.adapter.MouthTwoAdapter;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.bean.MouthOneBean;
import com.rhkj.zhihuixue.bean.MouthThreeBean;
import com.rhkj.zhihuixue.bean.MouthTwoBean;

import java.util.ArrayList;
import java.util.Arrays;

import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewAdapter;

/**
 * 口语训练
 * <p>
 * Created by zjx on 2019/5/21.
 */

public class MouthActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void initLayout() {
        super.initLayout();
        setContentView(R.layout.ac_mouth);
    }

    @Override
    protected void initViews() {
        tvTitle.setText("口语训练");
        recyclerView = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void initData() {

        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        TreeNode<MouthOneBean> mouthOneBeanTreeNode = new TreeNode<>(new MouthOneBean("leve 1"));

        mouthOneBeanTreeNode.addChild(
                new TreeNode<>(new MouthTwoBean("第一讲")).addChild(
                        new TreeNode<>(new MouthThreeBean("第一小时"))).addChild(
                        new TreeNode<>(new MouthThreeBean("第二小时"))));

        treeNodes.add(mouthOneBeanTreeNode);

        TreeNode<MouthOneBean> mouthOneBeanTreeNode1 = new TreeNode<>(new MouthOneBean("leve 2"));

        mouthOneBeanTreeNode1.addChild(
                new TreeNode<>(new MouthTwoBean("第一讲")).addChild(
                        new TreeNode<>(new MouthThreeBean("第一小时"))).addChild(
                        new TreeNode<>(new MouthThreeBean("第二小时"))));

        mouthOneBeanTreeNode1.addChild(
                new TreeNode<>(new MouthTwoBean("第二讲")).addChild(
                        new TreeNode<>(new MouthThreeBean("第一小时"))).addChild(
                        new TreeNode<>(new MouthThreeBean("第二小时"))));

        treeNodes.add(mouthOneBeanTreeNode1);


        TreeViewAdapter treeViewAdapter = new TreeViewAdapter(treeNodes, Arrays.asList(new MouthOneAdapter(), new MouthTwoAdapter(), new MouthThreeAdapter()));
        recyclerView.setAdapter(treeViewAdapter);

    }

    @Override
    public Resources getResources() {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 667);
    }
}
