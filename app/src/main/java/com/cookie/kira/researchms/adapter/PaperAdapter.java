package com.cookie.kira.researchms.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.entity.Paper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 11669 on 2017-06-29.
 */

public class PaperAdapter extends RecyclerView.Adapter<PaperAdapter.PaperViewHolder> {
    private List<Paper> papers = new LinkedList<>();
    private View.OnClickListener paperOnClickListener;

    public PaperAdapter(List<Paper> papers, View.OnClickListener paperOnClickListener) {
        this.papers = papers;
        this.paperOnClickListener = paperOnClickListener;
    }

    @Override
    public PaperAdapter.PaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_home, parent,
                false);
        PaperViewHolder holder = new PaperViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PaperAdapter.PaperViewHolder holder, int position) {
        //tv相关设置
        holder.tv.setText(papers.get(position).getName());
        holder.tv.setTag(papers.get(position));
        holder.tv.setOnClickListener(paperOnClickListener);
    }

    @Override
    public int getItemCount() {
        return papers.size();
    }


    public class PaperViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public PaperViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.paper_item_title);
        }
    }
}
