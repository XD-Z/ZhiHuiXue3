package com.rhkj.zhihuixue.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.base.BaseActivity;
import com.rhkj.zhihuixue.fragment.FuwuFragment;
import com.rhkj.zhihuixue.fragment.HomeFragment;
import com.rhkj.zhihuixue.fragment.MineFragment;
import com.rhkj.zhihuixue.fragment.ShopFragment;
import com.rhkj.zhihuixue.fragment.ZhiFragment;


public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment[] mFragments;
    private RadioGroup mRadioGroup;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        mRadioGroup = findViewById(R.id.rg_tab);
        mRadioGroup.setOnCheckedChangeListener(this);

        initFragment();
    }


    private void initFragment() {
        HomeFragment homeFragment = new HomeFragment();
        FuwuFragment fuwuFragment = new FuwuFragment();
        ZhiFragment zhiFragment = new ZhiFragment();
        ShopFragment shopFragment = new ShopFragment();
        MineFragment mineFragment = new MineFragment();
        mFragments = new Fragment[5];
        mFragments[0] = homeFragment;
        mFragments[1] = fuwuFragment;
        mFragments[2] = zhiFragment;
        mFragments[3] = shopFragment;
        mFragments[4] = mineFragment;


        //获取Fragment管理器
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frag, mFragments[0]);
        //提交事物
        transaction.commit();
        //默认点击首页
        mRadioGroup.check(R.id.main_rb);


    }


    @Override
    protected void initData() {
        super.initData();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.main_rb:
                transaction.replace(R.id.content_frag, mFragments[0]);

                break;
            case R.id.message_rb:
                transaction.replace(R.id.content_frag, mFragments[1]);

                break;
            case R.id.friend_rb:
                transaction.replace(R.id.content_frag, mFragments[3]);

                break;
            case R.id.info_rb:
                transaction.replace(R.id.content_frag, mFragments[4]);

                break;
        }
        transaction.commit();
    }
}
