package com.example.androidmvvm.mvvm.viewmodel;

import com.example.androidmvvm.mvvm.model.IModel;
import com.example.androidmvvm.mvvm.view.IView;

/**
 * 业务逻辑 具体实现
 */
public class IViewModelImp implements IViewModel {

    private IView view;
    private IModel model;

    @Override
    public void setModel(IModel model) {
        this.model = model;
    }

    @Override
    public IModel getModel() {
        return model;
    }

    @Override
    public void setView(IView view) {
        this.view = view;
    }

    @Override
    public void removeHandlerMsgAndCallback() {
        model.removeHandlerMsgAndCallback();
    }

    @Override
    public void onDataChanged(String data) {
        model.onDataChanged(data);
    }

    @Override
    public void submitFromData() {
        model.submitFromData();
    }

    @Override
    public void clearData() {
        model.clearData();
    }

    @Override
    public void showSubmitFromLoading() {
        view.showSubmitFromLoading();
    }

    @Override
    public void hideSubmitFromLoading() {
        view.hideSubmitFromLoading();
    }

}
