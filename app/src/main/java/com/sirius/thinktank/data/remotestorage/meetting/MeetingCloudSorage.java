package com.hw.sirius.thinktank.data.remotestorage.meetting;

import com.hw.sirius.thinktank.data.model.MeetingEvent;

import java.util.List;

import rx.Observable;

/**
 * Created by Luoli on 7/27/16.
 */
public class MeetingCloudSorage {
    public Observable<List<MeetingEvent>> getMeetings(String token){
        return Observable.empty();
    }
}
