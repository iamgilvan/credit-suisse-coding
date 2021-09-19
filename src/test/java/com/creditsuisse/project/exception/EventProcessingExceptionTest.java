package com.creditsuisse.project.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.creditsuisse.project.common.constants.Constants.EVENT_CONVERSION;

public class EventProcessingExceptionTest {

    @Test
    public void testEventProcessingException() {
        try {
            throwException();
        } catch (EventProcessingException exception) {
            Assertions.assertEquals(exception.getMessage(), EVENT_CONVERSION);
        }
    }

    private void throwException() {
        throw new EventProcessingException(EVENT_CONVERSION);
    }
}
