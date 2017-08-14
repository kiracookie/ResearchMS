package com.cookie.kira.researchms.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.adapter.PaperAdapter;
import com.cookie.kira.researchms.entity.Paper;

import java.util.ArrayList;
import java.util.List;

/**
 * 试卷列表
 */
public class MainActivity extends AppCompatActivity {
    private List<Paper> papers;
    private RecyclerView papaerListView;
    private PaperAdapter paperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        papers = new ArrayList<>();

        Paper paperTest = new Paper();
//        paperTest.setId(-1);
//        paperTest.setName("新建调查");
//        papers.add(paperTest);

        // TODO: 2017-07-11 获取paper列表

        paperTest = new Paper();
        paperTest.setId(1);
        paperTest.setName("2016测试");
        papers.add(paperTest);

        paperTest = new Paper();
        paperTest.setId(2);
        paperTest.setName("2017测试");
        papers.add(paperTest);


        paperAdapter = new PaperAdapter(papers,
//                itemTv点击事件
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "跳转至答案列表页 paperId" + ((Paper) view.getTag()).getId(), Toast.LENGTH_SHORT).show();
                        // TODO: 2017-07-11  取数 并跳转
                        Intent intent = new Intent(MainActivity.this, AnswerListActivity.class);
                        intent.putExtra("paper", (Paper) view.getTag());
                        MainActivity.this.startActivity(intent);


                    }
                }
        );
        papaerListView = (RecyclerView) findViewById(R.id.paperList);
        papaerListView.setLayoutManager(new LinearLayoutManager(this));
        papaerListView.setAdapter(paperAdapter);

    }
}
