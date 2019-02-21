package formation.sopra.entity;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noAderent;
	@Enumerated(EnumType.STRING)
	private Etitre civilite;
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

	@OneToMany(mappedBy = "Adherent", fetch = FetchType.EAGER)
	private Collection<Article> articlesEmpruntes;
	@Version
	private Integer version;
}
