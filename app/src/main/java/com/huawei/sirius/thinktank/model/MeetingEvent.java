package com.huawei.sirius.thinktank.model;

import com.alamkanak.weekview.WeekViewEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MeetingEvent extends WeekViewEvent {
    List<MeetingTopic> topicList;
    public MeetingEvent() {
    }

    public List<MeetingTopic> getTopicList() {
        topicList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            topicList.add(new MeetingTopic());
        }
        return topicList;
    }

    public void setTopicList(List<MeetingTopic> topicList) {
        this.topicList = topicList;
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
