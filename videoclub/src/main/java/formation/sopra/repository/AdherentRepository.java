package formation.sopra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.sopra.entity.Adherent;


@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Long> {

}
