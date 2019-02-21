package formation.sopra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.sopra.entity.Realisateur;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {

}
