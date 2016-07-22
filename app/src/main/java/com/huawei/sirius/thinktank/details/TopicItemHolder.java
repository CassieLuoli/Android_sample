package com.huawei.sirius.thinktank.details;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.model.MeetingTopic;
import com.huawei.sirius.thinktank.model.MeetingTopicComments;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Luoli on 7/18/16.
 */
public class TopicItemHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.topic_comments_list)
    LinearLayout commentsList;

    @BindView(R.id.topic_more_comments)
    TextView moreComments;

    private MeetingTopic meetingTopic;

    private boolean isExpanded = false;


    public TopicItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void refreshCellView(final MeetingTopic meetingTopic) {
        isExpanded = false;
        moreComments.setText("查看更多");
        this.meetingTopic = meetingTopic;
        commentsList.removeAllViewsInLayout();
        List<MeetingTopicComments> commentsList = meetingTopic.getCommentses();

        Observable.from(commentsList)
                .first()
                .forEach(new Action1<MeetingTopicComments>() {
                    @Override
                    public void call(MeetingTopicComments meetingTopicComments) {
                        View view = LayoutInflater.from(itemView.getContext())
                                .inflate(R.layout.topic_comments, null);
                        TopicItemHolder.this.commentsList.addView(view);
                    }
                });

    }


    @OnClick(R.id.topic_more_comments)
    public void showMore() {
        showExpandableCommentsList(isExpanded, meetingTopic.getCommentses());
        isExpanded = !isExpanded;
        moreComments.setText(isExpanded ? "收起" : "查看更多");
    }

    private void showExpandableCommentsList(boolean isExpanded, List<MeetingTopicComments> topicCommentses) {
        commentsList.removeAllViewsInLayout();

        if (isExpanded) {
            Observable.from(topicCommentses)
                    .first()
                    .forEach(new Action1<MeetingTopicComments>() {
                        @Override
                        public void call(MeetingTopicComments meetingTopicComments) {
                            View view = LayoutInflater.from(itemView.getContext())
                                    .inflate(R.layout.topic_comments, null);
                            commentsList.addView(view);
                        }
                    });
        } else {
            Observable.from(topicCommentses)
                    .forEach(new Action1<MeetingTopicComments>() {
                        @Override
                        public void call(MeetingTopicComments meetingTopicComments) {
                            View view = LayoutInflater.from(itemView.getContext())
                                    .inflate(R.layout.topic_comments, null);
                            commentsList.addView(view);
                        }
                    });
        }
    }
}
