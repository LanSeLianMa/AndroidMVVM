package com.example.androidmvvm.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.androidmvvm.R;
import com.example.androidmvvm.bean.UserBean;
import com.example.androidmvvm.databinding.ActivityMvvmBinding;
import com.example.androidmvvm.mvvm.model.IModel;
import com.example.androidmvvm.mvvm.model.IModelImp;
import com.example.androidmvvm.mvvm.view.IView;
import com.example.androidmvvm.mvvm.viewmodel.IViewModel;
import com.example.androidmvvm.mvvm.viewmodel.IViewModelImp;

public class MVVMActivity extends AppCompatActivity implements IView {

    private ActivityMvvmBinding binding;

    private AlertDialog dialog;
    private IViewModel viewModel;
    private IModel model;
    private UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMvvmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        userBean = new UserBean();
        viewModel = new IViewModelImp();
        model = new IModelImp();

        // 注意一下，写的顺序

        viewModel.setView(this); // 持有 View
        model.setViewModel(viewModel, userBean); // 持有 ViewModel
        viewModel.setModel(model); // 持有 Model

        binding.setViewModel(viewModel); // 和xml绑定
        binding.setLifecycleOwner(this); // 监听，用于刷新数据的关键

        init();
    }

    private void init() {
        binding.edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.onDataChanged(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.removeHandlerMsgAndCallback();
    }

    @Override
    public void showSubmitFromLoading() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView textView = new TextView(this);
        String data = userBean.name.getValue();
        if (TextUtils.isEmpty(userBean.name.getValue())) {
            data = "normal";
        }
        textView.setText("正在提交：" + data);
        builder.setCancelable(false);
        builder.setView(textView);
        dialog = builder.show();
    }

    @Override
    public void hideSubmitFromLoading() {
        dialog.dismiss();
    }

    @BindingAdapter("isNull")
    public static void isNull(TextView view,String name) {
        if (TextUtils.isEmpty(name)) {
            view.setText("normal");
            return;
        }
        view.setText(name);
    }

}