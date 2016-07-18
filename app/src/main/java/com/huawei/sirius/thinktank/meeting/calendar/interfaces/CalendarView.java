package com.huawei.sirius.thinktank.meeting.calendar.interfaces;

import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.interfaces.LoadingView;

import java.util.List;

public interface CalendarView extends LoadingView {
    public void refreshEvents(List<MeetingEvent> meetingEventList);
}
