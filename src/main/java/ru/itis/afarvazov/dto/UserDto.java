package ru.itis.afarvazov.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.afarvazov.models.Corporation;
import ru.itis.afarvazov.models.Media;
import ru.itis.afarvazov.models.Review;
import ru.itis.afarvazov.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String email;
    private String nickname;

    private User.Role role;
    private User.State state;
    private Media photo;
    private Corporation corporation;
    private List<Review> reviews;

    public static UserDto from(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .role(user.getRole())
                .state(user.getState())
                .corporation(user.getCorporation())
                .reviews(user.getReviews())
                .photo(user.getPhoto())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }

}
