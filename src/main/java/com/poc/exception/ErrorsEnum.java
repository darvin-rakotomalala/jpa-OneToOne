package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */

    ERR_MCS_NOTE_TITLE_EMPTY("Error occurred - Note title shouldn't be NULL or EMPTY"),
    ERR_MCS_NOTE_OBJECT_EMPTY("Error occurred - object Note shouldn't be NULL or EMPTY"),
    ERR_MCS_NOTE_NOT_FOUND("Error occurred - no Note found with this id"),
    ERR_MCS_USER_LASTNAME_EMPTY("Error occurred - User lastname shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_PROFILE_GENDER_EMPTY("Error occurred - User gender shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_PROFILE_ADDRESS_EMPTY("Error occurred - User address shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_OBJECT_EMPTY("Error occurred - object or id User shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_PROFILE_OBJECT_EMPTY("Error occurred - object or id User profile shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_NOT_FOUND("Error occurred - no User found with this id"),
    ERR_MCS_USER_PROFILE_NOT_FOUND("Error occurred - no User profile found with this id");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
