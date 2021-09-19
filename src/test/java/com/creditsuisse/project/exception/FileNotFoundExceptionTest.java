package com.creditsuisse.project.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.creditsuisse.project.common.constants.Constants.FILE_NOT_FOUND;

public class FileNotFoundExceptionTest {
    @Test
    public void testFileNotFoundException() {
        try {
            throwException();
        } catch (FileNotFoundException fileNotFoundException) {
            Assertions.assertEquals(fileNotFoundException.getMessage(), FILE_NOT_FOUND);
        }
    }

    private void throwException() {
        throw new FileNotFoundException(FILE_NOT_FOUND);
    }
}
