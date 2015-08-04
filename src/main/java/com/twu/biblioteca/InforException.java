package com.twu.biblioteca;

import java.io.IOException;

public class InforException extends IOException {
    String exceptionMessage;

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
