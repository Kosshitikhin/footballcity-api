package com.kosshitikhin.footballcity.common.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {
    public NotAcceptableException() {
        super("Incorrect data received");
    }

    public NotAcceptableException(String message) {
        super(message);
    }

    public static NotAcceptableException avatarEmpty() {
        return new NotAcceptableException("avatar file is empty");
    }

    public static NotAcceptableException wrongFormat() {
        return new NotAcceptableException("not supported format");
    }

}
