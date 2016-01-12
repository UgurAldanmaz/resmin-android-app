package com.uguraldanmaz.resmin.ui.activity.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uguraldanmaz.resmin.R;
import com.uguraldanmaz.resmin.model.Story;

import java.io.InputStream;

/**
 * Created by Ugur Aldanmaz on 10.01.2016 22:30.
 * https://github.com/UgurAldanmaz
 * http://bilprog.org
 * open[at]bilprog[dot]org
 */

/*
* StoryList icin compound view.
* */
public class StorySummaryView extends LinearLayout {

    private Story story;

    ImageView coverImage;
    TextView question_meta_text;
    TextView owner;

    public StorySummaryView(Context context) {
        super(context);
    }

    public StorySummaryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StorySummaryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.story_summary_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        this.question_meta_text = (TextView) findViewById(R.id.question_meta_text);
        this.owner = (TextView) findViewById(R.id.owner);
        this.coverImage = (ImageView) findViewById(R.id.coverImage);
    }


    public void Bind(Story story) {
        this.story = story;

        this.question_meta_text.setText(story.getQuestion_meta_text());
        this.owner.setText(story.getOwner());
        new DownloadImageTask(this.coverImage).execute(story.getCover_img().getUrl());
    }


    /**
     * Like imageView click.
     * Send like request to the API.
     */
    public void likeStory(View view) {
        //TODO: openStoryDetail
    }

    /*
     * Opens the story detail activity.
     */
    public void openStoryDetail(View view) {
        //TODO: openStoryDetail
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
