package com.mdfilipiaki.appointmentMedical.infra.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -7395385799022695115L;

    private final String message;

    private String field;

    private String detail;

    private final HttpStatus httpStatus;

    public BaseException(final String message, final HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public BaseException(final String message, final String detail, final HttpStatus httpStatus) {
        this(message, httpStatus);
        this.detail = detail;
    }

    public BaseException(final String message, final HttpStatus httpStatus, final Throwable cause) {
        super(message, cause);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public BaseException(final String message, final String detail, final HttpStatus httpStatus, final Throwable cause) {
        this(message, httpStatus, cause);
        this.detail = detail;
    }


}
