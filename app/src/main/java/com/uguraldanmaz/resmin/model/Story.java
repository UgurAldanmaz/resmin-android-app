package com.uguraldanmaz.resmin.model;

/**
 * Created by Ugur Aldanmaz on 09.01.2016.
 */
public class Story {

    private int id;

    private int status;
    private String owner;

    private String title;
    private String description;

    private boolean is_nsfw;
    private boolean is_featured;

    private int like_count;
    private int slot_count;
    private int comment_count;

    private StoryCoverImage cover_img;

    private String question;
    private int question_meta;
    private String question_meta_text;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean is_nsfw() {
        return is_nsfw;
    }

    public void setIs_nsfw(boolean is_nsfw) {
        this.is_nsfw = is_nsfw;
    }

    public boolean is_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getSlot_count() {
        return slot_count;
    }

    public void setSlot_count(int slot_count) {
        this.slot_count = slot_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public StoryCoverImage getCover_img() {
        return cover_img;
    }

    public void setCover_img(StoryCoverImage cover_img) {
        this.cover_img = cover_img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestion_meta() {
        return question_meta;
    }

    public void setQuestion_meta(int question_meta) {
        this.question_meta = question_meta;
    }

    public String getQuestion_meta_text() {
        return question_meta_text;
    }

    public void setQuestion_meta_text(String question_meta_text) {
        this.question_meta_text = question_meta_text;
    }
}
