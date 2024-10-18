package com.l3org.bankingsystem.service.exceptions;

public class FieldValueNotFoundException extends Throwable{
    String fieldName;
    public FieldValueNotFoundException(String message) {
        super(message+" doesn't exist ");
        this.fieldName = message;
    }

    public String getFieldName() {
        return fieldName;
    }
}
