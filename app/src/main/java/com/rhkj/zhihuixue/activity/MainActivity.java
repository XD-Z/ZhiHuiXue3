package com.rhkj.zhihuixue.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.fragment.FuwuFragment;
import com.rhkj.zhihuixue.fragment.HomeFragment;
import com.rhkj.zhihuixue.fragment.MineFragment;
import com.rhkj.zhihuixue.fragment.ShopFragment;
import com.rhkj.zhihuixue.fragment.ZhiFragment;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Fragment[] mFragments;
    private RadioGroup mRadioGroup;
    private RelativeLayout zhi_rl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    protected void initViews() {
        mRadioGroup = findViewById(R.id.rg_tab);
        mRadioGroup.setOnCheckedChangeListener(this);
        zhi_rl = findViewById(R.id.zhi_rl);
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
        mRadioGroup.check(R.id.home_rb);

        zhi_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRadioGroup.clearCheck();

                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.content_frag, mFragments[2]);
                ImmersionBar.with(MainActivity.this)
                        .reset()
                        .statusBarColor(R.color.colorWhile)
                        .fitsSystemWindows(true)
                        .statusBarDarkFont(true)
                        .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                        .init();
                transaction.commit();

            }
        });

    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (checkedId) {
            case R.id.home_rb:
                transaction.replace(R.id.content_frag, mFragments[0]);
                ImmersionBar.with(this)
                        .reset().statusBarColor(R.color.colorWhile)
                        .statusBarDarkFont(true)
                        .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                        .init();
                break;
            case R.id.fuwu_rb:
                transaction.replace(R.id.content_frag, mFragments[1]);
                ImmersionBar.with(this)
                        .reset()
                        .statusBarColor(R.color.colorWhile)
                        .statusBarDarkFont(true)
                        .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                        .init();
                break;
            case R.id.shop_rb:
                transaction.replace(R.id.content_frag, mFragments[3]);
                ImmersionBar.with(this)
                        .reset()
                        .statusBarColor(R.color.colorWhile)
                        .fitsSystemWindows(true)
                        .statusBarDarkFont(true)
                        .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                        .init();
                break;
            case R.id.mine_rb:
                transaction.replace(R.id.content_frag, mFragments[4]);
                ImmersionBar.with(this).reset().hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR).init();
                break;
        }
        transaction.commit();
    }
}
