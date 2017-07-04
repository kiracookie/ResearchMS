package com.cookie.kira.researchms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cookie.kira.researchms.R;
import com.cookie.kira.researchms.activity.MainActivity;
import com.cookie.kira.researchms.entity.Paper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 11669 on 2017-06-29.
 */

public class PaperAdapter extends RecyclerView.Adapter<PaperAdapter.PaperViewHolder> {
    private List<Paper> papers = new LinkedList<>();

    public PaperAdapter(List<Paper> papers) {
        this.papers = papers;

    }

    @Override
    public PaperAdapter.PaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        PaperViewHolder holder = new PaperViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(PaperAdapter.PaperViewHolder holder, int position) {
        holder.tv.setText(papers.get(position).getName());
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
