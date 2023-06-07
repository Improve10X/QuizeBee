package com.example.quizebee;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizebee.databinding.QuestionItemBinding;
import com.example.quizebee.model.Question;
import com.example.quizebee.model.Quiz;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionViewHolder> {
    private List<Question> questions;

    private OnItemActionListener listener;

    void OnItemActionListener(OnItemActionListener listener){
        this.listener = listener;
    }

    void setData(List<Question> questions){
        this.questions = questions;
        notifyDataSetChanged();
    }
    public  QuestionAdapter(List<Question> questions){
        this.questions = questions;
    }
    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuestionItemBinding binding = QuestionItemBinding.inflate(inflater,parent,false);
        QuestionViewHolder viewHolder = new QuestionViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.binding.questionNumberTxt.setText(String.valueOf(question.getNumber()));
        holder.binding.getRoot().setOnClickListener(v -> {
            listener.OnItemClicked(question.getNumber());
        });
    }

    @Override
    public int getItemCount() {

        return questions.size();
    }
}
