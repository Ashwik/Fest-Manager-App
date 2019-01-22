package com.dota.arena2019.model;

public class ResultType1 extends LiveMatchType1 {
    String message,status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
