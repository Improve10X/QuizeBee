package com.example.quizebee;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizebee.network.FakeApi;
import com.example.quizebee.network.FakeApiService;

public class BaseActivity extends AppCompatActivity {
    protected FakeApiService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createFakeApi();
    }

    private void createFakeApi() {
        service = new FakeApi().createFakeApiService();
    }
}
