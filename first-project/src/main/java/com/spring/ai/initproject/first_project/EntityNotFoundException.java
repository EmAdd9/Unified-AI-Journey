package com.spring.ai.initproject.first_project;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String failure) {
        super(failure);
    }
}
