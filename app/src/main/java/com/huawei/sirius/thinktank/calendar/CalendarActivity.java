package com.huawei.sirius.thinktank.calendar;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.details.DetailActivity;
import com.huawei.sirius.thinktank.calendar.interfaces.CalendarPresenter;
import com.huawei.sirius.thinktank.calendar.interfaces.CalendarView;
import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class CalendarActivity extends BaseActivity implements CalendarView {

    public static final String TAG = CalendarActivity.class.getName();


    @BindView(R.id.home_calendar)
    android.widget.CalendarView calendarView;

    @BindView(R.id.home_weekview)
    WeekView weekView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meeting_calendar);
        initView();
    }


    private void initView() {
        calendarView.setOnDateChangeListener(new android.widget.CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(android.widget.CalendarView calendarView, int i, int i1, int i2) {
                GregorianCalendar date = new GregorianCalendar(i, i1, i2);
                weekView.goToDate(date);
            }
        });
        weekView.setShowNowLine(true);
        weekView.setNumberOfVisibleDays(3);
        weekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                return new ArrayList<>();
            }
        });
        weekView.setOnEventClickListener(new WeekView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                ((CalendarPresenter) presenter).select((MeetingEvent)event);
            }
        });
    }


    public void refreshEvents(final List<MeetingEvent> meetingEventList) {
        Log.d(TAG, "refreshEvents");
        weekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, final int newMonth) {
                final ArrayList<MeetingEvent> events = new ArrayList<>();
                Observable.from(meetingEventList)
                        .filter(new Func1<MeetingEvent, Boolean>() {
                            @Override
                            public Boolean call(MeetingEvent meetingEvent) {
                                return meetingEvent.getStartTime().getTime().getMonth() == newMonth;
                            }
                        })
                        .toList()
                        .subscribe(new Action1<List<MeetingEvent>>() {
                            @Override
                            public void call(List<MeetingEvent> meetingEvents) {
                                events.addAll(meetingEvents);
                            }
                        });
                return events;
            }
        });
        weekView.notifyDatasetChanged();
    }

    @Override
    public void showMeetingDetail(MeetingEvent meetingEvent) {
        hideLoading();
        Log.d(TAG, "showMeetingDetail");

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.MEETING_ID, meetingEvent.getId());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ((CalendarPresenter)presenter).back();
    }

    @Override
    public void initPresenter() {
        presenter = new CalendarPresenterImp(this);
    }

}
