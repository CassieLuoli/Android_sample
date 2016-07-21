package com.huawei.sirius.thinktank.details.interfaces;

import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.interfaces.BasePresenter;

/**
 * Created by Luoli on 7/21/16.
 */
public interface DetailPresenter extends BasePresenter {
    public void showDetail(MeetingEvent meetingEvent);

    void requestDetail(long meetingId);
}
