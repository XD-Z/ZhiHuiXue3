package com.rhkj.zhihuixue.repeat;

import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.rhkj.zhihuixue.activity.login_register.RegisterActivity;
import com.rhkj.zhihuixue.utils.AddressUtils;

import java.util.ArrayList;

/**
 * Created by zjx on 2019/5/17.
 */

public class CityData {

    private Context context;
    private ArrayList<String> itemOneList;
    private ArrayList<ArrayList<String>> itemTwoList;
    private ArrayList<ArrayList<ArrayList<String>>> itemthreeList;
    private OptionsPickerView pvOptions;

    public CityData(Context context) {
        this.context = context;
        initData();
    }

    CityInterface cityInterface;

    public void setCityInterface(CityInterface cityInterface) {
        this.cityInterface = cityInterface;
        initView();
    }

    private void initData() {

        AddressUtils addressUtils = new AddressUtils(context);
        itemOneList = addressUtils.getItemOneList();
        itemTwoList = addressUtils.getItemTwoList();
        itemthreeList = addressUtils.getItemthreeList();


    }

    public void initView() {

        //条件选择器
        //返回的分别是三个级别的选中位置
        pvOptions = new OptionsPickerBuilder(context, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                cityInterface.city(
                        itemOneList.get(options1),
                        itemTwoList.get(options1).get(option2),
                        itemthreeList.get(options1).get(option2).get(options3));
            }
        }).build();
        pvOptions.setPicker(itemOneList, itemTwoList, itemthreeList);
        pvOptions.show();
    }


    public interface CityInterface {

        void city(String province, String city, String area);
    }

}
