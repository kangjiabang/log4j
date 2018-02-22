package com.kang.log4j.core;

/**
 * @Author：zeqi
 * @Date: Created in 17:52 11/2/18.
 * @Description:
 */
public class LoggEvent {

    private String message;

    private long startTime;

    private String categoryName;

    public LoggEvent(String message, String categoryName) {
        this.startTime = System.currentTimeMillis();
        this.message = message;
        this.categoryName = categoryName;
    }


    public String getMessage() {
        //get source class location info
        LocationInfo location = new LocationInfo(new Throwable(),this.categoryName);
        String locationInfo = location.getLocationInfo();
        return locationInfo + " " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
}
