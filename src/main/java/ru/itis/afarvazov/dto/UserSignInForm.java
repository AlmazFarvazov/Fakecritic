package ru.itis.afarvazov.dto;

import lombok.Data;
import ru.itis.afarvazov.validation.ValidPassword;

import javax.validation.constraints.Email;

@Data
public class UserSignInForm {
    @Email(message = "{errors.incorrect.email}")
    private String email;

    @ValidPassword(message = "{errors.incorrect.password}")
    private String password;
}
