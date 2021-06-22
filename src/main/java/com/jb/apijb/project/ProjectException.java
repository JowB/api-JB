package com.jb.apijb.project;

public class ProjectException extends Exception{

    public ProjectException(final String message) {
        super(message);
    }

    public ProjectException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
