package com.uguraldanmaz.resmin.model;

import java.util.ArrayList;

/**
 * Created by Ugur Aldanmaz on 10.01.2016 14:20.
 */
public class StoryResult {
    private int count;
    private String next;
    private String previous;

    ArrayList<Story> stories;

    public StoryResult(int count, String next, String previous, ArrayList<Story> stories) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.stories = stories;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public ArrayList<Story> getStories() {
        return stories;
    }

}
