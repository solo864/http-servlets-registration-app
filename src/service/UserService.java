package service;

import dao.UserDao;
import dto.CreateUserDto;
import entity.UserEntity;
import exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import mapper.UserMapper;
import validator.CreateUserValidation;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    private final UserDao userDao = UserDao.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final CreateUserValidation createUserValidation = CreateUserValidation.getInstance();


    public void saveUser(CreateUserDto userDto) {
        var validationResult = createUserValidation.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        UserEntity userEntity = userMapper.mapDtoToEntity(userDto);
        userDao.save(userEntity);
    }


    public static UserService getInstance() {
        return INSTANCE;
    }

}
