package formation.sopra.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BluRay")
public class BluRay extends Article {
	private Boolean troisD;

	public Boolean getTroisD() {
		return troisD;
	}

	public void setTroisD(Boolean troisD) {
		this.troisD = troisD;
	}

	public BluRay() {
		// TODO Auto-generated constructor stub
	}

	public BluRay(Integer nbDisques, Adherent emprunteur, Film film) {
		super(nbDisques, emprunteur, film);
		// TODO Auto-generated constructor stub
	}

	public BluRay(Boolean troisD) {
		super();
		this.troisD = troisD;
	}

}
