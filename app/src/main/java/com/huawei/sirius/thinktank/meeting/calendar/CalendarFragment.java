package com.huawei.sirius.thinktank.meeting.calendar;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.meeting.MainActivity;
import com.huawei.sirius.thinktank.model.MeetingEvent;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Luoli on 7/15/16.
 */
public class CalendarFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();


    @BindView(R.id.home_calendar)
    CalendarView calendarView;

    @BindView(R.id.home_weekview)
    WeekView weekView;

    private CalendarPresenterImp presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_calendar, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
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
                return new ArrayList<WeekViewEvent>();
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

}
