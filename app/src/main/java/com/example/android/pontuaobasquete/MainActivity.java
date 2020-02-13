package com.example.android.pontuaobasquete;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DigitalClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ScoreViewModel mViewModel;

    //Todos os tempos são em milisegundos.

    private Chronometer cronometro;

    private long pauseConfig = 0;

    private Button buttonStart;
    private Button buttonReset;


    private boolean timesRunning = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonStart = findViewById(R.id.button_Iniciar);
        buttonReset = findViewById(R.id.button_Reset);
        cronometro =  findViewById(R.id.Time);

        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addTresPontosA(View v) {
        mViewModel.setScoreTeamA(3);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    public void addDoisPontosA(View v) {
        mViewModel.setScoreTeamA(2);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    public void addUmPontosA(View v) {
        mViewModel.setScoreTeamA(1);
        displayForTeamA(mViewModel.getScoreTeamA());
    }
    /* Começa o código do time B*/

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addTresPontosB(View v) {
        mViewModel.setScoreTeamB(3);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    public void addDoisPontosB(View v) {
        mViewModel.setScoreTeamB(2);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    public void addUmPontosB(View v) {
        mViewModel.setScoreTeamB(1);
        displayForTeamB(mViewModel.getScoreTeamB());
    }
    public void resetar(View view){

        cronometro.setBase(SystemClock.elapsedRealtime());
        pauseConfig = 0;

        displayForTeamA(mViewModel.resetA());
        displayForTeamB(mViewModel.resetB());
    }

    public void start_pause(View view){
        if(!timesRunning){
            cronometro.setBase(SystemClock.elapsedRealtime()-pauseConfig);
            cronometro.start();
            timesRunning = true;
            buttonStart.setText("PAUSAR");
        }else{
            cronometro.stop();
            pauseConfig = SystemClock.elapsedRealtime() - cronometro.getBase();
            timesRunning = false;
            buttonStart.setText("INICIAR");
        }
    }





}
