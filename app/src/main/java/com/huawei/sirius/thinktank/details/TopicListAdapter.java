package com.huawei.sirius.thinktank.details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.model.MeetingTopic;

import java.util.List;

/**
 * Created by Luoli on 7/18/16.
 */
public class TopicListAdapter extends RecyclerView.Adapter<TopicItemHolder> {

    private final List<MeetingTopic> topicList;

    public TopicListAdapter(List<MeetingTopic> topicList) {
        this.topicList = topicList;
    }

    @Override
    public TopicItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.meeting_topic_item, parent, false);
        return new TopicItemHolder(v);
    }

    @Override
    public void onBindViewHolder(TopicItemHolder holder, int position) {
        holder.refreshCellView(topicList.get(position));

    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }
}
