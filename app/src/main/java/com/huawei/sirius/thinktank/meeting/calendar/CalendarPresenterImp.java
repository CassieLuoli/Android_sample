package com.huawei.sirius.thinktank.meeting.calendar;

import android.support.annotation.NonNull;
import android.util.Log;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.meeting.MainActivity;
import com.huawei.sirius.thinktank.meeting.calendar.interfaces.CalendarPresenter;
import com.huawei.sirius.thinktank.meeting.calendar.interfaces.CalendarView;
import com.huawei.sirius.thinktank.model.MeetingEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class CalendarPresenterImp implements CalendarPresenter {

    private static final String TAG = CalendarPresenterImp.class.getSimpleName();
    public static final int YUNA_NIAN = 1900;
    private final CalendarView calendarView;
    private List<MeetingEvent> collection;


    public CalendarPresenterImp(CalendarView calendarView) {
        this.calendarView = calendarView;
    }

    @Override
    public void requestEvents(final Date fromDate, Date toDate) {
        //TODO retrieve from backend

        if (collection != null) {
            return;
        }

        calendarView.showLoading();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                collection = prepareWeekViewEvents(fromDate.getYear() + YUNA_NIAN, fromDate.getMonth(), fromDate.getDate());
                Log.d(TAG, "requestEvents: " + collection.size());
                ((MainActivity) calendarView).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        calendarView.refreshEvents(collection);
                    }
                });
            }
        }, 1000);

    }

    @Override
    public List<MeetingEvent> getEvents(Date fromDate, Date toDate) {
        return prepareWeekViewEvents(fromDate.getYear() + YUNA_NIAN, fromDate.getMonth(), fromDate.getDate());
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }


    @NonNull
    private List<MeetingEvent> prepareWeekViewEvents(int newYear, int newMonth, int date) {
        Log.d(TAG, "prepareWeekViewEvents");
        List<MeetingEvent> eventList = new ArrayList<>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 9);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth);
        startTime.set(Calendar.YEAR, newYear);
        startTime.set(Calendar.DAY_OF_MONTH, date);
        Calendar end = (Calendar) startTime.clone();
        end.set(Calendar.HOUR_OF_DAY, 12);
        end.set(Calendar.MINUTE, 30);
        end.set(Calendar.MONTH, newMonth);
        MeetingEvent weekViewEvent = new MeetingEvent(31, "meeting", startTime, end);
        weekViewEvent.setColor(calendarView.context().getResources().getColor(R.color.event_color_04));
        eventList.add(weekViewEvent);


        Log.d(TAG, "todayEvent: " + weekViewEvent.getStartTime());

        Log.d(TAG, "day: " + date + "month: " + newMonth);

        Random random = new Random();
        int hourSeed = 99;
        for (int i = 0; i < 30; i++) {

            int daySeed = Math.abs(new Random(i).nextInt(hourSeed + i));
            hourSeed = Math.abs(new Random(daySeed).nextInt(i + daySeed));

            int day = daySeed % 29;
            int hour = hourSeed % 8 + 8;

            Log.d(TAG, "day: " + day + "hour: " + hour);

            startTime = Calendar.getInstance();
            startTime.set(Calendar.DAY_OF_MONTH, i);
            startTime.set(Calendar.HOUR_OF_DAY, hour);
            startTime.set(Calendar.MINUTE, day);
            startTime.set(Calendar.MONTH, newMonth);
            startTime.set(Calendar.YEAR, newYear);
            Calendar endTime = (Calendar) startTime.clone();
            int length = Math.abs(new Random(i).nextInt(hourSeed + i)) % 6;
            endTime.set(Calendar.HOUR_OF_DAY, hour + length);
            MeetingEvent event = new MeetingEvent(i, "SESSION", startTime, endTime);
            int event_color_01 = day%2==0? R.color.event_color_01: R.color.event_color_03;
            event.setColor(calendarView.context().getResources().getColor(event_color_01));
            eventList.add(event);
        }

        return eventList;
    }
}
