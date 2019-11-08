package com.feng.freader.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feng.freader.R;

import java.util.List;

/**
 * @author Feng Zhaohao
 * Created on 2019/11/7
 */
public class HotRankAdapter extends RecyclerView.Adapter<HotRankAdapter.HotRankViewHolder> {

    private Context mContext;
    private List<String> mHotRankNameList;
    private List<List<String>> mHotRankNovelList;

    public HotRankAdapter(Context mContext, List<String> mHotRankNameList,
                          List<List<String>> mHotRankNovelList) {
        this.mContext = mContext;
        this.mHotRankNameList = mHotRankNameList;
        this.mHotRankNovelList = mHotRankNovelList;
    }

    @NonNull
    @Override
    public HotRankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HotRankViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_hot_rank, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HotRankViewHolder hotRankViewHolder, int i) {
        hotRankViewHolder.hotRankName.setText(mHotRankNameList.get(i));
        List<String> novelList = mHotRankNovelList.get(i);
        String firstName = novelList.size() > 0 ? novelList.get(0) : "";
        String secondName = novelList.size() > 1 ? novelList.get(1) : "";
        String thirdName = novelList.size() > 2 ? novelList.get(2) : "";
        hotRankViewHolder.firstNovelName.setText(firstName);
        hotRankViewHolder.secondNovelName.setText(secondName);
        hotRankViewHolder.thirdNovelName.setText(thirdName);
    }

    @Override
    public int getItemCount() {
        return mHotRankNameList.size();
    }

    class HotRankViewHolder extends RecyclerView.ViewHolder {

        TextView hotRankName;
        TextView firstNovelName;
        TextView secondNovelName;
        TextView thirdNovelName;

        public HotRankViewHolder(@NonNull View itemView) {
            super(itemView);
            hotRankName = itemView.findViewById(R.id.tv_item_hot_rank_rank_name);
            firstNovelName = itemView.findViewById(R.id.tv_item_hot_rank_first_novel_name);
            secondNovelName = itemView.findViewById(R.id.tv_item_hot_rank_second_novel_name);
            thirdNovelName = itemView.findViewById(R.id.tv_item_hot_rank_third_novel_name);
        }
    }
}
