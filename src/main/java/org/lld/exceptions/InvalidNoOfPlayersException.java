package org.lld.exceptions;

public class InvalidNoOfPlayersException extends RuntimeException{
    public InvalidNoOfPlayersException() {
    }

    public InvalidNoOfPlayersException(String message) {
        super(message);
    }

    public InvalidNoOfPlayersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNoOfPlayersException(Throwable cause) {
        super(cause);
    }

    public InvalidNoOfPlayersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
