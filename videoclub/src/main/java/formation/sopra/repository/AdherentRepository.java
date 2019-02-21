package formation.sopra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

}
