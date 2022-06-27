package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {

    String name;
    String email;
    String password;
    String birthday;
    String role;
    String gender;

}
