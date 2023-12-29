package com.example.androidmvvm.mvvm.model;


import android.os.Handler;

import com.example.androidmvvm.bean.UserBean;
import com.example.androidmvvm.mvvm.viewmodel.IViewModel;

/**
 * 数据模型逻辑 具体实现
 */
public class IModelImp implements IModel {

    private IViewModel viewModel;
    private UserBean user;
    private Handler handler = new Handler();

    @Override
    public void setViewModel(IViewModel viewModel, UserBean userBean) {
        this.viewModel = viewModel;
        this.user = userBean;
    }

    @Override
    public UserBean getUserBean() {
        return user;
    }

    @Override
    public void removeHandlerMsgAndCallback() {
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onDataChanged(String data) {
        // user.name.setValue(data); // 如果使用 单向绑定，要先更新对象值
    }

    @Override
    public void submitFromData() {
        viewModel.showSubmitFromLoading();
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewModel.hideSubmitFromLoading();
            }
        }, 1500);
    }

    @Override
    public void clearData() {
        user.name.setValue(null);
    }

}
