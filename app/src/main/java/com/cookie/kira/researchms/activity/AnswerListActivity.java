package com.cookie.kira.researchms.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.adapter.AnswerAdapter;
import com.cookie.kira.researchms.adapter.PaperAdapter;
import com.cookie.kira.researchms.entity.Answer;
import com.cookie.kira.researchms.entity.Paper;

import java.util.ArrayList;
import java.util.List;

/**
 * 答案列表
 */
public class AnswerListActivity extends AppCompatActivity {
    private List<Answer> answers;
    private RecyclerView answerListView;
    private AnswerAdapter answerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //获取paper对象
        Intent data = getIntent();
        Paper paper = (Paper) data.getSerializableExtra("paper");

        Toast.makeText(AnswerListActivity.this, paper.getName(), Toast.LENGTH_SHORT).show();

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        answers = new ArrayList<>();

        Answer answerTest = new Answer();
        answerTest.setOwner("新建检查");
        answerTest.setPaperId(paper.getId());
        answers.add(answerTest);

        // TODO: 2017-07-11 获取已检查清单

        answerTest = new Answer();
        answerTest.setOwner("TD-001");
        answerTest.setPaperId(paper.getId());
        answers.add(answerTest);

        answerTest = new Answer();
        answerTest.setOwner("TD-002");
        answerTest.setPaperId(paper.getId());
        answers.add(answerTest);


        answerAdapter = new AnswerAdapter(answers,
//                itemTv点击事件
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (view.getTag().equals(answers.get(0))) {
                            Toast.makeText(AnswerListActivity.this, "跳转至新建检查", Toast.LENGTH_SHORT).show();
                            // TODO: 2017-07-11 跳转至新建页

                            Intent intent = new Intent(AnswerListActivity.this, QuestionActivity.class);
                            intent.putExtra("answer", (Answer) view.getTag());
                            AnswerListActivity.this.startActivity(intent);

                        } else {
                            Toast.makeText(AnswerListActivity.this, "跳转至结果页 paperId owner" + ((Answer) view.getTag()).getOwner(), Toast.LENGTH_SHORT).show();
                            // TODO: 2017-07-11  取数 并跳转

                        }
                    }
                }
        );
        answerListView = (RecyclerView) findViewById(R.id.paperList);
        answerListView.setLayoutManager(new LinearLayoutManager(this));
        answerListView.setAdapter(answerAdapter);

    }
}
