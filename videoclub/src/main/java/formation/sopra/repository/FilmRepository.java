package formation.sopra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.sopra.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

}
