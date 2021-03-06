package com.halzhang.android.apps.startupnews.analytics;

import android.content.Context;
import android.text.TextUtils;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

/**
 * 统计
 * Created by Hal on 15/5/6.
 */
public class Tracker {

    private EasyTracker mEasyTracker;

    private Tracker() {

    }

    private static class InstanceHolder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static Tracker getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init(Context context) {
        mEasyTracker = EasyTracker.getInstance(context);
    }

    public void sendException(String message, Throwable e, boolean fatal) {
        mEasyTracker.send(MapBuilder.createException(TextUtils.isEmpty(message) ? (e == null ? "" : e.getMessage()) : message, fatal).build());
    }

    public void sendEvent(String category, String action, String label, Long value) {
        mEasyTracker.send(MapBuilder.createEvent(category, action, label, value).build());
    }

}
