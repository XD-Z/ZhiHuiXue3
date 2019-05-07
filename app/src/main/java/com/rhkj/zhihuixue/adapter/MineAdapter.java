package com.rhkj.zhihuixue.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rhkj.zhihuixue.R;

public class MineAdapter extends RecyclerView.Adapter<MineAdapter.ViewHolder> {


    private int[] images;
    private String[] titles;
    private Context context;

    public MineAdapter(int[] images, String[] titles, Context context) {
        this.images = images;
        this.titles = titles;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_mine_re_img);
            item_text = itemView.findViewById(R.id.item_mine_re_title);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_re_mine, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.item_image.setImageResource(images[i]);
        viewHolder.item_text.setText(titles[i]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


}
