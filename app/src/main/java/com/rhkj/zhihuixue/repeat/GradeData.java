package com.rhkj.zhihuixue.repeat;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.rhkj.zhihuixue.activity.login_register.RegisterActivity;
import com.rhkj.zhihuixue.base.Contents;
import com.rhkj.zhihuixue.bean.RegisterGradeGsonBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * 一些重复使用的接口
 * <p>
 * Created by zjx on 2019/5/17.
 */

public class GradeData {

    private Context context;
    private GradeInterface gradeInterface;
    private Toast toast;
    private OptionsPickerView pvOptions;

    public GradeData(Context context) {
        this.context = context;
    }

    public void setRepoeatInterface(GradeInterface gradeInterface) {
        this.gradeInterface = gradeInterface;
        gradeData();
    }

    private void gradeData() {
        OkHttpUtils
                .post()
                .url(Contents.GRADE)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        RegisterGradeGsonBean registerGradeGsonBean = gson.fromJson(response, RegisterGradeGsonBean.class);
                        int state = registerGradeGsonBean.getState();
                        String msg = registerGradeGsonBean.getMsg();
                        if (state == 200) {
                            List<RegisterGradeGsonBean.DataBean> data = registerGradeGsonBean.getData();
                            gradeData(data);
                        } else {
                            showToast(msg);
                        }
                    }
                });
    }

    private void gradeData(final List<RegisterGradeGsonBean.DataBean> list) {
        final ArrayList<String> strings = new ArrayList<>();
        for (RegisterGradeGsonBean.DataBean datum : list) {
            strings.add(datum.getName());
        }
        //条件选择器
        //返回的分别是三个级别的选中位置
        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                RegisterGradeGsonBean.DataBean dataBean = list.get(options1);
                gradeInterface.gradeData(dataBean);
            }
        }).build();
        pvOptions.setPicker(strings);
        pvOptions.show();
    }


    public void showToast(String msg) {
        if (toast == null)
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setDuration(Toast.LENGTH_SHORT); // 设置显示时间
        toast.setText(msg); // 设置显示内容
        toast.show();
    }

    public interface GradeInterface {
        void gradeData(RegisterGradeGsonBean.DataBean dataBean);
    }

}
