package com.qavi.advertisementfetcher.globalexceptions;

public class RecordAlreadyExists extends RuntimeException{

    public RecordAlreadyExists() {
        super();
    }

    public RecordAlreadyExists(String message) {
        super(message);
    }

    public RecordAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected RecordAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

