package com.bb.planner.exceptions;

public class TaskErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public TaskErrorResponse() {
    }

    public TaskErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
