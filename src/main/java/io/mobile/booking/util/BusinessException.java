package io.mobile.booking.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BusinessException extends Exception {

    private String code;

    public BusinessException(ErrorMessages message, Object... params) {
        super(String.format(message.getMessage(), params));
        this.code = message.getCode();
    }
}
