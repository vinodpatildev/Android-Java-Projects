package com.vinodpatildev.connectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int[] gameState = {2,2,2,2,2,2,2,2,2};
    private int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    private int activePlayer = 0;
    private boolean gameIsActive = true;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter] != 2 || !gameIsActive) return;

        gameState[tappedCounter] = activePlayer;

        counter.setTranslationY(-1500);

        if(activePlayer == 0){
            counter.setImageResource(R.drawable.red);
            activePlayer = 1;
        }else{
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 0;
        }
        counter.animate().translationYBy(1500).setDuration(700);

        for(int[] winningPosition : winningPositions){
            if(gameState[winningPosition[0]] != 2 && gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] ){
                gameIsActive = false;
                TextView tvResult = findViewById(R.id.tvResult);
                Button btnPlayAgain = findViewById(R.id.btnPlayAgain);
                if(gameState[winningPosition[0]] == 0){
                    tvResult.setText("Red has Won!");
                }else{
                    tvResult.setText("Yellow has Won!");
                }
                tvResult.setVisibility(View.VISIBLE);
                btnPlayAgain.setVisibility(View.VISIBLE);
            }
        }
    }

    public void resetGame(View view){
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        activePlayer = 0;
        gameIsActive = true;
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++){
            ImageView ivCounter = (ImageView) gridLayout.getChildAt(i);
            ivCounter.setImageDrawable(null);
        }
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.INVISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}