package com.example.androidmvvm.mvvm.model;

import com.example.androidmvvm.base.IBaseModel;
import com.example.androidmvvm.bean.UserBean;
import com.example.androidmvvm.mvvm.viewmodel.IViewModel;

/**
 * 数据模型接口 负责数据逻辑
 */
public interface IModel extends IBaseModel {

    void setViewModel(IViewModel viewModel, UserBean userBean); // 持有 ViewModel

    /**
     * 这些都是方法，都是由 ViewModel 调用的
     */

    UserBean getUserBean(); // 提供对外 获取数据的接口

    void onDataChanged(String data); // 监听文本变化，时时更新数据，用于单向绑定

    void submitFromData(); // 提交表单数据

    void clearData(); // 清空数据

}
