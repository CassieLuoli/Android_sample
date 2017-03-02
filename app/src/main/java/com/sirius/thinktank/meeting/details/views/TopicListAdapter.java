package com.hw.sirius.thinktank.meeting.details.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hw.sirius.thinktank.R;
import com.hw.sirius.thinktank.data.model.MeetingTopic;

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
