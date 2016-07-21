package com.huawei.sirius.thinktank.details.interfaces;

import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.interfaces.LoadingView;

/**
 * Created by Luoli on 7/18/16.
 */
public interface DetailView extends LoadingView {
    public void showDetails(MeetingEvent meetingEvent);
}

