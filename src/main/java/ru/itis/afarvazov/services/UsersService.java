package ru.itis.afarvazov.services;

import ru.itis.afarvazov.models.User;

public interface UsersService {

    User getUserByEmail(String email);
    User getUserByNickname(String nickname);
    User saveUser(User user);
    User editUser(User user);
    User deleteUser(User user);

}
