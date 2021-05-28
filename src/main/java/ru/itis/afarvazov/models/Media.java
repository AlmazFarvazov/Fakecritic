package ru.itis.afarvazov.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Game mediaOfTheGame;

}
