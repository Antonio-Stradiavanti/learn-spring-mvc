package ru.manannikov.learnMVC.exception;

public class ResourceNotFoundExcetion extends RuntimeException {
    public ResourceNotFoundExcetion(String message) {
        super(message);
    }
}
