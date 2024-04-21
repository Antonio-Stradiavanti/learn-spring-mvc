package ru.manannikov.learnMVC.exception;

public class CustomNotFoundErrorDescription {
    private Integer statusCode;
    private String message;

    public String getMessage() {
        return message;
    }

    public CustomNotFoundErrorDescription() {

    }

    public CustomNotFoundErrorDescription(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
