package com.kosshitikhin.footballcity.common.rest.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException league() {
        return new NotFoundException("Such a league doesn't exist.");
    }

    public static NotFoundException team() {
        return new NotFoundException("Such a team doesn't exist.");
    }

    public static NotFoundException coach() {
        return new NotFoundException("Such a coach doesn't exist.");
    }

    public static NotFoundException player() {
        return new NotFoundException("Such a player doesn't exist.");
    }

    public static NotFoundException match() {
        return new NotFoundException("Such a match doesn't exist.");
    }

    public static NotFoundException goal() {
        return new NotFoundException("Such a goal doesn't exist.");
    }

    public static NotFoundException card() {
        return new NotFoundException("Such a card doesn't exist.");
    }

    public static NotFoundException assist() {
        return new NotFoundException("Such a assist doesn't exist.");
    }

    public static NotFoundException user() {
        return new NotFoundException("Such a user doesn't exist.");
    }

}
