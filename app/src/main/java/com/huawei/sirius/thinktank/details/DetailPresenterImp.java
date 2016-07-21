package com.huawei.sirius.thinktank.details;

import com.huawei.sirius.thinktank.details.interfaces.DetailPresenter;
import com.huawei.sirius.thinktank.details.interfaces.DetailView;
import com.huawei.sirius.thinktank.model.MeetingEvent;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Luoli on 7/21/16.
 */
public class DetailPresenterImp implements DetailPresenter {
    private DetailView detailView;
    private MeetingEvent meetingEvent;

    public DetailPresenterImp(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public void showDetail(MeetingEvent meetingEvent) {
        detailView.showDetails(meetingEvent);
    }

    @Override
    public void requestDetail(long meetingId) {
        //// TODO: 7/21/16 request meeting detail from backend

        detailView.showLoading();
        Observable.just(meetingId)
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long s) {
                        detailView.hideLoading();
                        meetingEvent = new MeetingEvent(s, "会议主题: XXXXXXXX", Calendar.getInstance(), Calendar.getInstance());
                        detailView.showDetails(meetingEvent);
                    }
                });

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
