package com.huawei.sirius.thinktank.home.interfaces;

import com.huawei.sirius.thinktank.model.MeetingEvent;
import com.huawei.sirius.thinktank.shared.interfaces.BasePresenter;

import java.util.Date;
import java.util.List;

public interface HomePresenter extends BasePresenter {
    public List<MeetingEvent> getEvents(Date fromDate, Date toDate);
    public void requestEvents(Date fromDate, Date toDate);
}
