package com.kosshitikhin.footballcity.common.rest.exception;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }

    public static ConflictException player() {
        return new ConflictException("Such a player already exists in the team.");
    }

    public static ConflictException team() {
        return new ConflictException("Such a team already exists in the league.");
    }
}
