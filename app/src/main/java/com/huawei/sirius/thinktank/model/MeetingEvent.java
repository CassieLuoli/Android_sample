package com.huawei.sirius.thinktank.model;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;

public class MeetingEvent extends WeekViewEvent {
    public MeetingEvent() {
    }

    public MeetingEvent(long id, String name, int startYear, int startMonth, int startDay, int startHour, int startMinute, int endYear, int endMonth, int endDay, int endHour, int endMinute) {
        super(id, name, startYear, startMonth, startDay, startHour, startMinute, endYear, endMonth, endDay, endHour, endMinute);
    }

    public MeetingEvent(long id, String name, String location, Calendar startTime, Calendar endTime) {
        super(id, name, location, startTime, endTime);
    }

    public MeetingEvent(long id, String name, Calendar startTime, Calendar endTime) {
        super(id, name, startTime, endTime);
    }
}
