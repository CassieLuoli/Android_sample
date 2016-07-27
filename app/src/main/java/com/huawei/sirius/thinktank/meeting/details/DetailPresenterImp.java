package com.huawei.sirius.thinktank.meeting.details;

import com.huawei.sirius.thinktank.meeting.details.interfaces.DetailPresenter;
import com.huawei.sirius.thinktank.meeting.details.interfaces.DetailView;
import com.huawei.sirius.thinktank.data.model.MeetingEvent;
import com.huawei.sirius.thinktank.data.model.MeetingTopic;
import com.huawei.sirius.thinktank.data.model.MeetingTopicComments;

import java.util.ArrayList;
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
    public void requestDetail(final long meetingId) {
        //// TODO: 7/21/16 request meeting detail from backend

        detailView.showLoading();
        Observable.just(meetingId)
                .delay(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long meetingId) {
                        detailView.hideLoading();
                        MeetingEvent meetingEvent = prepareMeetingEventData(meetingId);
                        detailView.showDetails(meetingEvent);
                    }
                });

    }

    private MeetingEvent prepareMeetingEventData(Long s) {
        meetingEvent = new MeetingEvent(s, "会议主题: XXXXXXXX", Calendar.getInstance(), Calendar.getInstance());
        ArrayList<MeetingTopic> topics = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            MeetingTopic meetingTopic = new MeetingTopic("topic name 突破性雙鏡頭 瞬間成就經典");
            ArrayList<MeetingTopicComments> commentsList = new ArrayList<MeetingTopicComments>();
            for (int j = 0; j < 2; j++) {
                MeetingTopicComments comments = new MeetingTopicComments("採用Leica " +
                        "Summarit系列1:2 2/27 ASPH 鏡頭，呈現極高的細緻度，層次更分明，色彩更亮麗。捕捉瞬息精彩，留住經典時刻"
                , "AUTHOR" + j, "imagepath", 3, 1);
                commentsList.add(comments);

            }
            meetingTopic.setCommentses(commentsList);
            topics.add(meetingTopic);
        }
        meetingEvent.setTopicList(topics);
        return meetingEvent;
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
