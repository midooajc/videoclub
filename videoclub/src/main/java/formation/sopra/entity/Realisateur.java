package formation.sopra.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

@Entity
public class Realisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noRealisateur;
	@Column
	private String prenom;
	@Column
	private String nom;
	@ManyToMany(mappedBy = "realisateurs")
	@JoinTable(name = "REALISATEUR_FILM", joinColumns = @JoinColumn(name = "REALISATEUR_ID"), inverseJoinColumns = @JoinColumn(name = "FILM_ID"))
	public List<Film> films;
	@Version
	private Integer version;

	public Realisateur() {
		// TODO Auto-generated constructor stub
	}

	public Realisateur(String prenom, String nom, List<Film> films) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.films = films;
	}

	public Long getNoRealisateur() {
		return noRealisateur;
	}

	public void setNoRealisateur(Long noRealisateur) {
		this.noRealisateur = noRealisateur;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
