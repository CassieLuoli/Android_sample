package com.hw.sirius.thinktank.data.model;

import java.util.List;

/**
 * Created by Luoli on 7/21/16.
 */
public class MeetingTopic {

    public MeetingTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    String topicName;

    public void setCommentses(List<MeetingTopicComments> commentses) {
        this.commentses = commentses;
    }

    List<MeetingTopicComments> commentses;

    public List<MeetingTopicComments> getCommentses() {
        return commentses;
    }
}
