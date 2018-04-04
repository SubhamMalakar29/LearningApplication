package com.example.asus.project12;

import java.util.Random;

/**
 * Created by Asus on 03-04-2018.
 */

public class numberQuestionSet_1 {

    Random rand;

    public String mQuestion [] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private String cAnswer;



    public String getmQuestion(int x) {
        return mQuestion[x];
    }

    public String getOption1(int x){
        return mQuestion[x];
    }
    public String getOption2(int x){
        return mQuestion[0];
    }
    public String getOption3(int x){
        return mQuestion[2];
    }
    public String getOption4(int x){
        return mQuestion[4];
    }

    public String getcAnswer(int x) {
        return mQuestion[x];
    }
}
