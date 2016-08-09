package com.hw.sirius.thinktank.data.model;

/**
 * Created by Luoli on 7/21/16.
 */
public class MeetingTopicComments {
    private String comments;
    private String author;
    private String authorImage;
    private int like;
    private int dislike;

    public MeetingTopicComments(String comments, String author, String authorImage, int like, int dislike) {
        this.comments = comments;
        this.author = author;
        this.authorImage = authorImage;
        this.like = like;
        this.dislike = dislike;
    }

    public String getComments() {
        return comments;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
    }
}
