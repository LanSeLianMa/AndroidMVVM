package com.example.androidmvvm.mvvm.viewmodel;

import com.example.androidmvvm.base.IBaseViewModel;
import com.example.androidmvvm.mvvm.model.IModel;
import com.example.androidmvvm.mvvm.view.IView;

/**
 * 控制器接口 负责业务逻辑
 */
public interface IViewModel extends IBaseViewModel {

    void setView(IView view); // 持有 View

    void setModel(IModel model);  // 持有 Model

    IModel getModel(); // 获取 Model，由View通知 ViewModel

    void onDataChanged(String data); // 时时修改Model的数据，由View通知 ViewModel

    void submitFromData(); // 执行Model的 提交表单服务，由View通知 ViewModel

    void clearData(); // 执行Model的 清空数据方法，由View通知 ViewModel

    void showSubmitFromLoading(); // 执行View的显示loading方法，由Model通知 ViewModel

    void hideSubmitFromLoading(); // 执行View的隐藏loading方法，由Model通知 ViewModel

}
