package com.example.androidmvvm.bean;

import androidx.lifecycle.MutableLiveData;

public class UserBean {

    // 使用LiveData，将name添加为 被观察者
    public MutableLiveData<String> name = new MutableLiveData<String>(null);

}
