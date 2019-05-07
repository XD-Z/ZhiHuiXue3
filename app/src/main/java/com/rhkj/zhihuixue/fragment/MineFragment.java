package com.rhkj.zhihuixue.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.mine.AddressActivity;
import com.rhkj.zhihuixue.activity.mine.MessageActivity;
import com.rhkj.zhihuixue.activity.mine.MycourseActivity;
import com.rhkj.zhihuixue.activity.mine.MyorderActivity;
import com.rhkj.zhihuixue.activity.mine.QuestionActivity;
import com.rhkj.zhihuixue.activity.mine.RenewalsActivity;
import com.rhkj.zhihuixue.activity.mine.ScheduleActivity;
import com.rhkj.zhihuixue.activity.mine.SettingActivity;
import com.rhkj.zhihuixue.activity.mine.ShareActivity;
import com.rhkj.zhihuixue.activity.mine.WeakvideoActivity;
import com.rhkj.zhihuixue.adapter.MineItemAdapter;
import com.rhkj.zhihuixue.bean.MineBean;

import java.util.ArrayList;

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
    private ArrayList<MineBean> mineBeans;


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
        reMine.setAdapter(new MineItemAdapter(mineBeans));

        reMine.setHasFixedSize(true);
        reMine.setNestedScrollingEnabled(false);
        initOnClick();
    }

    private void initOnClick() {
        reMine.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), MycourseActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), MyorderActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), RenewalsActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), WeakvideoActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getActivity(), ScheduleActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(getActivity(), ShareActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(getActivity(), MessageActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(getActivity(), QuestionActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(getActivity(), AddressActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(getActivity(), SettingActivity.class));
                        break;
                }
            }
        });
    }

    private void initdata() {
        images = new int[]{R.mipmap.icon_mine_course, R.mipmap.icon_mine_order,
                R.mipmap.icon_mine_renewals, R.mipmap.icon_mine_weakvideo,
                R.mipmap.icon_mine_schedule, R.mipmap.icon_mine_share, R.mipmap.icon_mine_message,
                R.mipmap.icon_mine_question, R.mipmap.icon_mine_shipping_address, R.mipmap.icon_mine_setting};
        titles = new String[]{"我的课程", "我的订单", "我要续费", "薄弱节点视频", "动态学习计划表",
                "面对面分享", "消息通知", "常见问题", "我的收货地址", "设置"};
        mineBeans = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            mineBeans.add(new MineBean(images[i], titles[i]));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
