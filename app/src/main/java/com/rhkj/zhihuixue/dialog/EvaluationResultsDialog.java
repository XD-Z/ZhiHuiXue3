package com.rhkj.zhihuixue.dialog;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.rhkj.zhihuixue.R;
import com.rhkj.zhihuixue.activity.ComeonActivity;

/**
 * 评测结果
 * Created by zjx on 2019/5/11.
 */

public class EvaluationResultsDialog extends DialogFragment implements View.OnClickListener {

    private ImageView ivWwjy;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.NoticeDialogStyle);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//         <!--关键点1-->
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        super.onActivityCreated(savedInstanceState);
//    <!--关键点2-->
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(R.layout.dialog_evaluation_results, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ivWwjy = view.findViewById(R.id.iv_wwjy);


        iniListener();
    }

    private void iniListener() {
        ivWwjy.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_wwjy:

                startActivity(new Intent(getActivity(), ComeonActivity.class));
                break;
        }

    }
}
