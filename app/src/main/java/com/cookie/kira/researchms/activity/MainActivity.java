package com.cookie.kira.researchms.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.entity.Paper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Paper> papers;
    private RecyclerView papaerListView;
    private List<String> p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        papers = new ArrayList<>();
        Paper paperTest = new Paper();
        paperTest.setName("2016测试");
        papers.add(paperTest);

        paperTest.setName("2017测试");
        papers.add(paperTest);


        papaerListView = (RecyclerView) findViewById(R.id.paperList);
//        papaerListView.setAdapter();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
