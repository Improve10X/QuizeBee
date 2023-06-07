package com.example.quizebee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.quizebee.databinding.ActivityQuizeBeeBinding;

public class QuizeBeeActivity extends AppCompatActivity {
    ActivityQuizeBeeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizeBeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       handleStartBtn();
    }

    private void handleStartBtn() {
        binding.startBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, QuestionsActivity.class);
            startActivity(intent);
        });
    }
    }
