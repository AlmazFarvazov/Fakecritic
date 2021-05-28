package ru.itis.afarvazov.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String source;

    @ManyToOne
    @JoinColumn(name = "game_id")
    @ToString.Exclude
    private Game mediaOfTheGame;

}
