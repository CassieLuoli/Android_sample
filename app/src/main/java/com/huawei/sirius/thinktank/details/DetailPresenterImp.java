package com.huawei.sirius.thinktank.details;

import android.telecom.Call;

import com.huawei.sirius.thinktank.details.interfaces.DetailPresenter;
import com.huawei.sirius.thinktank.details.interfaces.DetailView;
import com.huawei.sirius.thinktank.model.MeetingEvent;

/**
 * Created by Luoli on 7/21/16.
 */
public class DetailPresenterImp implements DetailPresenter {
    private DetailView detailView;

    public DetailPresenterImp(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void showDetail(MeetingEvent meetingEvent) {
        detailView.showDetails(meetingEvent);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
