package formation.sopra.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Adherent")
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long noAderent;
	@Enumerated(EnumType.STRING)
	private ETitre civilite;
	@Column
	private String prenom;
	@Column
	private String nom;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "Numero_de_porte", length = 200)),
			@AttributeOverride(name = "rue", column = @Column(name = "Nom_de_rue", length = 200)),
			@AttributeOverride(name = "ville", column = @Column(name = "Ville", length = 200)),
			@AttributeOverride(name = "cp", column = @Column(name = "Code_Postal", length = 5)) })
	private Adresse adresse;

	@OneToMany(mappedBy = "emprunteur", fetch = FetchType.EAGER)
	private List<Article> articlesEmpruntes;
	@Version
	private Integer version;

	public Adherent() {

	}

	public Adherent(ETitre civilite, String prenom, String nom, Adresse adresse, List<Article> articlesEmpruntes) {
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.articlesEmpruntes = articlesEmpruntes;
	}

	public Long getNoAderent() {
		return noAderent;
	}

	public void setNoAderent(Long noAderent) {
		this.noAderent = noAderent;
	}

	public ETitre getCivilite() {
		return civilite;
	}

	public void setCivilite(ETitre civilite) {
		this.civilite = civilite;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Collection<Article> getArticlesEmpruntes() {
		return articlesEmpruntes;
	}

	public void setArticlesEmpruntes(List<Article> articlesEmpruntes) {
		this.articlesEmpruntes = articlesEmpruntes;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
