package com.huawei.sirius.thinktank.home;

import android.support.annotation.NonNull;
import android.util.Log;

import com.alamkanak.weekview.WeekViewEvent;
import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.home.interfaces.HomePresenter;
import com.huawei.sirius.thinktank.home.interfaces.HomeView;
import com.huawei.sirius.thinktank.model.MeetingEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HomePresenterImp implements HomePresenter {

    private static final String TAG = HomePresenterImp.class.getSimpleName();
    public static final int YUNA_NIAN = 1900;
    private final HomeView homeView;


    public HomePresenterImp(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void requestEvents(Date fromDate, Date toDate) {
        //TODO retrieve from backend

        List<MeetingEvent> collection = prepareWeekViewEvents(fromDate.getYear() + YUNA_NIAN, fromDate.getMonth(), fromDate.getDate());

        Log.d(TAG, "requestEvents: " + collection.size());
        homeView.refreshEvents(collection);
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
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth);
        startTime.set(Calendar.YEAR, newYear);
        startTime.set(Calendar.DAY_OF_MONTH, date);
        Calendar end = (Calendar) startTime.clone();
        end.set(Calendar.HOUR_OF_DAY, 4);
        end.set(Calendar.MINUTE, 30);
        end.set(Calendar.MONTH, newMonth);
        MeetingEvent weekViewEvent = new MeetingEvent(21, "meeting", startTime, end);
        weekViewEvent.setColor(homeView.context().getResources().getColor(R.color.event_color_04));
        eventList.add(weekViewEvent);


        Log.d(TAG, "todayEvent: " + weekViewEvent.getStartTime());

        Log.d(TAG, "day: " + date + "month: " + newMonth);

        Random random = new Random();
        int hourSeed = 99;
        for (int i = 0; i < 30; i++) {

            int daySeed = Math.abs(new Random(i).nextInt(hourSeed + i));
            hourSeed = Math.abs(new Random(daySeed).nextInt(i + daySeed));

            int day = (daySeed % 29 + 30) % 29;
            int hour = (hourSeed % 24 + 24) % 24;

            Log.d(TAG, "day: " + day + "hour: " + hour);

            startTime = Calendar.getInstance();
            startTime.set(Calendar.DAY_OF_MONTH, i);
            startTime.set(Calendar.HOUR_OF_DAY, hour);
            startTime.set(Calendar.MINUTE, day);
            startTime.set(Calendar.MONTH, newMonth);
            startTime.set(Calendar.YEAR, newYear);
            Calendar endTime = (Calendar) startTime.clone();
            endTime.set(Calendar.HOUR_OF_DAY, hour + 3);
            MeetingEvent event = new MeetingEvent(i, "SESSION", startTime, endTime);
            event.setColor(homeView.context().getResources().getColor(R.color.event_color_01));
            eventList.add(event);
        }

        return eventList;
    }
}
