package formation.sopra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

}
