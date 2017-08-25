package com.cookie.kira.researchms.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题详情
 */
public class QuestionActivity extends AppCompatActivity {


    List<Question> questionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


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

                    questionList = getQuestionsByPaperId(answer.getPaperId());
                    Question questionCurrent = questionList.get(0);
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


                } else {
                    Toast.makeText(QuestionActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    // TODO: 2017-08-25 获取题目列表
    private List<Question> getQuestionsByPaperId(int paperId) {

        Question q1 = new Question();
        q1.setComment("测试题目说明");
        q1.setText("测试题目001");
        q1.setType(1);
        q1.setOptions(new ArrayList<Option>());
        Option o1 = new Option();
        o1.setText("选项1");
        o1.setValue(1);
        q1.getOptions().add(o1);

        o1 = new Option();
        o1.setText("选项2");
        o1.setValue(3);
        q1.getOptions().add(o1);


        List<Question> ql = new ArrayList<>();
        ql.add(q1);
        return ql;
    }

}
