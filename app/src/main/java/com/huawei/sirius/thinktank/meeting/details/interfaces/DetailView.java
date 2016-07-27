package com.huawei.sirius.thinktank.meeting.details.interfaces;

import com.huawei.sirius.thinktank.data.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.interfaces.LoadingView;

/**
 * Created by Luoli on 7/18/16.
 */
public interface DetailView extends LoadingView {
    public void showDetails(MeetingEvent meetingEvent);
}

