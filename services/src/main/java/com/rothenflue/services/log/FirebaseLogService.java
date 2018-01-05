package com.rothenflue.services.log;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by apest on 05/01/2018.
 */

public class FirebaseLogService implements ILogService {
    private LogLevel logLevel;

    private FirebaseAnalytics firebaseAnalytics;

    public FirebaseLogService(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public LogLevel getLogLevel() {
        return logLevel;
    }

    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = logLevel;
    }

    @Override
    public void logMessage(String tag, String message, Bundle properties) {
        if (logLevel == LogLevel.All) {
            if (properties == null) {
                properties = new Bundle();
            }
            properties.putString("Message", message);
            firebaseAnalytics.logEvent(tag, properties);
        }
    }

    @Override
    public void logEvent(String tag, String message, Bundle properties) {
        if (logLevel == LogLevel.All || logLevel == LogLevel.Event) {
            if (properties == null) {
                properties = new Bundle();
            }
            properties.putString("Message", message);
            firebaseAnalytics.logEvent(tag, properties);
        }
    }

    @Override
    public void logError(String tag, String message, Exception e, Bundle properties) {
        if (logLevel == LogLevel.All || logLevel == LogLevel.Event || logLevel == LogLevel.Error) {
            if (properties == null) {
                properties = new Bundle();
            }
            properties.putString("Message", message);
            if (e != null) {
                properties.putSerializable("Exception", e);
            }
            firebaseAnalytics.logEvent(tag, properties);
        }
    }
}
