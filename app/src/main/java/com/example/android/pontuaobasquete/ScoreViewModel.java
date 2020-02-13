package com.example.android.pontuaobasquete;

import android.arch.lifecycle.ViewModel;
import android.widget.Chronometer;

public class ScoreViewModel extends ViewModel {


    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    public ScoreViewModel(){

    }

    public void setScoreTeamA(int add) {
        scoreTeamA = scoreTeamA + add;
    }

    public void setScoreTeamB(int add) {
        scoreTeamB = scoreTeamB + add;
    }

    public int getScoreTeamA(){

        return scoreTeamA;
    }

    public int getScoreTeamB(){

        return scoreTeamB;
    }

    public int resetA(){
        scoreTeamA = 0;
        return (scoreTeamA);
    }

    public int resetB(){
        scoreTeamB = 0;
        return (scoreTeamB);
    }
}

