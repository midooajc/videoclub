package formation.sopra.entity;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Realisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noRealisateur;
	@Column
	private String prenom;
	@Column
	private String nom;
	@ManyToMany(mappedBy = "realisateurs")
	public Collection<Film> films;
	@Version
	private Integer version;

}
