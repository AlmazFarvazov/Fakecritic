package ru.itis.afarvazov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.afarvazov.models.Media;

import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Long> {

}
