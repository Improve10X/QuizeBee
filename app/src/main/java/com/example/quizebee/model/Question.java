package com.example.quizebee.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {
    private Integer number;
    private String question;
    private List<String> answers;

    @SerializedName("correct_answer")
    private Integer correctAnswer;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public Integer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
