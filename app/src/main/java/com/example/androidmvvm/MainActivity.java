package com.example.androidmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidmvvm.databinding.ActivityMainBinding;
import com.example.androidmvvm.ui.activity.MVVMActivity;
import com.example.androidmvvm.ui.activity.NormalActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.normal.setOnClickListener(this);
        binding.mvvm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == binding.normal) {
            Intent intent = new Intent(this, NormalActivity.class);
            startActivity(intent);
        } else if (v == binding.mvvm) {
            Intent intent = new Intent(this, MVVMActivity.class);
            startActivity(intent);
        }
    }
}