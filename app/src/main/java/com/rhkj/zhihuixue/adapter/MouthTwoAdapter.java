package com.rhkj.zhihuixue.adapter;

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

public class MouthTwoAdapter extends TreeViewBinder<MouthTwoAdapter.ViewHolder> {

    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {
        MouthTwoBean content = (MouthTwoBean) node.getContent();
        String oneName = content.oneName;

        holder.tvCurriculum.setText(oneName);

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mouth_two;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {

        private final TextView tvCurriculum;

        public ViewHolder(View rootView) {
            super(rootView);
            tvCurriculum = findViewById(R.id.tv_curriculum);


        }
    }


}
