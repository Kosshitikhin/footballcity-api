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

    public static NotFoundException player() {
        return new NotFoundException("Such a player not exists in this league.");
    }

    public static NotFoundException match() {
        return new NotFoundException("Such a match not exists in this league.");
    }

    public static NotFoundException goal() {
        return new NotFoundException("Such a goal not exists.");
    }

    public static NotFoundException card() {
        return new NotFoundException("Such a card not exists.");
    }

    public static NotFoundException assist() {
        return new NotFoundException("Such a assist not exists.");
    }

}
