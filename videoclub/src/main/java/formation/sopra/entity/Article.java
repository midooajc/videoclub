package formation.sopra.entity;

import javax.persistence.*;

@Entity
@Table(name = "Article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.STRING, length = 10)

public abstract class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noArticle;
	@Column
	private Integer nbDisques;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emprunteur")
	private Adherent emprunteur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_Id")
	private Film film;
	@Version
	private Integer version;

	public Article() {
	}

	public Article(Integer nbDisques, Adherent emprunteur, Film film) {
		this.nbDisques = nbDisques;
		this.emprunteur = emprunteur;
		this.film = film;
	}

	public Long getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Long noArticle) {
		this.noArticle = noArticle;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	public Adherent getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Adherent emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
