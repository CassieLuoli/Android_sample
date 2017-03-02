package com.sirius.thinktank.meeting.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.sirius.thinktank.R;
import com.sirius.thinktank.meeting.details.interfaces.DetailPresenter;
import com.sirius.thinktank.meeting.details.interfaces.DetailView;
import com.sirius.thinktank.data.model.MeetingEvent;
import com.sirius.thinktank.meeting.details.views.TopicListAdapter;
import com.sirius.thinktank.shared.ui.BaseActivity;

import butterknife.BindView;

/**
 * Created by Luoli on 7/18/16.
 */
public class DetailActivity extends BaseActivity implements DetailView {
    public static String MEETING_ID = "MeetingEventId";
    public static final String TAG = DetailActivity.class.getName();

    @BindView(R.id.detail_topic_list)
    ListView topicList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meeting_detail);
        long meetingId = getIntent().getLongExtra(MEETING_ID, 0);
        ((DetailPresenter) presenter).requestDetail(meetingId);
    }

    @Override
    public void initPresenter() {
        this.presenter = new DetailPresenterImp(this);
    }

    @Override
    public void showDetails(MeetingEvent meetingEvent) {

        View header = LayoutInflater.from(this).inflate(R.layout.meeting_detail_header, null);
        topicList.addHeaderView(header);
        topicList.setAdapter(new TopicListAdapter(meetingEvent.getTopicList(), this));

    }
}
