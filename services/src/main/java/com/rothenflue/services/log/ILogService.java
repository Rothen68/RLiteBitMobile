package com.rothenflue.services.log;

import android.os.Bundle;

/**
 * Created by apest on 05/01/2018.
 */

public interface ILogService {

    LogLevel getLogLevel();

    void setLogLevel(LogLevel level);

    void logMessage(String tag, String message, Bundle properties);

    void logEvent(String tag, String message, Bundle properties);

    void logError(String tag, String message, Exception e, Bundle properties);

    enum LogLevel {
        All,
        Event,
        Error,
        None
    }
}
