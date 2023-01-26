package com.vinodpatildev.fadeanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean isInterstellarFaded = false;
    private ImageView ivInterstellar;
    private ImageView ivError;
    public void fade(View view){
        if(isInterstellarFaded){
            ivInterstellar.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(3000);
            ivError.animate().scaleX(0.5f).scaleY(0.5f).alpha(0).setDuration(3000);
        }else{
            ivInterstellar.animate().scaleX(0.5f).scaleY(0.5f).alpha(0).setDuration(3000);
            ivError.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(3000);
        }
        isInterstellarFaded = !isInterstellarFaded;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivInterstellar = (ImageView) findViewById(R.id.ivInterstellar);
        ivError = (ImageView) findViewById(R.id.ivError);
    }
}