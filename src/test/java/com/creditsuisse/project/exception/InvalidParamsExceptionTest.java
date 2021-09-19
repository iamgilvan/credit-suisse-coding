package com.creditsuisse.project.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.creditsuisse.project.common.constants.Constants.INVALID_PARAMS;

public class InvalidParamsExceptionTest {

    @Test
    public void testInvalidParamsException() {
        try {
            throwException();
        } catch (InvalidParamsException invalidParamsException) {
            Assertions.assertEquals(invalidParamsException.getMessage(), INVALID_PARAMS);
        }
    }

    private void throwException() {
        throw new InvalidParamsException(INVALID_PARAMS);
    }
}
