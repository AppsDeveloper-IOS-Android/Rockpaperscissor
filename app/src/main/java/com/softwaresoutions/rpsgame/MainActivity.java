package com.softwaresoutions.rpsgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_paper, b_scissor;
    ImageView iv_cpu, iv_me;
    String myChoice, cpuChoice, result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_rock = (Button) findViewById(R.id.b_rock);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scissor = (Button) findViewById(R.id.b_scissor);

        r = new Random();

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "rock";
                iv_me.setImageResource(R.drawable.rock);
                calcute();
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "paper";
                iv_me.setImageResource(R.drawable.paper);
                calcute();
            }
        });
        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "scissor";
                iv_me.setImageResource(R.drawable.scissors);
                calcute();
            }
        });
    }
    public void calcute() {

        int cpu = r.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "rock";
            iv_cpu.setImageResource(R.drawable.rock);
        }
        if (cpu == 1) {
            cpuChoice = "paper";
            iv_cpu.setImageResource(R.drawable.paper);
        }
        if (cpu == 2) {
            cpuChoice = "scissor";
            iv_cpu.setImageResource(R.drawable.scissors);

        }

        if (myChoice.equals("rock") && cpuChoice.equals("paper")) {
            result = "You Lose!";
        }
        if (myChoice.equals("rock") && cpuChoice.equals("scissor")) {
            result = "You Win!";
        }
        if (myChoice.equals("paper") && cpuChoice.equals("rock")) {
            result = "You Win!";
        }
        if (myChoice.equals("paper") && cpuChoice.equals("scissor")) {
            result = "You Lose!";
        }
        if (myChoice.equals("scissor") && cpuChoice.equals("paper")) {
            result = "You Win!";
        }
        if (myChoice.equals("scissor") && cpuChoice.equals("rock")) {
            result = "You Lose!";
        }
        if (myChoice.equals(cpuChoice)) {
            result = "Match Draw";
        }
        Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();

    }
}
