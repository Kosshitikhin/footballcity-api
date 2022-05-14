package com.kosshitikhin.footballcity.common.rest.exception;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }

    public static ConflictException player() {
        return new ConflictException("Such a player already exists.");
    }

    public static ConflictException team() {
        return new ConflictException("Such a team already exists.");
    }

    public static ConflictException active() {
        return new ConflictException("Such a user already active.");
    }

}
