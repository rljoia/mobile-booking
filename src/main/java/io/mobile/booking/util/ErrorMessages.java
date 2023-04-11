package io.mobile.booking.util;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    PHONE_ALREADY_BOOKED("001", "Phone %s, model %s, version %s, is already booked!"),
    PHONE_ALREADY_AVAILABLE("002", "Phone %s, model %s, version %s, is already available!"),
    PHONE_WAS_BOOKED_ANOTHER_TESTER("003", "Phone %s, model %s, version %s, was booked by another tester!");

    private final String code;
    private final String message;

    ErrorMessages(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
