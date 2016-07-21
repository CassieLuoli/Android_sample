package com.huawei.sirius.thinktank.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.details.interfaces.DetailPresenter;
import com.huawei.sirius.thinktank.details.interfaces.DetailView;
import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Luoli on 7/18/16.
 */
public class DetailActivity extends BaseActivity implements DetailView {
    public static String MEETING_ID = "MeetingEventId";
    public static final String TAG = DetailActivity.class.getName();

    @BindView(R.id.detail_topic_list)
    RecyclerView topicList;

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


        topicList.setLayoutManager(new LinearLayoutManager(this));
        topicList.setAdapter(new TopicListAdapter(meetingEvent.getTopicList()));

    }
}
