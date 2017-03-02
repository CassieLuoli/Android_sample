package com.sirius.thinktank.meeting.calendar;

import com.sirius.thinktank.data.AccountManager;
import com.sirius.thinktank.data.localstorage.MeetingLocalStorageImp;
import com.sirius.thinktank.meeting.calendar.interfaces.CalendarPresenter;
import com.sirius.thinktank.meeting.calendar.interfaces.CalendarView;
import com.sirius.thinktank.data.model.MeetingEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Observable;

public class CalendarPresenterImp implements CalendarPresenter {

    private static final String TAG = CalendarPresenterImp.class.getSimpleName();
    public static final int YUNA_NIAN = 1900;
    private final CalendarView calendarView;
    private List<MeetingEvent> collection;
    private CalendarDataProvider calendarDataProvider = new CalendarDataProvider();


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

        collection = new MeetingLocalStorageImp().get("123");
        getMeetingListCallBack();

    }

    private void getMeetingListCallBack() {
        calendarView.hideLoading();
        calendarView.refreshEvents(collection);
    }

    @Override
    public void select(MeetingEvent event) {
        calendarView.showMeetingDetail(event);
    }

    @Override
    public List<MeetingEvent> getEvents(Date fromDate, Date toDate) {
        return new ArrayList<>();
    }

    @Override
    public void resume() {
        requestEvents(new Date(), null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void back() {
    }
}
