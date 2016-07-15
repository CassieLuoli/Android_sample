package com.huawei.sirius.thinktank.home.interfaces;

import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.interfaces.LoadingView;

import java.util.List;

public interface HomeView extends LoadingView {
    public void refreshEvents(List<MeetingEvent> meetingEventList);
}
