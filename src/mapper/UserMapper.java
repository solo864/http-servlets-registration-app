package mapper;

import dto.CreateUserDto;
import entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Gender;
import model.Role;
import util.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper {


    private static final UserMapper INSTANCE = new UserMapper();

    public UserEntity mapDtoToEntity(CreateUserDto userDto) {
        return UserEntity.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .role(Role.valueOf(userDto.getRole()))
                .birthday(LocalDateFormatter.format(userDto.getBirthday()))
                .password(userDto.getPassword())
                .gender(Gender.valueOf(userDto.getGender()))
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }


}
