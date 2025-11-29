package com.example.personneproject.Exceptions;


public class PersonneNotFoundException extends RuntimeException {
    public PersonneNotFoundException(String message) {
        super(message);
    }
}

