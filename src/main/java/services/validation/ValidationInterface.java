package services.validation;

import core.dto.errors.ErrorsDto;

import java.util.List;

@FunctionalInterface
public interface ValidationInterface <T>{
    boolean validate(T t, List<ErrorsDto> errors);
}
