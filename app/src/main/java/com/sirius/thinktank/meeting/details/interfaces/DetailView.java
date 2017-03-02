package com.sirius.thinktank.meeting.details.interfaces;

import com.sirius.thinktank.data.model.MeetingEvent;
import com.sirius.thinktank.shared.ui.interfaces.LoadingView;

/**
 * Created by Luoli on 7/18/16.
 */
public interface DetailView extends LoadingView {
    public void showDetails(MeetingEvent meetingEvent);
}

