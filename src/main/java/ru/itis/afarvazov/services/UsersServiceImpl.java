package ru.itis.afarvazov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.afarvazov.dto.UserSignInForm;
import ru.itis.afarvazov.dto.UserSignUpForm;
import ru.itis.afarvazov.exceptions.NoSuchUserException;
import ru.itis.afarvazov.exceptions.UserAlreadyExistException;
import ru.itis.afarvazov.exceptions.WrongEmailOrPasswordException;
import ru.itis.afarvazov.models.Media;
import ru.itis.afarvazov.models.User;
import ru.itis.afarvazov.repositories.UsersRepository;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return usersRepository.findByEmail(email).orElseThrow(NoSuchUserException::new);
    }

    @Override
    public User getUserByNickname(String nickname) {
        return usersRepository.findByNickname(nickname).orElseThrow(NoSuchUserException::new);
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User editUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
        user.setState(User.State.DELETED_STATE);
        return usersRepository.save(user);
    }

    @Override
    public void signIn(UserSignInForm userForm) throws WrongEmailOrPasswordException {
        Optional<User> optionalUser = usersRepository.findByEmail(userForm.getEmail());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(userForm.getPassword(), user.getPassword())) {
                return;
            }
        }
        throw new WrongEmailOrPasswordException("Wrong email or password");
    }

    @Override
    public void signUp(UserSignUpForm userForm) throws UserAlreadyExistException {
        if (usersRepository.findByEmail(userForm.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("User with this email already exist");
        }
        User user = User.builder()
                .email(userForm.getEmail())
                .nickname(userForm.getNickname())
                .password(passwordEncoder.encode(userForm.getPassword()))
                .role(User.Role.USER_ROLE)
                .state(User.State.ACTIVE_STATE)
                .photo(Media.builder()
                        .source("/media/profile_photos/img.png")
                        .build())
                .build();
        usersRepository.save(user);
    }



}
