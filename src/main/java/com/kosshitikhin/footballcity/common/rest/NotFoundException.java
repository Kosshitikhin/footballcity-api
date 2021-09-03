package com.kosshitikhin.footballcity.common.rest;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException league() {
        return new NotFoundException("Such a league not exists.");
    }

    public static NotFoundException team() {
        return new NotFoundException("Such a team not exists.");
    }

    public static NotFoundException coach() {
        return new NotFoundException("Such a coach not exists.");
    }
}
