package com.huawei.sirius.thinktank.meeting.details.interfaces;

import com.huawei.sirius.thinktank.data.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.ui.interfaces.BasePresenter;

/**
 * Created by Luoli on 7/21/16.
 */
public interface DetailPresenter extends BasePresenter {
    public void showDetail(MeetingEvent meetingEvent);

    void requestDetail(long meetingId);
}
