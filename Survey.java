package com.example.nick_gallo.mobilesystemsurvey;

import java.util.ArrayList;

public class Survey {
    ArrayList<Question> questions;

    public Survey(){
        questions = new ArrayList<>();
    }

    public Survey(ArrayList<Question> copy){
        questions = new ArrayList<>(copy);
    }

    public void addQuestion(Question q){
        questions.add(q);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}

