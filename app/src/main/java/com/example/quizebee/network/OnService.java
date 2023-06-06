package com.example.quizebee.network;

import com.example.quizebee.model.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OnService {
    @GET("renuTodo")
    Call<List<Quiz>> getDataApi();
}
