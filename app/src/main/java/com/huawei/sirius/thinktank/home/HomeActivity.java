package com.huawei.sirius.thinktank.home;

import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.CalendarView;

import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.home.interfaces.HomeView;
import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;
import com.huawei.sirius.thinktank.login.LoginPresenterImp;
import com.huawei.sirius.thinktank.login.interfaces.LoginView;
import com.huawei.sirius.thinktank.model.UserAccount;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity implements HomeView {
    private static final String TAG = HomeActivity.class.getSimpleName();

    @BindView(R.id.home_calendar)
    CalendarView calendarView;

    @BindView(R.id.home_weekview)
    WeekView weekView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    @Override
    public void initPresenter() {
        this.presenter = new HomePresenterImp(this);
        initView();
    }

    private void initView() {
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                GregorianCalendar date = new GregorianCalendar(i, i1, i2);
                weekView.goToDate(date);
            }
        });
        weekView.setShowNowLine(true);
        weekView.setNumberOfVisibleDays(3);
        weekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                Log.d("HomeActivity", "onMonthChange: " +newYear + " " + newMonth);
                return ((HomePresenterImp)presenter).getEvents(new GregorianCalendar(newYear, newMonth, 1).getTime(), null);
            }
        });
    }


    @Override
    public void refreshEvents(final List<MeetingEvent> meetingEventList) {
        Log.d(TAG, "refreshEvents");
        //todo to reset events
        weekView.notifyDatasetChanged();
    }
}
