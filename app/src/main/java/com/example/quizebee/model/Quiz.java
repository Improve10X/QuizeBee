package com.example.quizebee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quiz {
    @SerializedName("_id")
    private String id;
    private Module module;
    private List<Question> questions;
}
