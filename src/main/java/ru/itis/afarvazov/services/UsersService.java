package ru.itis.afarvazov.services;

import ru.itis.afarvazov.dto.UserSignInForm;
import ru.itis.afarvazov.dto.UserSignUpForm;
import ru.itis.afarvazov.exceptions.UserAlreadyExistException;
import ru.itis.afarvazov.exceptions.WrongEmailOrPasswordException;
import ru.itis.afarvazov.models.User;

public interface UsersService {

    User getUserByEmail(String email);
    User getUserByNickname(String nickname);
    User saveUser(User user);
    User editUser(User user);
    User deleteUser(User user);

    void signIn(UserSignInForm userForm) throws WrongEmailOrPasswordException;

    void signUp(UserSignUpForm userForm) throws UserAlreadyExistException;

}
