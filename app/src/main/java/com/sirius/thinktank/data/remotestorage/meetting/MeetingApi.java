package com.sirius.thinktank.data.remotestorage.meetting;

/**
 * Created by Luoli on 16/8/8.
 */
public interface MeetingApi {
    public void getMeetingList(String userid);
    public void getMeetingDetail(String meetingId);
}
