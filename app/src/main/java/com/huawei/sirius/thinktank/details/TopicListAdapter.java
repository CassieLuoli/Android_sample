package com.huawei.sirius.thinktank.details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.model.MeetingTopic;

import java.util.List;

/**
 * Created by Luoli on 7/18/16.
 */
public class TopicListAdapter extends BaseAdapter {

    private final List<MeetingTopic> topicList;
    private final Context context;

    public TopicListAdapter(List<MeetingTopic> topicList, Context context) {
        this.topicList = topicList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return topicList.size();
    }

    @Override
    public Object getItem(int i) {
        return topicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.meeting_topic_item, viewGroup, false);
        }
        TopicItemHolder holder = new TopicItemHolder(view);
        holder.refreshCellView(topicList.get(i));
        return view;
    }
}
