package com.cookie.kira.researchms.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.entity.Answer;
import com.cookie.kira.researchms.entity.Option;
import com.cookie.kira.researchms.entity.Question;
import com.cookie.kira.researchms.util.PapersInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题详情
 */
public class QuestionActivity extends AppCompatActivity {


    List<Question> questionList = new ArrayList<>();
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final PapersInfo papersInfo = new PapersInfo();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

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

                    TextView ownerText = (TextView) findViewById(R.id.ownerText);
                    ownerText.setText(owner);

                    // TODO: 2017-08-25 获取题目列表
                    questionList = papersInfo.getPaperMap().get(answer.getPaperId()).getQuestions();
                    initQuestion();
                } else {
                    Toast.makeText(QuestionActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    private void initQuestion() {
        Question questionCurrent = questionList.get(currentIndex);
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        titleTextView.setText(questionCurrent.getText());

        TextView commentText = (TextView) findViewById(R.id.commentText);
        commentText.setText(questionCurrent.getComment());


        // 取得LinearLayout 控件
        LinearLayout optionContent = (LinearLayout) findViewById(R.id.optionOut);
        if (questionCurrent.getType() == 1) {

            RadioGroup radioGroup = new RadioGroup(QuestionActivity.this);
            RadioButton r = null;
            for (Option op : questionCurrent.getOptions()) {
                r = new RadioButton(QuestionActivity.this);
                r.setText(op.getText());
                r.setTag(op.getId());
                radioGroup.addView(r);
            }
            optionContent.addView(radioGroup);
        }
    }


}
