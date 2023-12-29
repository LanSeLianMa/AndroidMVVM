package com.example.androidmvvm.mvvm.view;


import com.example.androidmvvm.base.IBaseView;

/**
 * 视图接口 负责视图逻辑
 */
public interface IView extends IBaseView {

    /**
     * 这些都是方法，都是由 ViewModel 调用的
     */

    void showSubmitFromLoading(); // 显示提交表单loading

    void hideSubmitFromLoading(); // 隐藏提交表单loading

}
