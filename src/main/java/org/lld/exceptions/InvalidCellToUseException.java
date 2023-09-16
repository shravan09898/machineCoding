package org.lld.exceptions;

public class InvalidCellToUseException extends RuntimeException{
    public InvalidCellToUseException() {
    }

    public InvalidCellToUseException(String message) {
        super(message);
    }

    public InvalidCellToUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCellToUseException(Throwable cause) {
        super(cause);
    }

    public InvalidCellToUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
