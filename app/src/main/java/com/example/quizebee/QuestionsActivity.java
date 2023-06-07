package com.example.quizebee;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quizebee.databinding.ActivityQuestionsBinding;
import com.example.quizebee.model.Question;
import com.example.quizebee.model.Quiz;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsActivity extends BaseActivity implements OnItemActionListener{

    ActivityQuestionsBinding binding;

    private List<Quiz> quizzes = new ArrayList<>();
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupAdapter();
        connectAdapter();
        QuizServiceApi();
    }

    private void QuizServiceApi() {

        Call<List<Quiz>> call = service.getDataApi();
        call.enqueue(new Callback<List<Quiz>>() {
            @Override
            public void onResponse(Call<List<Quiz>> call, Response<List<Quiz>> response) {
                Toast.makeText(QuestionsActivity.this, "Success", Toast.LENGTH_SHORT).show();
                quizzes = response.body();
                adapter.setData(quizzes.get(0).getQuestions());
                displayQuestion(1);
            }

            @Override
            public void onFailure(Call<List<Quiz>> call, Throwable t) {
                Toast.makeText(QuestionsActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.questionRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.questionRv.setAdapter(adapter);
    }

    private void setupAdapter() {

        adapter = new QuestionAdapter(new ArrayList<>());
        adapter.OnItemActionListener(this);
    }
    public  void  displayQuestion(int questionNo){
        Question question = quizzes.get(0).getQuestions().get(questionNo -1);
        binding.questionTxt.setText(question.getQuestion());
        binding.option1Rb.setText(question.getAnswers().get(0));
        binding.option2Rb.setText(question.getAnswers().get(1));
        binding.option3Rb.setText(question.getAnswers().get(2));
        binding.option4Rb.setText(question.getAnswers().get(3));

    }

    @Override
    public void OnItemClicked(int questionNo) {

        displayQuestion(questionNo);
    }
}