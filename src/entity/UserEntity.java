package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Gender;
import model.Role;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    private Integer id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private Role role;
    private Gender gender;

}
