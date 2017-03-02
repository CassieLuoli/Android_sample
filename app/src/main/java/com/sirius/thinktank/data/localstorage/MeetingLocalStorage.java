package com.sirius.thinktank.data.localstorage;

import com.sirius.thinktank.data.model.MeetingEvent;

import java.util.List;

/**
 * Created by Luoli on 7/27/16.
 */
public interface MeetingLocalStorage {
    public void save(List<MeetingEvent> meetingEventList);
    public List<MeetingEvent> get(String userName);
}
