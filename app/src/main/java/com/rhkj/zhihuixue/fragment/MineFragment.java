package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.adapter.MineAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    @BindView(R.id.img_mine_head)
    ImageView imgMineHead;
    @BindView(R.id.img_mine_beans)
    ImageView imgMineBeans;
    @BindView(R.id.re_mine)
    RecyclerView reMine;
    Unbinder unbinder;
    private int[] images;
    private String[] titles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);


        initdata();
        setFragmentLogic();

        return view;
    }


    private void setFragmentLogic() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        reMine.setLayoutManager(linearLayoutManager);
        reMine.setAdapter(new MineAdapter(images, titles, getActivity()));
        reMine.setHasFixedSize(true);
        reMine.setNestedScrollingEnabled(false);
    }

    private void initdata() {
//        ArrayList<Integer> images = new ArrayList<>();
//        images.add(R.mipmap.icon_mine_course);
        images = new int[]{R.mipmap.icon_mine_course, R.mipmap.icon_mine_order,
                R.mipmap.icon_mine_renewals, R.mipmap.icon_mine_weakvideo,
                R.mipmap.icon_mine_schedule, R.mipmap.icon_mine_share, R.mipmap.icon_mine_message,
                R.mipmap.icon_mine_question, R.mipmap.icon_mine_shipping_address, R.mipmap.icon_mine_setting};
        titles = new String[]{"我的课程", "我的订单", "我要续费", "薄弱节点视频", "动态学习计划表",
                "面对面分享", "消息通知", "常见问题", "我的收货地址", "设置"};


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
