package ru.itis.afarvazov.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String summary;
    private LocalDate releaseDate;
    private Byte score;

    @ManyToMany
    @JoinTable(name = "game_genre",
            joinColumns = {@JoinColumn(name = "game_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")})
    private List<Genre> genres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo")
    private Media logo;

    @OneToMany
    @JoinColumn(name = "screen_id")
    private List<Media> screens;

    @ManyToOne
    @JoinColumn(name = "corproration_id")
    private Corporation developer;

}
