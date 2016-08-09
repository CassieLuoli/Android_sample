package com.hw.sirius.thinktank.meeting.calendar.interfaces;

import com.hw.sirius.thinktank.data.model.MeetingEvent;
import com.hw.sirius.thinktank.shared.ui.interfaces.BasePresenter;

import java.util.Date;
import java.util.List;

public interface CalendarPresenter extends BasePresenter {
    public void back();
    public List<MeetingEvent> getEvents(Date fromDate, Date toDate);
    public void requestEvents(Date fromDate, Date toDate);

    public void select(MeetingEvent event);
}
