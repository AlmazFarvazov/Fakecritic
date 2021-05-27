package ru.itis.afarvazov.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String nickname;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    private Media photo;

    @ManyToOne
    @JoinColumn(name = "corp_id")
    private Corporation corporation;

    @OneToMany(mappedBy = "reviewer")
    private List<Review> reviews;

    public boolean isActive() {
        return this.state == State.ACTIVE_STATE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED_STATE;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN_ROLE;
    }

    public enum Role {
        USER_ROLE, ADMIN_ROLE
    }

    public enum State {
        ACTIVE_STATE, BANNED_STATE, DELETED_STATE
    }

}
