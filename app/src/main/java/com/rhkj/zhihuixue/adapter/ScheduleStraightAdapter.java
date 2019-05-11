package com.rhkj.zhihuixue.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.ScheduleStraightBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zjx on 2019/5/8.
 */

public class ScheduleStraightAdapter extends BaseQuickAdapter<ScheduleStraightBean, BaseViewHolder> {

    //每行的数量
    private int spanCount = 5;


    public ScheduleStraightAdapter() {
        super(R.layout.item_schedule_straight);
    }


    @Override
    protected void convert(BaseViewHolder helper, ScheduleStraightBean item) {
        View lineUp = helper.getView(R.id.line_up);
        View lineLeft = helper.getView(R.id.line_left);
        View lineRight = helper.getView(R.id.line_right);
        View lineLower = helper.getView(R.id.line_lower);
        TextView tvTime = helper.getView(R.id.tv_time);
        ImageView imageView = helper.getView(R.id.iv_center);


        int layoutPosition = helper.getLayoutPosition();


        initLine(lineUp, lineLeft, lineRight, lineLower, layoutPosition, tvTime);


        int isAdopt = item.getIsAdopt();


        if (isAdopt == ScheduleStraightBean.ADOPT) {
            imageView.setImageResource(R.mipmap.icon_anniu);
        } else {
            imageView.setImageResource(R.mipmap.icon_anniu_hui);
        }


        if (isAdopt == ScheduleStraightBean.NO_ADOPT) {
            lineLeft.setBackgroundColor(Color.parseColor("#a0a0a0"));
        }

        //判断还有下一个吗 有就获取下一个的值看看下一个通关了吗
        if (layoutPosition + 2 <= getData().size()) {
            if (getData().get(layoutPosition + 1).getIsAdopt() == ScheduleStraightBean.NO_ADOPT) {
                lineRight.setBackgroundColor(Color.parseColor("#a0a0a0"));
            }
        }


    }

    //重新排序数据
//    public void setDateList(List<ScheduleStraightBean> dateList) {
//        ArrayList<ScheduleStraightBean> scheduleStraightBeans = new ArrayList<>();
//
//        //全部几行
//        int total = getLine(scheduleStraightBeans.size());
//        //总共有多少个
//        int totalNum = total * spanCount;
//
//        for (int i = 0; i < totalNum; i++) {
//            ScheduleStraightBean scheduleStraightBean = new ScheduleStraightBean();
//            scheduleStraightBean.setDateState(ScheduleStraightBean.DATA_NO);
//            scheduleStraightBeans.add(scheduleStraightBean);
//        }
//
//        for (int i = 0; i < dateList.size(); i++) {
//            ScheduleStraightBean scheduleStraightBean = dateList.get(i);
//
//            int line = getLine(i + 1);
//
//            if (line % 2 == 1) {
//                scheduleStraightBeans.set(i, scheduleStraightBean);
//            } else {
//                int i1 = (spanCount * line) - 1;
//
//
//            }
//        }
//
//
//    }


    /**
     * 获取当前是第几行
     *
     * @param layoutPosition
     * @return
     */
    private int getLine(int layoutPosition) {
        int num = 0;
        do {
            layoutPosition = layoutPosition - spanCount;
            num++;
        }
        while (layoutPosition > 0);
        return num;
    }


    public void initLine(View lineUp, View lineLeft, View lineRight, View lineLower, int layoutPosition, TextView textView) {
        if (layoutPosition == 0) {
            lineUp.setVisibility(View.INVISIBLE);
            lineLeft.setVisibility(View.INVISIBLE);
            lineLower.setVisibility(View.INVISIBLE);
            if (layoutPosition + 1 == getData().size()) {
                lineRight.setVisibility(View.INVISIBLE);
            } else {
                lineRight.setVisibility(View.VISIBLE);
            }
            return;
        }


        int line = getLine(layoutPosition + 1);

        //获取当前布局是本行的第几个
        int lineNum = (spanCount * line) - (layoutPosition + 1);


        if (line % 2 == 1) {
            if (lineNum == 0) {
                //如果等于0 说明它是本行的最后一个
                lineRight.setVisibility(View.INVISIBLE);
                lineLeft.setVisibility(View.VISIBLE);
                lineUp.setVisibility(View.INVISIBLE);
                //判断下一排的最后一个有没有东西 true就显示竖线  flesh就不显示
                if ((layoutPosition + 1) + spanCount <= getData().size()) {
                    lineLower.setVisibility(View.VISIBLE);
                } else {
                    lineLower.setVisibility(View.INVISIBLE);
                }


                textView.setVisibility(View.GONE);

            } else if (lineNum == spanCount - 1) {
                //如果等于每行的总数减1 说明它是本行的第一个
                lineLower.setVisibility(View.INVISIBLE);
                lineLeft.setVisibility(View.INVISIBLE);
                lineUp.setVisibility(View.VISIBLE);
                //判断当前的是不是最后一个
                if (layoutPosition + 1 == getData().size()) {
                    lineRight.setVisibility(View.INVISIBLE);
                } else {
                    lineRight.setVisibility(View.VISIBLE);
                }
            } else {
                //中间的
                lineLower.setVisibility(View.INVISIBLE);
                lineLeft.setVisibility(View.VISIBLE);
                lineUp.setVisibility(View.INVISIBLE);
                //判断当前的是不是最后一个
                if (layoutPosition + 1 == getData().size()) {
                    lineRight.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.GONE);
                } else {
                    lineRight.setVisibility(View.VISIBLE);
                }
            }

        } else {
            if (lineNum == 0) {
                //如果等于0 说明它是本行的最后一个
                lineLower.setVisibility(View.INVISIBLE);
                lineRight.setVisibility(View.INVISIBLE);
                lineLeft.setVisibility(View.VISIBLE);
                lineUp.setVisibility(View.VISIBLE);

                textView.setVisibility(View.GONE);
            } else if (lineNum == spanCount - 1) {
                //如果等于每行的总数减1 说明它是本行的第一个
                lineLeft.setVisibility(View.INVISIBLE);
                lineUp.setVisibility(View.INVISIBLE);
                if (layoutPosition + 1 == getData().size()) {
                    lineLower.setVisibility(View.INVISIBLE);
                    lineRight.setVisibility(View.INVISIBLE);
                } else {
                    if ((layoutPosition + 1) + spanCount <= getData().size()) {
                        lineLower.setVisibility(View.VISIBLE);
                    } else {
                        lineLower.setVisibility(View.INVISIBLE);
                    }
                    lineRight.setVisibility(View.VISIBLE);
                }
            } else {
                //中间的
                lineLower.setVisibility(View.INVISIBLE);
                lineLeft.setVisibility(View.VISIBLE);
                lineUp.setVisibility(View.INVISIBLE);
                if (layoutPosition + 1 == getData().size()) {
                    lineRight.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.GONE);
                } else {
                    lineRight.setVisibility(View.VISIBLE);
                }
            }
        }

    }

}
