package com.sirius.thinktank.meeting.calendar;

import com.sirius.thinktank.data.localstorage.MeetingLocalStorageImp;
import com.sirius.thinktank.data.remotestorage.meetting.MeetingApi;
import com.sirius.thinktank.data.remotestorage.meetting.MeetingCloudSorage;

public class CalendarDataProvider implements MeetingApi {
    @Override
    public void getMeetingList(String userid) {
        new MeetingLocalStorageImp().get(userid);
    }

    @Override
    public void getMeetingDetail(String meetingId) {

    }
}
