package formation.sopra.entity;

import javax.persistence.*;

@Entity
@Table(name = "Article")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", discriminatorType = DiscriminatorType.STRING, length = 10)

public abstract class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer noArticle;
	@Column
	private Integer nbDisques;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emprunteur")
	private Adherent emprunteur;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film")
	private Film film;
	@Version
	private Integer version;
}
