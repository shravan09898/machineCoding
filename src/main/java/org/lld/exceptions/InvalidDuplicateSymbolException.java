package org.lld.exceptions;

public class InvalidDuplicateSymbolException extends RuntimeException{
    public InvalidDuplicateSymbolException() {
    }

    public InvalidDuplicateSymbolException(String message) {
        super(message);
    }

    public InvalidDuplicateSymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDuplicateSymbolException(Throwable cause) {
        super(cause);
    }

    public InvalidDuplicateSymbolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
