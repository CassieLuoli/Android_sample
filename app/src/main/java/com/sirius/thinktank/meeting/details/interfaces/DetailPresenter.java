package com.sirius.thinktank.meeting.details.interfaces;

import com.sirius.thinktank.data.model.MeetingEvent;
import com.sirius.thinktank.shared.ui.interfaces.BasePresenter;

/**
 * Created by Luoli on 7/21/16.
 */
public interface DetailPresenter extends BasePresenter {
    public void showDetail(MeetingEvent meetingEvent);

    void requestDetail(long meetingId);
}
