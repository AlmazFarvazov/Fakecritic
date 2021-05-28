package ru.itis.afarvazov.dto;

import lombok.Data;
import ru.itis.afarvazov.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
public class UserSignUpForm {
    @Email(message = "{errors.incorrect.email}")
    private String email;
    @ValidPassword(message = "{errors.invalid.password}")
    private String password;
    private String nickname;

}
