package com.uguraldanmaz.resmin.ui.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.uguraldanmaz.resmin.R;
import com.uguraldanmaz.resmin.api.ApiResponse;
import com.uguraldanmaz.resmin.api.StoryManager;
import com.uguraldanmaz.resmin.model.Story;
import com.uguraldanmaz.resmin.model.StoryResult;
import com.uguraldanmaz.resmin.ui.activity.customview.StorySummaryView;

public class StoryListActivity extends AsyncActivity {

    ScrollView storyListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);

        this.storyListContainer = (ScrollView)findViewById(R.id.storyListContainer);

        this.LoadStories();
    }

    private void LoadStories() {
        new StoryListTask(this.storyListContainer).execute((Void)null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_story_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void DataReceived(Intent data) {

    }


    class StoryListTask extends AsyncTask<Void, Void, ApiResponse<StoryResult>> {

        private ScrollView view;

        StoryListTask(ScrollView container)
        {
            this.view = container;
        }

        @Override
        protected ApiResponse<StoryResult> doInBackground(Void... params) {
            StoryManager storyManager = new StoryManager(StoryListActivity.this);
            return storyManager.Get();
        }

        @Override
        protected void onPostExecute(ApiResponse<StoryResult> response) {
                if(response.isSuccess()){
                    for (Story story : response.getData().getStories())
                    {
                        StorySummaryView storySummaryView = new StorySummaryView(this.view.getContext());
                        storySummaryView.Bind(story);
                        view.addView(storySummaryView);
                    }
                }
        }
    }
}
