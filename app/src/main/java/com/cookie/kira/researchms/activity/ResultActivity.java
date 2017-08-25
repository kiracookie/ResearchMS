package com.cookie.kira.researchms.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.entity.Answer;

/**
 * Created by 11669 on 2017-08-25.
 */

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.result);


        //获取answer对象
        Intent data = getIntent();
        final Answer answer = (Answer) data.getSerializableExtra("answer");


        TextView ownerText = (TextView) findViewById(R.id.ownerScoreText);
        ownerText.setText(answer.getOwner());

        TextView scoreText = (TextView) findViewById(R.id.scoreText);
        scoreText.setText(99 + "");
    }

}
