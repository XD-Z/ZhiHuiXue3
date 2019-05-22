package com.rhkj.zhihuixue.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.MouthThreeBean;
import com.rhkj.zhihuixue.bean.MouthTwoBean;

import tellh.com.recyclertreeview_lib.LayoutItemType;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

/**
 * Created by zjx on 2019/5/21.
 */

public class MouthThreeAdapter extends TreeViewBinder<MouthThreeAdapter.ViewHolder> {

    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(LayoutInflater.from(itemView.getContext()).inflate(R.layout.item_mouth_three,null,true));
    }

    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {
        MouthThreeBean mouthThreeBean = (MouthThreeBean) node.getContent();
        String oneName = mouthThreeBean.oneName;

        holder.tvClassHour.setText(oneName);

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mouth_three;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {

        private final TextView tvClassHour;

        public ViewHolder(View rootView) {
            super(rootView);
            tvClassHour = findViewById(R.id.tv_classhour);



        }
    }


}
