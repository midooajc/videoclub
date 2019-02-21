package formation.sopra.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noFilm;
	@Column
	private String titre;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateSortie;
	@OneToMany(mappedBy = "film", fetch = FetchType.EAGER)
	private List<Article> articles;
	@ManyToMany(mappedBy = "films")
	public List<Realisateur> realisateurs;
	@Version
	private Integer version;

	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(String titre, Date dateSortie, List<Article> articles, List<Realisateur> realisateurs) {
		super();
		this.titre = titre;
		this.dateSortie = dateSortie;
		this.articles = articles;
		this.realisateurs = realisateurs;
	}

	public Long getNoFilm() {
		return noFilm;
	}

	public void setNoFilm(Long noFilm) {
		this.noFilm = noFilm;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	public void setRealisateurs(List<Realisateur> realisateurs) {
		this.realisateurs = realisateurs;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
