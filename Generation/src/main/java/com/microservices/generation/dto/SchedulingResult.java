package com.microservices.generation.dto;

/**
 * Created by dionnys on 4/5/16.
 */
public class SchedulingResult {
    private boolean success;
    private String message;

    public SchedulingResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
