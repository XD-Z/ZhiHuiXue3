package com.rhkj.zhihuixue.adapter;

import android.app.backup.FileBackupHelper;
import android.view.View;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.bean.MouthOneBean;

import tellh.com.recyclertreeview_lib.LayoutItemType;
import tellh.com.recyclertreeview_lib.TreeNode;
import tellh.com.recyclertreeview_lib.TreeViewAdapter;
import tellh.com.recyclertreeview_lib.TreeViewBinder;

/**
 * Created by zjx on 2019/5/21.
 */

public class MouthOneAdapter extends TreeViewBinder<MouthOneAdapter.ViewHolder> {

    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(ViewHolder holder, int position, TreeNode node) {
        MouthOneBean content = (MouthOneBean) node.getContent();

        holder.tvLevel.setText(content.getOneName());

    }

    @Override
    public int getLayoutId() {
        return R.layout.item_mouth_one;
    }

    public class ViewHolder extends TreeViewBinder.ViewHolder {

        private final TextView tvLevel;

        public ViewHolder(View rootView) {
            super(rootView);
            tvLevel = findViewById(R.id.tv_level);


        }
    }


}
