package com.example.quizebee;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizebee.databinding.ActivityQuestionsBinding;
import com.example.quizebee.databinding.QuestionItemBinding;

public class QuestionViewHolder extends RecyclerView.ViewHolder {
    QuestionItemBinding binding;
    public QuestionViewHolder(QuestionItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
