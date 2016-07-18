package com.huawei.sirius.thinktank.meeting;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.meeting.calendar.CalendarFragment;
import com.huawei.sirius.thinktank.meeting.calendar.CalendarPresenterImp;
import com.huawei.sirius.thinktank.meeting.calendar.interfaces.CalendarPresenter;
import com.huawei.sirius.thinktank.meeting.calendar.interfaces.CalendarView;
import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;

import java.util.Date;
import java.util.List;

public class MainActivity extends BaseActivity implements CalendarView {

    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        fragment = getFragmentManager().findFragmentById(R.id.home_fragment);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((CalendarPresenter)presenter).requestEvents(new Date(), null);
    }

    @Override
    public void refreshEvents(List<MeetingEvent> meetingEventList) {
        hideLoading();
        ((CalendarFragment) fragment).refreshEvents(meetingEventList);
    }

    @Override
    public void initPresenter() {
        presenter = new CalendarPresenterImp(this);
    }

}
