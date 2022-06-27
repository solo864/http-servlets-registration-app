package exception;

import lombok.Getter;
import validator.Error;

import java.util.List;

public class ValidationException extends RuntimeException{

    @Getter
    private final List<Error> errors;


    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
