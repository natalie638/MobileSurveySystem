package com.example.yewang.mobilesurveysystem;

import android.content.Intent;
import android.util.Log;

public class WizardItem {
    public static final String ITEM_SEP = System.getProperty("line.separator");
    public final static String QUESTION = "question";
    public final static String RATING = "";
    public  final static String DELETE = "deleteButton";
    private static final String TAG = "Group-project";
//    public final static int objIndex = 0;

    private String rating;
    private String question;


    WizardItem(String question, String rating) {
        this.question = question;
        this.rating = rating;
    }
    // Create a new ToDoItem from data packaged in an Intent
//    not sure what to do here
    WizardItem(Intent intent){
        question = intent.getStringExtra(WizardItem.QUESTION);
        rating = intent.getStringExtra(WizardItem.RATING);
    }

    public static void packageIntent(Intent intent, String question){
        Log.i(TAG, "Puting extra : "+ question);
        intent.putExtra(WizardItem.QUESTION,question);
    }

    public String getQuestion(){
        return this.question;
    }
    public String getRating(){
        return  this.rating;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Question: "+ ITEM_SEP +getQuestion()+" Rating :"+ getRating();
    }

}
