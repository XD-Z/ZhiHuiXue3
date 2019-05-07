package com.rhkj.zhihuixue.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;


public class ListenNestScrollView extends NestedScrollView {

    private ScrollChangeListener listener;

    public ListenNestScrollView(Context context) {
        super(context);
    }

    public ListenNestScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListenNestScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setChangeListener(ScrollChangeListener scrollChangeListener) {
        this.listener = scrollChangeListener;
    }

    public interface ScrollChangeListener {
        void onChange(int l, int t, int oldl, int oldt);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null) {
            listener.onChange(l, t, oldl, oldt);
        }
    }
}
