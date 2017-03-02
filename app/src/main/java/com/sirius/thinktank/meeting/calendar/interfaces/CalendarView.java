package com.hw.sirius.thinktank.meeting.calendar.interfaces;

import com.hw.sirius.thinktank.data.model.MeetingEvent;
import com.hw.sirius.thinktank.shared.ui.interfaces.LoadingView;

import java.util.List;

public interface CalendarView extends LoadingView {
    public void refreshEvents(List<MeetingEvent> meetingEventList);
    public void showMeetingDetail(MeetingEvent meetingEvent);
}
