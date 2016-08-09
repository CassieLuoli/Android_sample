package com.hw.sirius.thinktank.meeting.details.interfaces;

import com.hw.sirius.thinktank.data.model.MeetingEvent;
import com.hw.sirius.thinktank.shared.ui.interfaces.LoadingView;

/**
 * Created by Luoli on 7/18/16.
 */
public interface DetailView extends LoadingView {
    public void showDetails(MeetingEvent meetingEvent);
}

