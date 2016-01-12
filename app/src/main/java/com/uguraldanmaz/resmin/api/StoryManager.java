package com.uguraldanmaz.resmin.api;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.uguraldanmaz.resmin.model.Story;
import com.uguraldanmaz.resmin.model.StoryCoverImage;
import com.uguraldanmaz.resmin.model.StoryResult;
import com.uguraldanmaz.resmin.ui.activity.AsyncActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ugur Aldanmaz on 10.01.2016.
 */
public class StoryManager extends RestManagerBase {

    private static final String STORY_ADDRESS = "story";

    public StoryManager(AsyncActivity context) {
        super(context);
    }

    @Override
    protected void DataReceived(JSONObject data) {

    }

    public ApiResponse<StoryResult> Get() {
        JSONObject serviceData = ApiCommunicationHelper.get(STORY_ADDRESS);
        return this.ParseStoryJson(serviceData);
    }

    private ApiResponse<StoryResult> ParseStoryJson(JSONObject serviceData) {
        try {

            ArrayList<Story> stories = new ArrayList<>();

            JSONArray storyJsonArray = serviceData.getJSONArray("results");
            for (int i = 0; i < storyJsonArray.length(); i++) {
                JSONObject storyJsonItem = storyJsonArray.getJSONObject(i);

                Story story = new Story();
                story.setComment_count(storyJsonItem.getInt("comment_count"));
                story.setDescription(storyJsonItem.getString("description"));
                story.setId(storyJsonItem.getInt("id"));
                story.setIs_featured(storyJsonItem.getBoolean("is_featured"));
                story.setIs_nsfw(storyJsonItem.getBoolean("is_nsfw"));
                story.setLike_count(storyJsonItem.getInt("like_count"));
                story.setOwner(storyJsonItem.getString("owner"));
                story.setQuestion(storyJsonItem.getString("question"));
                story.setQuestion_meta(storyJsonItem.getInt("question_meta"));
                story.setQuestion_meta_text(storyJsonItem.getString("question_meta_text"));
                story.setSlot_count(storyJsonItem.getInt("slot_count"));
                story.setStatus(storyJsonItem.getInt("status"));
                story.setTitle(storyJsonItem.getString("title"));

                JSONObject coverImageJsonObject = storyJsonItem.getJSONObject("cover_img");
                StoryCoverImage coverImage = new StoryCoverImage();
                coverImage.setHeight(coverImageJsonObject.getInt("height"));
                coverImage.setUrl(coverImageJsonObject.getString("url"));
                coverImage.setWidth(coverImageJsonObject.getInt("width"));

                story.setCover_img(coverImage);

                stories.add(story);
            }

            int count = serviceData.getInt("count");
            String previous = serviceData.getString("previous");
            String next = serviceData.getString("next");

            StoryResult storyResult = new StoryResult(count, previous, next, stories);
            return ApiResponse.Ok(storyResult);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  ApiResponse.NotOk("Hikaye listesi okunurken bir hata meydana geldi."); //TODO: daha uygun bir hata mesaji.
        }
    }
}

