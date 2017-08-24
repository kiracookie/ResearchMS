package com.cookie.kira.researchms.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.entity.Answer;

/**
 * 问题详情
 */
public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //获取answer对象
        Intent data = getIntent();
        final Answer answer = (Answer) data.getSerializableExtra("answer");


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请输入商户名称");
        final EditText et = new EditText(this);
        et.setHint("请输入商户名称");
        et.setSingleLine(true);
        builder.setView(et);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String owner = et.getText().toString();
                if (!owner.isEmpty()) {
                    answer.setOwner(owner);
                    Toast.makeText(QuestionActivity.this, answer.getOwner(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuestionActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
    }
}
