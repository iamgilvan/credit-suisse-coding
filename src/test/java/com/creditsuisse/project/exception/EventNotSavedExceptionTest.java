package com.creditsuisse.project.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.creditsuisse.project.common.constants.Constants.EVENT_NOT_SAVED;

public class EventNotSavedExceptionTest {

    @Test
    public void testEventNotSavedException() {
        try {
            throwException();
        } catch (EventNotSavedException eventNotSavedException) {
            Assertions.assertEquals(eventNotSavedException.getMessage(), EVENT_NOT_SAVED);
        }
    }

    private void throwException() {
        throw new EventNotSavedException(EVENT_NOT_SAVED);
    }
}
