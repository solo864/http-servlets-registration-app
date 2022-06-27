package dao;

import entity.UserEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import util.ConnectionManager;

import java.sql.PreparedStatement;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_SQL = """
                        
            INSERT INTO users
            (email, name, birthday, password, role, gender) 
            VALUES 
            (?, ?, ?, ?, ?, ?)
                        
            """;

    @SneakyThrows
    public void save(UserEntity user) {
        try (var connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL)) {
            preparedStatement.setObject(1, user.getEmail());
            preparedStatement.setObject(2, user.getName());
            preparedStatement.setObject(3, user.getBirthday());
            preparedStatement.setObject(4, user.getPassword());
            preparedStatement.setObject(5, user.getRole().name());
            preparedStatement.setObject(6, user.getGender().name());

            preparedStatement.executeUpdate();
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
    }
