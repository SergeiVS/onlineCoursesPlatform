package tests.test;

import core.dto.errors.ErrorsDto;
import org.junit.jupiter.api.Test;
import services.validation.EmailFormatValidation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailFormatValidationTest {

    @Test
    void validate() {
        EmailFormatValidation validation = new EmailFormatValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        String email = "hot@Test.com";
        var isValid = validation.validate(email, errors);
        Assertions.assertTrue(isValid);
    }
    @Test
    void validateFalseAt() {
        EmailFormatValidation validation = new EmailFormatValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        String email = "hotTest.com";
        var isValid = validation.validate(email, errors);
        Assertions.assertFalse(isValid);
    }
    @Test
    void validateFalseComma() {
        EmailFormatValidation validation = new EmailFormatValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        String email = "h,ot@Test.com";
        var isValid = validation.validate(email, errors);
        Assertions.assertFalse(isValid);
    }

    @Test
    void validateSymbols() {
        EmailFormatValidation validation = new EmailFormatValidation();
        List<ErrorsDto> errors = new ArrayList<>();
        String email = "23-._hdfOLJm@Test.com";
        var isValid = validation.validate(email, errors);
        Assertions.assertTrue(isValid);
    }
}