package com.uguraldanmaz.resmin.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.uguraldanmaz.resmin.api.ApiResponse;

/**
 * Created by Ugur Aldanmaz on 12.01.2016 22:56.
 * https://github.com/UgurAldanmaz
 * http://bilprog.org
 * open[at]bilprog[dot]org
 */
public abstract class AsyncActivity extends AppCompatActivity {

    protected abstract void DataReceived(Intent data);

}
