package validator;

import dto.CreateUserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Gender;
import model.Role;
import util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidation implements Validator<CreateUserDto> {

    private static final CreateUserValidation INSTANCE = new CreateUserValidation();


    public static CreateUserValidation getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (object.getGender() == null || Gender.valueOf(object.getGender()) == null) {
            validationResult.add(Error.of("invalid gender", "gender is invalid"));
        }
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid birthday", "birthday is invalid"));
        }
        if (object.getName().length() < 8) {
            validationResult.add(Error.of("invalid name", "name is invalid"));
        }
        if (object.getPassword().length() < 8) {
            validationResult.add(Error.of("invalid password", "password is invalid"));
        }
        if (object.getRole() == null || Role.valueOf(object.getRole()) == null) {
            validationResult.add(Error.of("invalid role", "role is invalid"));
        }
        return validationResult;
    }

}