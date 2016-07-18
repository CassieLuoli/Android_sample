package com.huawei.sirius.thinktank.home;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.home.interfaces.HomePresenter;
import com.huawei.sirius.thinktank.home.interfaces.HomeView;
import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements HomeView {

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
        ((HomePresenter)presenter).requestEvents(new Date(), null);
    }

    @Override
    public void refreshEvents(List<MeetingEvent> meetingEventList) {
        hideLoading();
        ((HomeCalendar) fragment).refreshEvents(meetingEventList);
    }

    @Override
    public void initPresenter() {
        presenter = new HomePresenterImp(this);
    }

}
