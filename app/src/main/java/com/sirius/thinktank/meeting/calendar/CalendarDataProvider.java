package com.hw.sirius.thinktank.meeting.calendar;

import com.hw.sirius.thinktank.data.localstorage.MeetingLocalStorageImp;
import com.hw.sirius.thinktank.data.remotestorage.meetting.MeetingApi;
import com.hw.sirius.thinktank.data.remotestorage.meetting.MeetingCloudSorage;

public class CalendarDataProvider implements MeetingApi {
    @Override
    public void getMeetingList(String userid) {
        new MeetingLocalStorageImp().get(userid);
    }

    @Override
    public void getMeetingDetail(String meetingId) {

    }
}
