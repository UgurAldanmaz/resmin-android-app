package com.uguraldanmaz.resmin.api;

import android.content.Context;

import com.uguraldanmaz.resmin.ui.activity.AsyncActivity;

import org.json.JSONObject;

/**
 * Created by Ugur Aldanmaz on 12.01.2016 22:03.
 * https://github.com/UgurAldanmaz
 * http://bilprog.org
 * open[at]bilprog[dot]org
 */
public abstract class RestManagerBase {

    protected AsyncActivity context;

    public RestManagerBase(AsyncActivity context) {
        this.context = context;
    }

    protected abstract void DataReceived(JSONObject data);
}
